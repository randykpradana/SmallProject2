Feature: Sign In functionality

  Scenario: Verify register with valid data
    Given User open website URL
    When Click sign in navigation link 3
    And Enter valid email
    And Click create an account
    And Enter personal information
    And Click register button
    Then User successfully register
    And System showed success message box