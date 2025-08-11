package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import utils.FireTVRemoteKeys;

public class NavigationSteps {
    private AndroidDriver driver;

    @Given("the app is on the browse screen")
    public void the_app_is_on_the_browse_screen() {
        driver = DriverFactory.getDriver();
    }

    @When("I move focus right {int} times and down {int} times")
    public void i_move_focus(int right, int down) {
        for (int i=0;i<right;i++) driver.pressKey(FireTVRemoteKeys.RIGHT());
        for (int i=0;i<down;i++) driver.pressKey(FireTVRemoteKeys.DOWN());
    }

    @Then("I should be able to select the focused item")
    public void i_should_be_able_to_select_the_focused_item() {
        driver.pressKey(FireTVRemoteKeys.OK());
    }
}
