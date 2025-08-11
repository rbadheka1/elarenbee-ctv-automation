Feature: Playback After Ad Network Drop

  @network
  Scenario: Brief network drop during ad is handled gracefully
    Given the Fire TV app is launched
    When I navigate to a content item with a pre-roll ad
    And I start playback
    Then the pre-roll ad should play to completion
    And content playback should resume successfully
