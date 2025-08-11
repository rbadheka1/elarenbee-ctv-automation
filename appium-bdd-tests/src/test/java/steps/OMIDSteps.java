package steps;

import io.cucumber.java.en.Then;
import utils.LogcatUtils;

public class OMIDSteps {

    @Then("OMID session start should be logged")
    public void omid_session_start_should_be_logged() {
        LogcatUtils.assertContains("AdSession started");
    }

    @Then("OMID quartile events should be logged")
    public void omid_quartile_events_should_be_logged() {
        LogcatUtils.assertContains("firstQuartile");
        LogcatUtils.assertContains("midpoint");
        LogcatUtils.assertContains("thirdQuartile");
        LogcatUtils.assertContains("complete");
    }

    @Then("OMID session finish should be logged")
    public void omid_session_finish_should_be_logged() {
        LogcatUtils.assertContains("AdSession finished");
    }
}
