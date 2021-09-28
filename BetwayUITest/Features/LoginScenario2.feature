Feature: As a QA, I would like to verify all negative scenarios for login
  Scenario: When user enters invalid username and invalid password input field empty
    Given has launched browser and navigated to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When user click on sign in link
    Then user enters username "hello584" and password "12338" input fields
    Then user click on sign in button
    Then display and error message
