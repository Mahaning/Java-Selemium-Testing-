Feature: Runnable

  @smoke @functional
  Scenario: Check whether the application can be accessed
    Given the user navigates to the Application
    Then the page title has to be displayed
