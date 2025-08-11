package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import utils.FireTVRemoteKeys;
import utils.LogcatUtils;

import java.time.Duration;

public class AdsSteps {
    private AndroidDriver driver;

    @Given("the Fire TV app is launched")
    public void the_fire_tv_app_is_launched() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I navigate to a content item with a pre-roll ad")
    public void i_navigate_to_a_content_item_with_a_pre_roll_ad() {
        // Demo navigation: move focus and select the first item.
        driver.pressKey(FireTVRemoteKeys.RIGHT());
        driver.pressKey(FireTVRemoteKeys.OK());
    }

    @When("I start playback")
    public void i_start_playback() {
        LogcatUtils.startCapture("omid|integral|ias|AdSession|Quartile|complete");
    }

    @Then("the pre-roll ad should play to completion")
    public void the_pre_roll_ad_should_play_to_completion() throws Exception {
        // In a real app, you'd assert a UI element for ad vs content; here we just wait.
        Thread.sleep(15000);
    }

    @Then("content playback should resume successfully")
    public void content_playback_should_resume_successfully() {
        // Example check point (app-specific). Left as a placeholder.
        LogcatUtils.stopCapture();
    }
}
