@WeatherTest
Feature: Application Weather EndPoints

  @GetWeatherByCityNameValidTest
  Scenario: Success - Get Weather By City Name API Call
    Given a valid user token for username "carlos"
     When a 'GET' request is made to "/weathers/paris/true" API
     Then the response status code should be 200
      And Weather JSON Data received matches latest city searched by username "carlos" in weather DB

  @GetWeatherByCityNameInValidTest
  Scenario: Failure - Get Weather By City Name API Call - Token Expired  
    Given an expired user token for username "carlos"
     When a 'GET' request is made to "/weathers/paris/true" API
     Then the response status code should be 401
      And the response body should contain the error message "Token has Expired"

  @GetWeathersValidTest
  Scenario: Get Weather records By User API Call
    Given a valid user token for username "carlos"
     When a 'GET' request is made to "/weathers" API
     Then the response status code should be 200
      And Weather JSON Data received matches weather records searched by username "carlos" in weather DB

  @GetWeathersInValidTest
  Scenario: Failure - Get Weather records By User API Call - Token Expired 
    Given an expired user token for username "carlos"
     When a 'GET' request is made to "/weathers" API
     Then the response status code should be 401
      And the response body should contain the error message "Token has Expired"
