@frametest
Feature: Frame example
  A page has one frame

  @oneframe
  Scenario: Jenkins test which has one frame
    Given user enter the url
    When finnd out the frame
    Then validate the element of frame
