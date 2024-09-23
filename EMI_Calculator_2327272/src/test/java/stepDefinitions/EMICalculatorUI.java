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

public class EMICalculatorUI {
	WebDriver driver = BaseClass.getDriver();
	public static Properties p;
	public static String[] data;
	public static String[] datas;
	static String excelFilePath = System.getProperty("user.dir") + "\\InputTestData\\inputData.xlsx";
	public Logger logger = (Logger) LogManager.getLogger(this.getClass());
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();

	EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
	LoanCalculatorPage LoanCalculatorPageObj = new LoanCalculatorPage(driver);
	WriteExcel write = new WriteExcel();
	
	

	

	@Given("user navigates to EMI Calculator")
	public void user_navigates_to_EMI_Calculator() {
		logger.info("\n---- TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox Started ----");

		// Waiting for the main menu to load
		wait.waitForMainMenu(driver);

		// Navigating to the respective page
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoanCalculatorPageObj.navigatorForEMICalc();
	}

	
	
	@When("check for loan amount input box")
	public void Validating_Loan_Amount_TextBox() {
		// Waiting for all the fields to be visible
		try {
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			// Validating if Loan Amount Text Box is visible
			if (LoanCalculatorPageObj.getLoanAmtTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Amount Text Box is enabled
			if (LoanCalculatorPageObj.getLoanAmtTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was unsuccessful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox Ended ----");
	}

	
	
	@When("check for loan amount slider")
	public void Validating_Loan_Amount_Slider() {
		logger.info("---- TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider Started ----");
		try {

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Amount Slider is visible
			if (LoanCalculatorPageObj.getLoanAmtSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Amount Slider is enabled
			if (LoanCalculatorPageObj.getLoanAmtSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

			logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was not successful");
			myAssert.fail();
		}
		logger.info("---- TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider Ended ----\n");
	}

	
	@Then("loan amount slider should be moved to the Some value and respectively loan amount should be displayed")
	public void validating_Data_Flow_Between_LoanAmount_Slider_And_TextBox() {
		logger.info("\n---- TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
		try {

			// Moving the Slider to Initial Position
			LoanCalculatorPageObj.moveLoanAmtSlider(0);
			Thread.sleep(5000);

			// Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(LoanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000","The initial value of the loan amount textbox is not 10,00,000");

			// Moving the slider to Desired Position
			LoanCalculatorPageObj.moveLoanAmtSlider(130);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (LoanCalculatorPageObj.getLoanAmtTextBoxValue().equals("50,00,000")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and slider was not successful.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----\n");
	}

	
	
	@When("check for Intrest input box")
	public void validate_Interest_Rate_TextBox() {

		logger.info("\n---- TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Text Box is visible
			if (loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Text Box is enabled
			if (loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox Ended ----\n");
	}

	
	
	@When("check for Intrest slider")
	public void validate_Interest_Rate_Slider() {

		logger.info("\n---- TestCase_03_05_EMICalculator_ValidatingInterestRateSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Interest Rate Slider is visible
			if (loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Interest Rate Slider is enabled
			if (loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_05_EMICalculator_ValidatingInterestRateSlider Ended ----\n");
	}
	
	

	@Then("loan Intrest slider should be moved to the Some value and respectively Intrest value should be displayed")
	public void validatingDataFlowBetweenInterestRateSliderAndTextBox() {
		logger.info("\n---- TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			Thread.sleep(5000);
			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveIntRateSlider(0);

			// Validating if the value passed to the text box is same as it is showing in  the slider
			myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75","The initial value of the interest rate textbox is not 10.75");
			Thread.sleep(5000);
			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveIntRateSlider(112);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----\n");
	}

	@When("check for loan Tenure input box")
	public void validate_Loan_Tenure_TextBox() {

		logger.info("\n---- TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Tenure Text Box is visible
			if (loanCalculatorPageObj.getLoanTenureTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Tenure Text Box is enabled
			if (loanCalculatorPageObj.getLoanTenureTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox Ended ----\n");
	}

	@When("check for loan Tenure slider")
	public void validate_Loan_Tenure_Slider() {

		logger.info("\n---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Started ----");

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Loan Tenure Slider is visible
			if (loanCalculatorPageObj.getLoanTenureSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Loan Tenure Slider is enabled
			if (loanCalculatorPageObj.getLoanTenureSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Ended ----\n");
	}
	
	

	@Then("loan loan Tenure slider should be moved to the Some value and respectively loan Tenure value should be displayed")
	public void validatingDataFlowBetweenLoanTenureSliderAndTextBox() {

		logger.info("\n---- TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveLoanTenureSlider(0);

			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5","The initial value of" + " the loan tenure textbox is not" + " 5");
			Thread.sleep(5000);
			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveLoanTenureSlider(105);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getLoanTenureTextBoxValue().equals("10")) {
				myAssert.pass();
			} else {
				logger.error(
						"TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
				System.out.println(
						"TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider Ended ----\n");
	}
	

	
	@When("check for Fees & Charges input box")
	public void validate_Fees_And_Charges_TextBox() {

		logger.info("\n---- TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Text Box is visible
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Text Box is enabled
			if (loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox Ended ----\n");
	}

	
	@When("check for Fees & Charges slider")
	public void validate_Fees_And_Charges_Slider() {

		logger.info("\n---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Started ----");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			// Validating if Fees And Charges Slider is visible
			if (obj1.getFeesAndChargesSlider().isDisplayed()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
				myAssert.fail();
			}

			// Validating if Fees And Charges Slider is enabled
			if (obj1.getFeesAndChargesSlider().isEnabled()) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Ended ----\n");
	}

	
	@Then("Fees & Charges slider should be moved to the Some value and respectively Fees & Charges value should be displayed")
	public void validating_Data_Flow_Between_Fees_And_Charges_Slider_And_TextBox() {

		logger.info("\n---- TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			// Moving the Slider to Initial Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(0);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000","The initial value of the fees and charges textbox is not 10,000");

			// Moving the slider to Desired Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(97);
			Thread.sleep(5000);
			// Validating if the value passed to the text box is same as it is showing in
			// the slider
			if (loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
			myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----\n");
	}
	
	
	
	
	
	
	

	@When("Enter input value in loan amount input box")
	public void Enter_input_value_in_loan_amount_input_box() {
		logger.info("\n---- TestCase_03_13_EMICalculator_ScaleChangewithLoanAmountTextBox Started ----");
		
		try {
			
			wait.waitForTheTextBoxAndSlider(driver);
			// Moving the Slider to Initial Position
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			Thread.sleep(5000);
			String loanAmount = data[0];
			LoanCalculatorPageObj.setLoanAmount(loanAmount);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_13_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}
	}
	

	@Then("loan amount slider should be moved to the same value")
	public void validating_Data_Flow_Between_TextBox_And_LoanAmount_Slider_() {
		try {
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			// Moving the Slider to Initial Position
			
			Thread.sleep(5000);
			String loanAmount = data[0];
			Thread.sleep(5000);
			double actualLoanAmountSliderValue = LoanCalculatorPageObj.getLoanAmountSliderValue();
			double ExpectedAmountSliderValue = ((Double.parseDouble(loanAmount) / 20000000) * 100);
			
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (actualLoanAmountSliderValue == ExpectedAmountSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_13_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and slider was not successful.");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_13_EMICalculator_ScaleChangewithLoanAmountTextBox got failed, Scale check for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_13_EMICalculator_ScaleChangewithLoanAmountTextBox Ended ----\n");
	}

	
	
	@When("Enter input value in Intrest input box")
	public void Enter_input_value_in_Intrest_input_box() {
		logger.info("\n---- TestCase_03_14_EMICalculator_ScaleChangewithInterestRateTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = data[1];
			loanCalculatorPageObj.setLoanIntrestRate(intrestRate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_14_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

	}

	
	
	@Then("Intrest slider should be moved to the same value")
	public void validatingDataFlowBetweenTextBoxAndInterestRateSlider() {
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			Thread.sleep(5000);
			wait.waitForTheTextBoxAndSlider(driver);
			String intrestRate = data[1];
			double actualLoanIntrestRateSliderValue = loanCalculatorPageObj.getLoanIntrestRateSliderValue();
			double ExpectedLoanIntrestRateSliderValue = ((Double.parseDouble(intrestRate) / 20) * 100);
			
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (actualLoanIntrestRateSliderValue == ExpectedLoanIntrestRateSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_14_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_14_EMICalculator_ScaleChangewithInterestRateTextBox got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_14_EMICalculator_ScaleChangewithInterestRateTextBox Ended ----\n");
	}

	
	@When("Enter input value in loan Tenure input box")
	public void Enter_input_value_in_loan_Tenure_input_box() {
		logger.info("\n---- TestCase_03_15_EMICalculator_ScaleChangewithLoanTenureTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			wait.waitForTheTextBoxAndSlider(driver);
			String loanTenure = data[2];
			loanCalculatorPageObj.setLoanTenure(loanTenure);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_15_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	
	@Then("loan Tenure slider should be moved to the same value")
	public void validatingDataFlowBetweenLoanTenureTextBoxAndSlider() {

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");
			wait.waitForTheTextBoxAndSlider(driver);
			String loanTenure = data[2];
			Thread.sleep(5000);
			double actualLoanTenureSliderValue = loanCalculatorPageObj.getLoanTenureSliderValue();
			double ExpectedLoanTenureSliderValue = ((Double.parseDouble(loanTenure) / 30) * 100);
			
			if (ExpectedLoanTenureSliderValue == actualLoanTenureSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_15_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_15_EMICalculator_ScaleChangewithLoanTenureTextBox got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_15_EMICalculator_ScaleChangewithLoanTenureTextBox Ended ----\n");
	}

	
	@When("Enter input value in Fees & Charges input box")
	public void Enter_input_value_in_FeesCharges_input_box() {
		logger.info("\n---- TestCase_03_16_EMICalculator_ScaleChangewithFeesAndChargesTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = data[3];
			loanCalculatorPageObj.setFeesAndCharges(fees);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_16_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}
	}

	
	@Then("Fees & Charges slider should be moved to the same value")
	public void validating_Data_Flow_Between_TextBox_Fees_And_Charges_Slider() {

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			data = write.readExcelData(excelFilePath, "inputDataForValidation");

			// Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			Thread.sleep(5000);
			String fees = data[3];
			double actualFeesAndChargesSliderValue = loanCalculatorPageObj.getFeesAndChargesSliderValue();
			double expectedFeesAndChargesSliderValue = ((Double.parseDouble(fees) / 100000) * 100);
			// Validating if the value passed to the text box is same as it is showing in the slider
			if (actualFeesAndChargesSliderValue == expectedFeesAndChargesSliderValue) {
				myAssert.pass();
			} else {
				logger.error("TestCase_03_16_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				myAssert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_03_16_EMICalculator_ScaleChangewithFeesAndChargesTextBox got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("---- TestCase_03_16_EMICalculator_ScaleChangewithFeesAndChargesTextBox Ended ----\n");
	}

}
