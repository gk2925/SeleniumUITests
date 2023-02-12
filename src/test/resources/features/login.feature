Feature: Objective of this feature is to test the login functionality for Tour Radar

  Scenario Outline: To verify that login works for valid credentials
    Given User is at the home page of the application and accept the cookies
    And User clicks on the login icon and login button
    And User enters valid set of "<userName>" and "<password>"
    Then User is able to login the application successfully
    Examples:
      | userName           | password |
      | tyagigav@gmail.com | Test1234 |



