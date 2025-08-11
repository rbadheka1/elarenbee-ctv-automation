package com.example;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;

@RunWith(AndroidJUnit4.class)
public class ExampleEspressoTest {
  @Test public void header_is_visible() {
    onView(withContentDescription("Header")).check(matches(isDisplayed()));
  }
}
