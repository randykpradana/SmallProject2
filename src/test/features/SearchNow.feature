Feature: Search Now functionality

  Scenario: User wants to search hotel
    Given User on the home page
    When Enter hotel location
    And Select hotel
    And Select check in date
    And Select check out date
    And Click search now button
    Then Hotel room list will appear