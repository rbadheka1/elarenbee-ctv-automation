Feature: Ad Quartile Tracking

  Scenario: OMID quartiles fire during ad playback
    Given the Fire TV app is launched
    When I navigate to a content item with a pre-roll ad
    And I start playback
    Then OMID session start should be logged
    And OMID quartile events should be logged
    And OMID session finish should be logged
