Feature: Used Cars in Chennai

  Scenario: Display popular used car models and price in Chennai
    Given the user has the car sales website open in their browser
    When the user hovers over the Used Cars link
    And the user selects Chennai from the dropdown
    And the user scrolls down to the list of popular models
    Then the user should extract all the popular models in a List
    And the user displays the same in the console