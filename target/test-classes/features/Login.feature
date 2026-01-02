@Smoke @Function @Regression
Feature: Login function test
  Login should behave correctly for valid and invalid credentials

  Background:
    Given open chrome
    And go to app link

  @Positive
  Scenario: Check login function with valid credentials
    When enter valid username
    And enter valid password
    And click login button
    Then login should pass and there should be logout button visible

  @Negative
  Scenario: Check login function with invalid credentials
    When enter invalid username
    And enter invalid password
    And click login button
    Then login fails and no logout button

  @Negative
  Scenario: Check login function with empty credentials
    When click login button
    Then login fails and no logout button

  @Negative
  Scenario: Check login function with invalid username and valid password
    When enter invalid username
    And enter valid password
    And click login button
    Then login fails and no logout button

  @Negative
  Scenario: Check login function with empty username and valid password
    When enter valid password
    And click login button
    Then login fails and no logout button

  @Negative
  Scenario: Check login function with valid username and invalid password
    When enter valid username
    And enter invalid password
    And click login button
    Then login fails and no logout button

  @Negative
  Scenario: Check login function with valid username and empty password
    When enter valid username
    And click login button
    Then login fails and no logout button