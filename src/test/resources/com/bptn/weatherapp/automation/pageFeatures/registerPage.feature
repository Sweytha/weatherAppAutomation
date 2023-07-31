Feature: Register a New User

  # RegisterPageSteps
@WebTest
  Scenario: Success - Create a new User Account on the WeatherApp
    Given User is on the register page "/signup"
    When User register into application with the following user details:
      | firstName | Sarah               |
      | lastName  | Johnson             |
      | username  | sjohnson84          |
      | password  | Hello@123           |
      | phone     |           647123456 |
      | email     | sj7061132@gmail.com |
    And User click 'Register' on signup page
    Then User should see the message "Congratulations on successfully signing up!!  Verification email has been sent to sj7061132@gmail.com" on signup page
    

  @WebTest
  Scenario: Failure - Create a new User Account on the WeatherApp - User already Exists
    Given User is on the register page "/signup"
    When User register into application with the following user details:
      | firstName | Sarah               |
      | lastName  | Johnson             |
      | username  | sjohnson84          |
      | password  | Hello@123           |
      | phone     |           647123456 |
      | email     | sj7061132@gmail.com |
    And User click 'Register' on signup page
    Then User should see the message "Username already exists, sjohnson84" on signup page

  @WebTest
  Scenario: Failure - Create a new User Account on the WeatherApp - Email already Exists
    Given User is on the register page "/signup"
    When User register into application with the following user details:
      | firstName | Sarah               |
      | lastName  | Johnson             |
      | username  | sjohnson85          |
      | password  | Hello@123           |
      | phone     |           647123456 |
      | email     | sj7061132@gmail.com |
    And User click 'Register' on signup page
    Then User should see the message "Email already exists, sj7061132@gmail.com" on signup page
