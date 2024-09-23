package stepDefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EmiCalculatorHomePage;
import pageObjects.LoanCalculatorPage;
import utilities.AddFluentWait;
import utilities.Assertions;

public class LoanTenureCalculator {
	WebDriver driver = BaseClass.getDriver();
	public static Properties p;
	public static String[] data;
	static String excelFilePath = System.getProperty("user.dir") + "\\testData\\mydata.xlsx";
	public Logger logger = (Logger) LogManager.getLogger(this.getClass());
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();

	EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
	LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

	@Given("user navigates to Loan Tuner Calculator")
	public void user_navigates_to_Loan_Tenure_Calculator() {
		// Waiting for the main menu to load
		wait.waitForMainMenu(driver);

		// Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("check for Loan Tenure amount input box")
	public void validateLoanAmountTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_33_LoanTenureCalculator_ValidatingLoanAmountTextBox Started ----");
		try {
//			Thread.sleep(5000);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Amount Text Box is visible
			Thread.sleep(5000);
			if (loanCalculatorPageObj.getLoanAmtTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_33_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Amount Text Box is enabled
			if (loanCalculatorPageObj.getLoanAmtTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_33_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
				myAssert.fail();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_33_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_33_LoanTenureCalculator_ValidatingLoanAmountTextBox Ended ----\n");
	}

	@When("check for Loan Tenure amount slider")
	public void validateLoanAmountSliderOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_34_LoanTenureCalculator_ValidatingLoanAmountSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Amount Slider is visible
			if (loanCalculatorPageObj.getLoanAmtSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Amount Slider is enabled
			if (loanCalculatorPageObj.getLoanAmtSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_34_LoanTenureCalculator_ValidatingLoanAmountSlider Ended ----\n");
	}

	@Then("Loan TenureEMI slider should be moved to the Some value and respectively EMI should be displayed")
	public void validating_Data_FlowBetween_Loan_Amount_SliderAndTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_35_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveLoanAmtSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000","The initial value of the loan amount textbox is not 10,00,000");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveLoanAmtSlider(130);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getLoanAmtTextBoxValue().equals("50,00,000")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_35_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_35_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_35_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Tenure EMI input box")
	public void validatingValidatingEMITextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_36_LoanTenureCalculator_ValidatingEMITextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if EMI Text Box is visible
			if (loanCalculatorPageObj.getEMITextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_36_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if EMI Text Box is enabled
			if (loanCalculatorPageObj.getEMITextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_36_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_36_LoanTenureCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_36_LoanTenureCalculator_ValidatingEMITextBox Ended ----\n");
	}

	@When("check for Loan Tenure EMI slider")
	public void validatingEMISliderOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_37_LoanTenureCalculator_ValidatingEMISlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if EMI Slider is visible
			if (loanCalculatorPageObj.getEMISlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_37_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
				myAssert.fail();
			}

			// Validating if EMI Slider is enabled
			if (loanCalculatorPageObj.getEMISlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_37_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_37_LoanTenureCalculator_ValidatingEMISlider got failed, validation of EMI Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_37_LoanTenureCalculator_ValidatingEMISlider Ended ----\n");
	}

	@Then("Loan Tenure EMI slider should be moved to the Some value and respectively EMI value should be displayed")
	public void validatingDataFlowBetweenEMISliderAndTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_38_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(2000);
			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveEMISlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getEMITextBoxValue(), "46,674.07","The initial value of the emi textbox is not 21,617.95");
			Thread.sleep(5000);
			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveEMISlider(185);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getEMITextBoxValue().equals("74,984.27")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_38_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_38_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_38_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Tenure Intrest Rate input box")
	public void validateInterestRateTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_39_LoanTenureCalculator_ValidatingInterestRateTextBox Started ----");
		try {

			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Text Box is visible
			if (loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_39_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Text Box is enabled
			if (loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_39_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_39_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_39_LoanTenureCalculator_ValidatingInterestRateTextBox Ended ----\n");
	}

	@When("check for Loan Tenure Intrest Rate slider")
	public void validatingInterestRateSliderOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_40_LoanTenureCalculator_ValidatingInterestRateSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Slider is visible
			if (loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_40_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Slider is enabled
			if (loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_40_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_40_LoanTenureCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_40_LoanTenureCalculator_ValidatingInterestRateSlider Ended ----\n");
	}

	@Then("loan Tenure Intrest Rate slider should be moved to the Some value and respectively loan Intrest Rate value should be displayed")
	public void validateDataFlowBetweenInterestRateSliderAndTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_41_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveIntRateSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75","The initial value of the interest rate textbox is not 10.75");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveIntRateSlider(112);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_41_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

			logger.error("TestCase_03_41_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_41_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Tenure Fees & Charges input box")
	public void validateFeesAndChargesTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_42_LoanTenureCalculator_ValidatingFeesAndChargesTextBox Started ----");
		try {

			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			// Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Text Box is visible
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_42_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Text Box is enabled
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_42_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_42_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Validation of fees and charges textbox  was unsuccessful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_42_LoanTenureCalculator_ValidatingFeesAndChargesTextBox Ended ----\n");
	}

	@When("check for Loan Tenure Fees & Charges slider")
	public void validateFeesAndChargesSliderOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_45_LoanTenureCalculator_ValidatingFeesAndChargesSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Slider is visible
			if (loanCalculatorPageObj.getFeesAndChargesSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_45_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Slider is enabled
			if (loanCalculatorPageObj.getFeesAndChargesSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_45_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_45_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_45_LoanTenureCalculator_ValidatingFeesAndChargesSlider Ended ----\n");
	}

	@Then("Loan Tenure Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed")
	public void validatingDataFlowBetweenFeesAndChargesSliderAndTextBoxOfLoanTenureCalculator() {

		logger.info("\n---- TestCase_03_46_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000","The initial value of the fees and charges textbox is not 10,000");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(97);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_46_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_46_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box ans Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_46_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----\n");
	}

	
	
	
	
	
	
	
	
	@When("Enter input value in loan amount input box of Loan Tenure Calculator")
	public void Enter_input_value_in_loan_amount_input_box() {
		logger.info("\n---- TestCase_03_47_EMICalculator_ScaleChangewithLoanAmountTextBox Started ----");
		try {
			wait.waitForTheTextBoxAndSlider(driver);
			
			// Moving the Slider to Initial Position
			Thread.sleep(5000);
			String loanAmount = "7500000";
			loanCalculatorPageObj.setLoanAmount(loanAmount);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_47_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("loan amount slider should be moved to the same value of the scale on Scale")
	public void validating_Data_Flow_Between_TextBox_And_LoanAmount_Slider_() {
		try {
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			// Moving the Slider to Initial Position
			Thread.sleep(5000);
			String loanAmount = "7500000";
			Thread.sleep(5000);
			double actualLoanAmountSliderValue = loanCalculatorPageObj.getLoanAmountSliderValue();
			double ExpectedAmountSliderValue = ((Double.parseDouble(loanAmount) / 20000000) * 100);
			if (actualLoanAmountSliderValue == ExpectedAmountSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_47_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and slider was not successful.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_47_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_47_EMICalculator_ScaleChangewithLoanAmountTextBox Ended ----\n");
	}

	@When("Enter input value in Intrest input box of Loan Tenure Calculator")
	public void Enter_input_value_in_Intrest_input_box() {
		logger.info("\n---- TestCase_03_48_EMICalculator_ScaleChangewithInterestRateTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = "10";
			loanCalculatorPageObj.setLoanIntrestRate(intrestRate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_48_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("Intrest slider should be moved to the same value on the scale")
	public void validatingDataFlowBetweenTextBoxAndInterestRateSlider() {
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = "10";
			double actualLoanIntrestRateSliderValue = loanCalculatorPageObj.getLoanIntrestRateSliderValue();
			double ExpectedLoanIntrestRateSliderValue = ((Double.parseDouble(intrestRate) / 20) * 100);
			if (actualLoanIntrestRateSliderValue == ExpectedLoanIntrestRateSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_48_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_48_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_48_EMICalculator_ScaleChangewithInterestRateTextBox Ended ----\n");
	}

	@When("Enter input value in Fees & Charges input box of Loan Tenure Calculator")
	public void Enter_input_value_in_FeesCharges_input_box() {
		logger.info("\n---- TestCase_03_49_EMICalculator_ScaleChangewithFeesAndChargesTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = "50000";
			loanCalculatorPageObj.setFeesAndCharges(fees);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_49_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("Fees & Charges slider should be moved to the same value on the scale")
	public void validating_Data_Flow_Between_TextBox_Fees_And_Charges_Slider() {
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = "50000";
			double actualFeesAndChargesSliderValue = loanCalculatorPageObj.getFeesAndChargesSliderValue();
			double expectedFeesAndChargesSliderValue = ((Double.parseDouble(fees) / 100000) * 100);
			if (actualFeesAndChargesSliderValue == expectedFeesAndChargesSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_49_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_49_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_49_EMICalculator_ScaleChangewithFeesAndChargesTextBox Ended ----\n");
	}

}
