Feature: Automation Exercise practise

  @login
  Scenario Outline: Login using valid and invalid credentials
    Given "<user>" launch the Automation Exercise UI
    When user logged using "<email>" and "<password>"
    Then user able to see the "<message>"
    Examples:
      | user  | email           | password | message                              |
      | som   | som@getnada.com | Test!    | Logout                               |
      | jai   | som@getnada.com | Test     | Your email or password is incorrect! |
      | nivek | som@getnada.com | Test     | Your password is incorrect!          |