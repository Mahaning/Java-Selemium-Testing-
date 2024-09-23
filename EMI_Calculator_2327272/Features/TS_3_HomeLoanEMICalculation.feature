#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario Summary :From Menu, pick Home Loan EMI Calculator, fill relevant details & extract all the data from  year on year table & store in excel;


Feature: Home Loan EMI Calculation
@regression @functional
  Scenario: Calculation of Home Loan EMI
    Given the user navigates to Home Loan EMI Calculator
    When the user fills the relevant details
    Then extract the data from year on year table to excel