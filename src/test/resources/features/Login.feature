@FirstRelease
Feature: Login functionality

  @Positive
  Scenario Outline: Ensure user succesfully login
    # precondition
    Given user is on orange hrm homepage
    #steps
    When user input <username> as username
    And user input <password> as password
    And user click enter
    # expected
    Then user verify <status> login result

    Examples:
      | username | password      | status  |
      | Admin    | admin123      | success |