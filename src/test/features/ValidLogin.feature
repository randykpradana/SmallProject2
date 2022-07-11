Feature: Sign In functionality

  Scenario: Verify login with valid data
    Given User access the website URL
    When Click sign in navigation link 1
    And Enter valid email and valid password
    And Click sign in button 1
    Then User successfully logged in
    And Able to see My Account page