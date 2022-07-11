Feature: Sign In functionality

  Scenario: Verify login with invalid data
    Given Access website URL
    When Click sign in navigation link 2
    And Enter invalid email and password
    And Click sign in button 2
    Then User failed to login
    And Pop up error message box