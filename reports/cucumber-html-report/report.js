$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test1.feature");
formatter.feature({
  "line": 2,
  "name": "Test Project Dashboard Client App",
  "description": "",
  "id": "test-project-dashboard-client-app",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@run"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Launch Client App",
  "description": "",
  "id": "test-project-dashboard-client-app;launch-client-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I launch Chrome Browser and go to \"http://localhost:9000/\" link",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I am on \"Project Dashboard\" page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I verify \"Statistics\" record is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I verify \"Controls\" block is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I verify \"Search\" textbox is displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:9000/",
      "offset": 35
    }
  ],
  "location": "Test1StepDefinition.I_launch_Chrome_Browser(String)"
});
formatter.result({
  "duration": 14004614275,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Project Dashboard",
      "offset": 9
    }
  ],
  "location": "Test1StepDefinition.iAmOnPage(String)"
});
formatter.result({
  "duration": 27807836,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Statistics",
      "offset": 10
    }
  ],
  "location": "Test1StepDefinition.iVerifyRecordIsDisplayed(String)"
});
formatter.result({
  "duration": 82110,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Controls",
      "offset": 10
    }
  ],
  "location": "Test1StepDefinition.iVerifyRecordIsDisplayed(String)"
});
formatter.result({
  "duration": 71846,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search",
      "offset": 10
    }
  ],
  "location": "Test1StepDefinition.iVerifyRecordIsDisplayed(String)"
});
formatter.result({
  "duration": 71357,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#  Scenario: Search Existing record"
    },
    {
      "line": 13,
      "value": "#    Given I am on \"Project Dashboard\" page"
    },
    {
      "line": 14,
      "value": "#    When I search for \"Accounting\""
    },
    {
      "line": 15,
      "value": "#    Then I get all \"Accounting\" division records displayed"
    },
    {
      "line": 16,
      "value": "#"
    },
    {
      "line": 17,
      "value": "#  Scenario: Search Non-Existing record"
    },
    {
      "line": 18,
      "value": "#    Given I am on \"Project Dashboard\" page"
    },
    {
      "line": 19,
      "value": "#    When I search for \"HR\""
    },
    {
      "line": 20,
      "value": "#    Then I get no records displayed"
    }
  ],
  "line": 22,
  "name": "Search multiple records (AND)",
  "description": "",
  "id": "test-project-dashboard-client-app;search-multiple-records-(and)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "I am on \"Project Dashboard\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "I search for \"Accounting Richard Henry\"",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "I get records having all property values Accounting AND Richard Henry",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Project Dashboard",
      "offset": 9
    }
  ],
  "location": "Test1StepDefinition.iAmOnPage(String)"
});
formatter.result({
  "duration": 23602644,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounting Richard Henry",
      "offset": 14
    }
  ],
  "location": "Test1StepDefinition.iSearchForDivision(String)"
});
formatter.result({
  "duration": 872345729,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounting AND Richard Henry",
      "offset": 41
    }
  ],
  "location": "Test1StepDefinition.iGetAllRecordsHavingAllPropertyValues(String)"
});
formatter.result({
  "duration": 247129335,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Search multiple records (OR)",
  "description": "",
  "id": "test-project-dashboard-client-app;search-multiple-records-(or)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "I am on \"Project Dashboard\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I search for \"Accounting, Henry\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I get records having either property values Accounting OR Henry",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Project Dashboard",
      "offset": 9
    }
  ],
  "location": "Test1StepDefinition.iAmOnPage(String)"
});
formatter.result({
  "duration": 8277933,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounting, Henry",
      "offset": 14
    }
  ],
  "location": "Test1StepDefinition.iSearchForDivision(String)"
});
formatter.result({
  "duration": 1438327756,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Accounting OR Henry",
      "offset": 44
    }
  ],
  "location": "Test1StepDefinition.iGetRecordsHavingEitherPropertyValues(String)"
});
formatter.result({
  "duration": 917750467,
  "status": "passed"
});
});