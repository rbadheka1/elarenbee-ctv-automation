package com.example;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DpadSmokeTest {
  @Test public void pressSomeKeys() {
    UiDevice d = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    d.pressDPadRight(); d.pressDPadCenter();
  }
}
