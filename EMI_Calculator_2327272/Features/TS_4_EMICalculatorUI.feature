#Author: Mahaning Hubballi 
#Associate id:2327272
#Keywords Summary :
#Scenario Summary :3. From Menu, pick Loan Calculator and under EMI calculator, do all UI check for text box & scales; change the Loan tenure for year & month,check the change in scale; Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator

Feature: EMI Calculator UI check
@functional
  Scenario: Validate the UI features of EMI Calculator
    Given user navigates to EMI Calculator
    When check for loan amount input box 
    And  check for loan amount slider
    Then loan amount slider should be moved to the Some value and respectively loan amount should be displayed
    When check for Intrest input box
    And  check for Intrest slider
    Then loan Intrest slider should be moved to the Some value and respectively Intrest value should be displayed
    When check for loan Tenure input box
    And  check for loan Tenure slider
    Then loan loan Tenure slider should be moved to the Some value and respectively loan Tenure value should be displayed
    When check for Fees & Charges input box
    And  check for Fees & Charges slider
    Then Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed
   @functional 
  Scenario: Validate the UI features of EMI Calculator with input and slider
    Given user navigates to EMI Calculator
    When Enter input value in loan amount input box
    Then loan amount slider should be moved to the same value
    When Enter input value in Intrest input box
    Then Intrest slider should be moved to the same value
    When Enter input value in loan Tenure input box
    Then loan Tenure slider should be moved to the same value
    When Enter input value in Fees & Charges input box
    Then Fees & Charges slider should be moved to the same value