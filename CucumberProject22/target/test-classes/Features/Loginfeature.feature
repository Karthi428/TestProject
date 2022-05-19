Feature: Test Login functionality

  @Login
  Scenario: Verify user is able to login with valid credentials
    Given browser is open
    And user is on login page
    When user enters valid credentials
      | username | password |
      | Karthi   |    12345 |
    And clicks on login button
    Then user is navigated to TestProject Example page

  @Homepage
  Scenario: Verify user is able to fill TestProject Example page
    Given browser is open
    And user is on login page
    When user enters valid credentials
      | username | password |
      | Karthi   |    12345 |
    And clicks on login button
    Then user is navigated to TestProject Example page
    When user fill TestProject Example page
      | Country | Address | Email        | Phone      |
      | India   | chennai | ss@gmail.com | 9876543210 |
    And click save button
    Then user is able to fill TestProject Example page
