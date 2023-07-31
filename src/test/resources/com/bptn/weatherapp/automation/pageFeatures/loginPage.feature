Feature: Login Page and Email verification
  

  # LoginPageSteps
  @WebTest
  Scenario: Failure - User Login - Email Not Verified
    Given User is on the login page "/login"
     When User login into application with "sjohnson84" and password "Hello@123"
      And User click 'Submit' on login page
     Then User should see the message "Email requires verification, sj7061132@gmail.com" on login page

  # VerifyEmailPageSteps
  @WebTest
  Scenario: Success - Verify Email - New User
    Given User "sjohnson84" has an email with a valid JWT token
     When User is on verify email page "/verify/"
     And User click 'Verify Email' on verify email page
     Then User should see the message "Congratulations your email has been successfully verified" on verify email page.

  # LoginPageSteps
  @WebTestOutline
  Scenario Outline: Failure - User Login - Invalid Credentials
    Given User is on the login page "/login"
     When User login into application with "<username>" and password "<password>"
      And User click 'Submit' on login page
     Then User should see the message "Username or Password is Incorrect. Please try again" on login page

    Examples:
       |username |password     |
       |bad-user-1 |badPassword@1 |
       |bad-user-2 |badPassword@2 |

  @WebTest
  Scenario: Success - User Login - Welcome Page
    Given User is on the login page "/login"
     When User login into application with "sjohnson84" and password "Hello@123"
      And User click 'Submit' on login page
     Then User should navigate to "/" from login


