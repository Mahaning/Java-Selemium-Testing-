#Author: Mahaning Hubballi 
#Associate id:2327272
#Keywords Summary :
#Scenario Summary :3. From Menu, pick Loan Calculator and under EMI calculator, do all UI check for text box & scales; change the Loan tenure for year & month,check the change in scale; Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator

Feature: Loan Amount Calculator UI check
  @functional
  Scenario: Validate the UI features of Loan Amount Calculator
    Given user navigates to Loan Amount Calculator
    When check for EMI input box 
    And  check for EMI slider
    Then EMI slider should be moved to the Some value and respectively EMI should be displayed
    When check for Loan Amount Intrest input box
    And  check for Loan Amount Intrest slider
    Then Loan Amount loan Intrest slider should be moved to the Some value and respectively Intrest value should be displayed
    When check for Loan Amount loan Tenure input box
    And  check for Loan Amount loan Tenure slider
    Then Loan Amount loan loan Tenure slider should be moved to the Some value and respectively loan Tenure value should be displayed
    When check for Loan Amount Fees & Charges input box
    And  check for Loan Amount Fees & Charges slider
    Then Loan Amount Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed
  @functional 
  Scenario: Validate the UI features of Loan Amount Calculator with input and slider
    Given user navigates to Loan Amount Calculator
    When Enter input value in EMI input box
    Then EMI slider should be moved to the same value of the scale
    
    When Enter input value in Intrest input box of Loan Amount Calculator
    Then Intrest slider should be moved to the same value of the scale
    
    When Enter input value in loan Tenure input box of Loan Amount Calculator
    Then loan Tenure slider should be moved to the same value of the scale
    
    When Enter input value in Fees & Charges input box of Loan Amount Calculator
    Then Fees & Charges slider should be moved to the same value of the scale