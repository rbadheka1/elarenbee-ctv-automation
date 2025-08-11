package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ADBUtils {
  private static String sh(String cmd) throws Exception {
    Process p = new ProcessBuilder("bash","-lc",cmd).start();
    p.waitFor();
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    StringBuilder sb = new StringBuilder(); String line;
    while ((line = br.readLine()) != null) sb.append(line).append("\n");
    return sb.toString();
  }
  public static String meminfo(String pkg){ try { return sh("adb shell dumpsys meminfo " + pkg); } catch(Exception e){return e.toString();} }
  public static String gfxinfo(String pkg){ try { return sh("adb shell dumpsys gfxinfo " + pkg); } catch(Exception e){return e.toString();} }
  public static String top(){ try { return sh("adb shell top -n 1"); } catch(Exception e){return e.toString();} }
  public static void toggleWifi(boolean enable){ try { sh("adb shell svc wifi " + (enable? "enable":"disable")); } catch(Exception ignored){} }
}
