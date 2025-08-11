package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static AndroidDriver driver;
    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                String appiumUrl = System.getProperty("appium.url","http://127.0.0.1:4723");
                String pkg = System.getProperty("app.pkg","com.google.android.exoplayer2.demo");
                String act = System.getProperty("app.act","com.google.android.exoplayer2.demo.MainActivity");

                UiAutomator2Options o = new UiAutomator2Options();
                o.setPlatformName("Android");
                o.setAutomationName("UiAutomator2");
                o.setDeviceName("Amazon Fire TV");
                o.setAppPackage(pkg);
                o.setAppActivity(act);
                o.setNewCommandTimeout(Duration.ofSeconds(300));

                driver = new AndroidDriver(new URL(appiumUrl), o);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }
    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
