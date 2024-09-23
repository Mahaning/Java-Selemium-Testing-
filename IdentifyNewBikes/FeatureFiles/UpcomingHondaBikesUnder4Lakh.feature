Feature: View upcoming Honda bikes under 4Lakh from ZigWheels.

  Scenario: Display upcoming Honda bike name, price and expected launch date under 4Lakh from ZigWheels website.
    Given the user is on the ZigWheels website
    When the user hovers over the New Bikes section
    And the user selects Upcoming Bikes from the dropdown
    And the user sets the filter Manufacturer to Honda
    And the user scrolls and clicks on the View More button
    Then the user should filter out the displayed Honda bikes with a price less than 4Lakh
    And for each bike priced under 4Lakh should be added to their respective lists
