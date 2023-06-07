@Conduit
Feature: Validate Login


  @HappyPath
  Scenario: Validate successful login
    Given that the user enters the login
    When the user enters the email "email" and password "password"
    Then the home screen of the application is displayed

  @UnHappyPath
  Scenario: Validate the mail format
    Given that the user enters the login
    When the user enters the emailFalse "emailFalse" and password "password"
    Then the system shows incorrect format validation

