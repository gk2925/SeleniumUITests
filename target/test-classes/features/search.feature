Feature: Objective of this feature is to test the search feature

  Scenario: To verify that search works as expected with application
    Given User is at the home page of the application and accept the cookies
    And User clicks "BERLIN" as city name in the search bar
    And User clicks on the valid autosuggestion
    Then User able to see the list of results which are by default "15" in number
    And In the first search result "View tour" button is present
    And In the first search result "Download Brochure" button is displayed


