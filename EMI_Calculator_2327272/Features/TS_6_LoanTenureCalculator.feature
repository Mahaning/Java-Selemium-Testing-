#Author: Mahaning Hubballi 
#Associate id:2327272
#Keywords Summary :
#Scenario Summary :3. From Menu, pick Loan Calculator and under EMI calculator, do all UI check for text box & scales; change the Loan tenure for year & month,check the change in scale; Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator

Feature: Loan Tuner Calculator UI check
  @functional
  Scenario: Validate the UI features of Loan Tenure Calculator
    Given user navigates to Loan Tuner Calculator
    When check for Loan Tenure amount input box
    And  check for Loan Tenure amount slider
    Then Loan TenureEMI slider should be moved to the Some value and respectively EMI should be displayed
    When check for Loan Tenure EMI input box
    And  check for Loan Tenure EMI slider
    Then Loan Tenure EMI slider should be moved to the Some value and respectively EMI value should be displayed
    When check for Loan Tenure Intrest Rate input box
    And  check for Loan Tenure Intrest Rate slider
    Then loan Tenure Intrest Rate slider should be moved to the Some value and respectively loan Intrest Rate value should be displayed
    When check for Loan Tenure Fees & Charges input box
    And  check for Loan Tenure Fees & Charges slider
    Then Loan Tenure Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed
    
     @functional 
  Scenario: Validate the UI features of Loan Tenure Calculator with input and slider
    Given user navigates to Loan Tuner Calculator
    When Enter input value in loan amount input box of Loan Tenure Calculator
    Then loan amount slider should be moved to the same value of the scale on Scale
 
    When Enter input value in Intrest input box of Loan Tenure Calculator
    Then Intrest slider should be moved to the same value on the scale
    
    When Enter input value in Fees & Charges input box of Loan Tenure Calculator
    Then Fees & Charges slider should be moved to the same value on the scale