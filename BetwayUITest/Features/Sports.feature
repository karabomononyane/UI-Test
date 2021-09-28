Feature: As a sports user, I would like to read about all articles related to sports

  Scenario Outline: Output the first heading and the last heading returned on the page
    Given User has searched for all articles related to <label> and user navigated to <url>
    Then Output the first heading and the last heading returned on the page.
    Examples:
      | label    | url                                                    |
      | "sports" | "https://www.bbc.co.uk/sport/football/scores-fixtures" |
