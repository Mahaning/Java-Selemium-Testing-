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
import utilities.WriteExcel;

public class LoanAmountCalculatorUI {
	WebDriver driver = BaseClass.getDriver();
	public static Properties p;
	public static String[] data;
	public Logger logger = (Logger) LogManager.getLogger(this.getClass());
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	static String excelFilePath = System.getProperty("user.dir") + "\\InputTestData\\inputData.xlsx";

	EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
	LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
	WriteExcel write = new WriteExcel();

	@Given("user navigates to Loan Amount Calculator")
	public void user_navigates_to_EMI_Calculator() {
		logger.info("---- TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox Started ----");

		// Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		// Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
	}

	@When("check for EMI input box")
	public void validating_Validating_EMI_TextBox_of_ForLoanAmountCalc() {

		logger.info("\n---- TestCase_03_17_LoanAmtCalculator_ValidatingEMITextBox Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if EMI Text Box is visible
			if (loanCalculatorPageObj.getEMITextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if EMI Text Box is enabled
			if (loanCalculatorPageObj.getEMITextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_17_LoanAmtCalculator_ValidatingEMITextBox Ended ----\n");
	}

	
	@When("check for EMI slider")
	public void validating_EMI_SliderofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_18_LoanAmtCalculator_ValidatingEMISlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if EMI Slider is visible
			if (loanCalculatorPageObj.getEMISlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_18_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
				myAssert.fail();
			}

			// Validating if EMI Slider is enabled
			if (loanCalculatorPageObj.getEMISlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_18_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_18_LoanAmtCalculator_ValidatingEMISlider got failed, validation of EMI Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_18_LoanAmtCalculator_ValidatingEMISlider Ended ----\n");
	}

	@Then("EMI slider should be moved to the Some value and respectively EMI should be displayed")
	public void TC_03_15validating_Data_Flow_Between_EMI_Slider_And_TextBox() {

		logger.info("\n---- TestCase_03_19_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider Started ----");
		try {
//			Thread.sleep(5000);
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveEMISlider(0);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getEMITextBoxValue(), "21,617.95","The initial value of the emi textbox is not 21,617.95");
			Thread.sleep(5000);
			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveEMISlider(185);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (loanCalculatorPageObj.getEMITextBoxValue().equals("49,999.99")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_19_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_19_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_19_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Amount Intrest input box")
	public void validate_Interest_Rate_TextBox() {

		logger.info("\n---- TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Text Box is visible
			if (loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error(
						"TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
				System.out.println(
						"TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Text Box is enabled
			if (loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_20_LoanAmtCalculator_ValidatingInterestRateTextBox Ended ----\n");
	}

	@When("check for Loan Amount Intrest slider")
	public void validating_Interest_Rate_SliderofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_21_LoanAmtCalculator_ValidatingInterestRateSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Slider is visible
			if (loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_21_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Slider is enabled
			if (loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_21_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_21_LoanAmtCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_21_LoanAmtCalculator_ValidatingInterestRateSlider Ended ----\n");
	}

	@Then("Loan Amount loan Intrest slider should be moved to the Some value and respectively Intrest value should be displayed")
	public void validating_Data_Flow_Between_Interest_Rate_Slider_And_TextBoxofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_22_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveIntRateSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75","The initial value of the loan amount textbox is not 10.75");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveIntRateSlider(112);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_22_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_22_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Amount loan Tenure input box")
	public void validateLoanTenureTextBoxofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_23_LoanAmtCalculator_ValidatingLoanTenureTextBox Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Tenure Text Box is visible
			if (loanCalculatorPageObj.getLoanTenureTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Tenure Text Box is enabled
			if (loanCalculatorPageObj.getLoanTenureTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_23_LoanAmtCalculator_ValidatingLoanTenureTextBox Ended ----\n");
	}

	@When("check for Loan Amount loan Tenure slider")
	public void validateLoanTenureSliderofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_24_LoanAmtCalculator_ValidatingLoanTenureSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Tenure Slider is visible
			if (loanCalculatorPageObj.getLoanTenureSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_24_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Tenure Slider is enabled
			if (loanCalculatorPageObj.getLoanTenureSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_24_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_24_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_24_LoanAmtCalculator_ValidatingLoanTenureSlider Ended ----\n");
	}

	@Then("Loan Amount loan loan Tenure slider should be moved to the Some value and respectively loan Tenure value should be displayed")
	public void validating_Data_Flow_Between_LoanTenure_Slider_And_TextBoxofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_25_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveLoanTenureSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5","The initial value of the loan tenure textbox is not 5");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveLoanTenureSlider(105);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getLoanTenureTextBoxValue().equals("10")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_25_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_25_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_25_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Ended ----\n");
	}

	@When("check for Loan Amount Fees & Charges input box")
	public void validateFeesAndChargesTextBoxofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_26_LoanAmtCalculator_ValidatingFeesAndChargesTextBox Started ----");
		try {
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Text Box is visible
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_26_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Text Box is enabled
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_26_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			logger.error("TestCase_03_26_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_26_LoanAmtCalculator_ValidatingFeesAndChargesTextBox Ended ----\n");
	}

	@When("check for Loan Amount Fees & Charges slider")
	public void validateFeesAndChargesSliderofLoanAmountCalc() {

		logger.info("---- TestCase_03_27_LoanAmtCalculator_ValidatingFeesAndChargesSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Slider is visible
			if (loanCalculatorPageObj.getFeesAndChargesSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_27_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Slider is enabled
			if (loanCalculatorPageObj.getFeesAndChargesSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_27_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
	
			logger.error("TestCase_03_27_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_27_LoanAmtCalculator_ValidatingFeesAndChargesSlider Ended ----\n");
	}

	@Then("Loan Amount Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed")
	public void validatingDataFlowBetweenFeesAndChargesSliderAndTextBoxofLoanAmountCalc() {

		logger.info("\n---- TestCase_03_28_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
		try {

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
				logger.error("TestCase_03_28_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_28_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_28_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@When("Enter input value in EMI input box")
	public void Enter_input_value_in_loan_amount_input_box() {
		logger.info("\n---- TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
		try {
			wait.waitForTheTextBoxAndSlider(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			// Moving the Slider to Initial Position
			Thread.sleep(5000);
			String emi = "50,000.01";
			loanCalculatorPageObj.setEMI(emi);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(
					"TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Check for Loan Amount Text Box and Slider was unsuccessful");

			logger.error(
					"TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("EMI slider should be moved to the same value of the scale")
	public void validating_Data_Flow_Between_TextBox_And_LoanAmount_Slider_() {
		try {
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			// Moving the Slider to Initial Position
			Thread.sleep(5000);
			String loanAmount = "50000";
			Thread.sleep(5000);
			double actualLoanAmountSliderValue = loanCalculatorPageObj.getEMISliderValue();
			double ExpectedAmountSliderValue = ((Double.parseDouble(loanAmount) / 100000) * 100);
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (actualLoanAmountSliderValue == ExpectedAmountSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and slider was not successful.");
				System.out.println(
						"TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was unsuccessful.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(
					"TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Check for Loan Amount Text Box and Slider was unsuccessful");

			logger.error(
					"TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_29_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----\n");
	}

	@When("Enter input value in Intrest input box of Loan Amount Calculator")
	public void Enter_input_value_in_Intrest_input_box() {
		logger.info("\n---- TestCase_03_30_EMICalculator_ScaleChangewithInterestRateTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = "10";
			loanCalculatorPageObj.setLoanIntrestRate(intrestRate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_30_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("Intrest slider should be moved to the same value of the scale")
	public void validatingDataFlowBetweenTextBoxAndInterestRateSlider() {
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = "10";
			double actualLoanIntrestRateSliderValue = loanCalculatorPageObj.getLoanIntrestRateSliderValue();
			double ExpectedLoanIntrestRateSliderValue = ((Double.parseDouble(intrestRate) / 20) * 100);
			if (actualLoanIntrestRateSliderValue == ExpectedLoanIntrestRateSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_30_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_30_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_30_EMICalculator_ScaleChangewithInterestRateTextBox Ended ----\n");
	}

	@When("Enter input value in loan Tenure input box of Loan Amount Calculator")
	public void Enter_input_value_in_loan_Tenure_input_box() {
		logger.info("\n---- TestCase_03_31_EMICalculator_ScaleChangewithLoanTenureTextBox Started ----");
		
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			wait.waitForTheTextBoxAndSlider(driver);
			String loanTenure = "15";
			loanCalculatorPageObj.setLoanTenure(loanTenure);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_31_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("loan Tenure slider should be moved to the same value of the scale")
	public void validatingDataFlowBetweenLoanTenureTextBoxAndSlider() {

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			wait.waitForTheTextBoxAndSlider(driver);
			String loanTenure = "15";
			Thread.sleep(5000);
			double actualLoanTenureSliderValue = loanCalculatorPageObj.getLoanTenureSliderValue();
			double ExpectedLoanTenureSliderValue = ((Double.parseDouble(loanTenure) / 30) * 100);
			if (ExpectedLoanTenureSliderValue == actualLoanTenureSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_31_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_31_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_31_EMICalculator_ScaleChangewithLoanTenureTextBox Ended ----\n");
	}

	@When("Enter input value in Fees & Charges input box of Loan Amount Calculator")
	public void Enter_input_value_in_FeesCharges_input_box() {
		logger.info("\n---- TestCase_03_32_EMICalculator_ScaleChangewithFeesAndChargesTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = "50000";
			loanCalculatorPageObj.setFeesAndCharges(fees);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_32_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	@Then("Fees & Charges slider should be moved to the same value of the scale")
	public void validating_Data_Flow_Between_TextBox_Fees_And_Charges_Slider() {

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "data");
			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = "50000";
			double actualFeesAndChargesSliderValue = loanCalculatorPageObj.getFeesAndChargesSliderValue();
			double expectedFeesAndChargesSliderValue = ((Double.parseDouble(fees) / 100000) * 100);
			if (actualFeesAndChargesSliderValue == expectedFeesAndChargesSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_32_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_32_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_32_EMICalculator_ScaleChangewithFeesAndChargesTextBox Ended ----");
	}
}
