Feature: Ad Skip Behavior

  @optional
  Scenario: Verify skip button and resume (if supported by the sample)
    Given the Fire TV app is launched
    When I navigate to a content item with a pre-roll ad
    And I start playback
    Then the pre-roll ad should play to completion
    And content playback should resume successfully
