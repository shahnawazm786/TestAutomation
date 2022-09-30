@shadowelement
Feature: Find the shadow element inside the iframe
  I want to access the shadow element which is inside the iframe

  @inputelement
  Scenario: Shadow Element Input
    Given user navigate the url
    And user switch to iframe
    When user add data into in input box
    Then verify data is added
    