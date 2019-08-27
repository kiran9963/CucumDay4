@tag
Feature: Provide details using single dimensional list
  I want to use this template for my feature file

  @tag1
  Scenario: Providing data using list
    Given User should  launch the browser
    And User click the add customer button
    When User provide valid details of customer
      | kranti | kiran | kranthi@gmail.com | andhra | 9885398386 |
    Then verify the customer id is displayed
