Feature: Current Weather and History Weather

  @WebTest
  Scenario: Display current and historical weather data for a specific city
    Given the user is on the welcome page "/"
    When User clicks on "Live Weather Data" which navigates to current weather page
    When the user searches for the city "Paris"
    And User clicks on the 'Search' button to retrieve current weather for city
    Then the current weather for "Paris" should be displayed
    When User clicks on "History Weather Data" which navigates to history weather page
    Then the history weather data for "Paris" should be displayed
