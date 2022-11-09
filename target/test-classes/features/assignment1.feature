Feature: Register and Login to elearning upskills website and send an email

  Background: 
    Given User is on elearning upskills website login screen

  Scenario: Register to the elearning upskills by filling all the required details
    When user clicks Sign up link
    Then user is navigated to the registration page
    When user fills all the mandatory fields
    And clicks Register button
    Then user is registered succesfully and user logs out

  Scenario: Login to elearning upskills website with valid credentials
    When user enters the valid username and password
    And clicks Login button
    Then user is navigated to My courses screen
    When user clicks Inbox link
    And clicks Compose icon
    And enter three characters
    And chooses a value from the autosuggest list
    And enters Subject text
    When user clicks Send message button
    Then mail is sent succesfully with validation message shown
    