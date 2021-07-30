Feature: Ebay Advanced Search Page

  @AdvancedSearch
  Scenario: Ebay logo on Advanced Search page
    Given I am Advanced search page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @AdvancedSearch
  Scenario: Advanced search an item
    Given Iam Ebay Advanced Search page
    When I advance search an item
      | keyword   | exclude     | min | max |
      | iphone 11 | refirbished | 300 | 900 |
