Feature: Pre-roll Ad Playback

  As a QA engineer
  I want to verify pre-roll ads play before content on Fire TV
  So that ad delivery and content playback meet expected standards

  Scenario: Play a pre-roll ad and resume content
    Given the Fire TV app is launched
    When I navigate to a content item with a pre-roll ad
    And I start playback
    Then the pre-roll ad should play to completion
    And OMID session start should be logged
    And OMID quartile events should be logged
    And OMID session finish should be logged
    And content playback should resume successfully
