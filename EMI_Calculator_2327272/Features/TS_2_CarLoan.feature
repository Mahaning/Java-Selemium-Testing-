#Author: Mahaning Hubballi 
#Associate id:2327272
#Keywords Summary :
#Scenario Summary :Find the EMI for Car with price of 15 Lac, Interest rate of 9.5% & Tenure 1 year; Display the interest amount & principal amount for one month


Feature: Car Loan EMI Calculation
@regression @functional
  Scenario: Calculation of car loan
    Given the user navigates to Car Loan section
    When user enters the Car Loan Amount
    And user enters the Interest Rate
    And user enters the Loan Tenure
    Then display interest and principal amount on console