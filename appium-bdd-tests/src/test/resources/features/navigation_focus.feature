Feature: D-pad Focus Navigation

  Scenario: Move focus and select item
    Given the app is on the browse screen
    When I move focus right 2 times and down 1 times
    Then I should be able to select the focused item
