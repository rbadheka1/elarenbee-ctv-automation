package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;

public class LogcatUtils {
  private static Process proc;
  private static final List<String> buffer = Collections.synchronizedList(new ArrayList<>());
  private static Pattern pattern;

  public static void startCapture(String regex) {
    stopCapture();
    pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    try {
      proc = new ProcessBuilder("bash","-lc","adb logcat").start();
      Thread t = new Thread(() -> {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8))) {
          String line;
          while ((line = br.readLine()) != null) {
            if (pattern.matcher(line).find()) {
              buffer.add(line);
            }
          }
        } catch (IOException ignored) {}
      });
      t.setDaemon(true);
      t.start();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void stopCapture() {
    if (proc != null) {
      proc.destroy();
      proc = null;
    }
  }

  public static void assertContains(String needle) {
    for (String s : buffer) {
      if (s.toLowerCase().contains(needle.toLowerCase())) return;
    }
    throw new AssertionError("Expected log line containing: " + needle + " (found " + buffer.size() + " filtered lines)");
  }

  public static List<String> getCaptured() { return new ArrayList<>(buffer); }
}
