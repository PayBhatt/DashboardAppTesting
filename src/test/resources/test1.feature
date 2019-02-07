@run
Feature: Test Project Dashboard Client App

  Scenario: Launch Client App and verify components present
    Given I launch Chrome Browser and go to http://localhost:9000/ link
    When I am on Project Dashboard page
    Then I verify Statistics block is displayed
    And I verify Controls block is displayed
    And I verify Search textbox is displayed

  Scenario: Search Existing record
    Given I am on Project Dashboard page
    When I search for Accounting
    Then I get all Accounting division records displayed

  Scenario: Search Non-Existing record
    Given I am on Project Dashboard page
    When I search for HR
    Then I get no records displayed

  Scenario: Search records using multiple properties (Logical AND operator)
    Given I am on Project Dashboard page
    When I search for Accounting Richard Henry
    Then I get records having all property values Accounting AND Richard Henry

  Scenario: Search records using multiple properties (Logical OR operator)
    Given I am on Project Dashboard page
    When I search for Accounting, Henry
    Then I get records having either property values Accounting OR Henry

