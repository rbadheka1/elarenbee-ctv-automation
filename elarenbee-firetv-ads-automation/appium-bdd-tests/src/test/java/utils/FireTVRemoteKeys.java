package utils;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FireTVRemoteKeys {
  public static KeyEvent UP() { return new KeyEvent(AndroidKey.DPAD_UP); }
  public static KeyEvent DOWN() { return new KeyEvent(AndroidKey.DPAD_DOWN); }
  public static KeyEvent LEFT() { return new KeyEvent(AndroidKey.DPAD_LEFT); }
  public static KeyEvent RIGHT() { return new KeyEvent(AndroidKey.DPAD_RIGHT); }
  public static KeyEvent OK() { return new KeyEvent(AndroidKey.DPAD_CENTER); }
  public static KeyEvent BACK() { return new KeyEvent(AndroidKey.BACK); }
  public static KeyEvent HOME() { return new KeyEvent(AndroidKey.HOME); }
}
