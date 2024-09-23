package stepDefinitions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorHomePage;
import pageObjects.HomeLoanEMICalculatorPage;
import pageObjects.LoanCalculatorPage;
import factory.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;
import utilities.WriteExcel;

public class Testcase extends BaseClass {
public static Properties p;
public static String[] data;
static String excelFilePath = System.getProperty("user.dir")+"\\testData\\mydata.xlsx";
public Logger logger=(Logger) LogManager.getLogger(this.getClass());
AddFluentWait wait = new AddFluentWait();
Assertions myAssert = new Assertions();
WebDriver driver=BaseClass.getDriver();
EmiCalculatorHomePage homePageObj ;
WriteExcel write = new WriteExcel();
Hooks hooks=new Hooks();
   
   //testing for DriverConfigration
    @BeforeClass
    @Parameters({"browser"})
    public void driverconfig(String br)
    {
    	
	 	//Instantiate driver 
    	System.out.println("Instantiating driver...");
    	driver=BaseClass.driverInstantiate();
//    	hooks.getDriver();
    	
    }
    
    
@Test(priority=1)
public void TC_01_enterDetails() {
	homePageObj = new EmiCalculatorHomePage(driver);
		logger.info("---- TestCase_01_01_EnteringRequiredValuesInHomePage Started ----");

		homePageObj.navigator();
			
			//Waiting for the main menu element
			wait.waitForMainMenu(driver);
			
			//Navigating to the page - 
//			homePageObj.navigator();
			homePageObj.clickCarLoan();
			
			//Waiting for the car loan element to load
			wait.waitForTheCarLoan(driver);
			
			//Clicking on the car loan 
			homePageObj.clickCarLoan();
			
			//Setting the required values - 
//			homePageObj.setLoanAmt(p.getProperty("loanAmount"));
//			homePageObj.setInterest(p.getProperty("interest"));
			
			homePageObj.setLoanAmt("1500000");
			homePageObj.setInterest("9.5");
			
			homePageObj.moveLoanTenureSlider(-375);
			homePageObj.clickOnYear();
		
		logger.info("---- TestCase_01_01_EnteringRequiredValuesInHomePage Ended ----");
	}
@Test(priority=2)
public void TC_01_02_displayResult() {
	
	logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Started ----");
	try {

		//Scroll to Table
		homePageObj.scrollToTable();

		//Click on the Years
		homePageObj.clickOnYears();
		
		//Displaying the data
		homePageObj.printTheEMIPaymentTable();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_01_01_EnteringRequiredValuesInHomePage got failed, displaying the datas wasn't successful");
		
		logger.error("TestCase_01_01_EnteringRequiredValuesInHomePage got failed, displaying the datas wasn't successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Ended ----");
}

    
@Test(priority=3)
public void TC_02_01_StoringTheYearTableInExcel() {
	logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Started ----");
	try {
		HomeLoanEMICalculatorPage HomeLoanPageObj = new HomeLoanEMICalculatorPage(driver);
		
		//Waiting for the main menu button
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		HomeLoanPageObj.navigator();
		
		//Scrolling to the table
		HomeLoanPageObj.scrollToTable();
		
		//Getting the year table in a 2 Dimensional Array
		String[][] datas = HomeLoanPageObj.getTableData();
		
		//Writing the data into the excel sheet
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 	// Timestamp for the excel file
		String fileName = "YearTable" + timeStamp + ".xlsx";
		String path = ".//TestData/" + fileName;
		write.writeExcel(datas, path);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_02_01_StoringTheYearTableInExcel got failed, storing the data was unsuccessful");
		logger.error("TestCase_02_01_StoringTheYearTableInExcel got failed, storing the data was unsuccessful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Ended ----");
}
 
@Test(priority=4)

public void TC_03_01_validateLoanAmountTextBox() {
	logger.info("---- TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox Started ----");
	try {
		LoanCalculatorPage LoanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		LoanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Amount Text Box is visible
		if(LoanCalculatorPageObj.getLoanAmtTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
			System.out.println("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Amount Text Box is enabled
		if(LoanCalculatorPageObj.getLoanAmtTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
			System.out.println("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was unsuccessful");
		logger.error("TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was unsuccessful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_01_EMICalculator_ValidatingLoanAmountTextBox Ended ----");
	
}

@Test(priority=5)
public void TC03_02_validateLoanAmountSlider() {
	logger.info("---- TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider Started ----");
	try {
		LoanCalculatorPage LoanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		LoanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Amount Slider is visible
		if(LoanCalculatorPageObj.getLoanAmtSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
			System.out.println("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Amount Slider is enabled
		if(LoanCalculatorPageObj.getLoanAmtSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			System.out.println("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was unsuccessful");
		
		logger.error("TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was not successful");
		myAssert.fail();
	}
	logger.info("---- TestCase_03_02_EMICalculator_ValidatingLoanAmountSlider Ended ----");
}

@Test(priority=6)
public void TC_03_03_validatingDataFlowBetweenLoanAmountSliderAndTextBox() {
	logger.info("---- TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveLoanAmtSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000", "The initial value of the loan amount textbox is not 10,00,000");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveLoanAmtSlider(130);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getLoanAmtTextBoxValue().equals("50,00,000")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and slider was not successful.");
			System.out.println("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was unsuccessful.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Check for Loan Amount Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale check for Loan Amount Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_03_EMICalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----");
}

@Test(priority=7)
public void TC_03_04_validateInterestRateTextBox() {
	
	logger.info("---- TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Text Box is visible
		if(loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			System.out.println("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Text Box is enabled
		if(loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			System.out.println("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was unsuccessful");
		
		logger.error("TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_04_EMICalculator_ValidatingInterestRateTextBox Ended ----");
}
@Test(priority=8)
public void TC_03_05_validateInterestRateSlider() {
	
	logger.info("---- TestCase_03_05_EMICalculator_ValidatingInterestRateSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Slider is visible
		if(loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			System.out.println("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Slider is enabled
		if(loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			System.out.println("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was unsuccessful");
		
		logger.error("TestCase_03_05_EMICalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_05_EMICalculator_ValidatingInterestRateSlider Ended ----");
}
@Test(priority=9)
public void TC_03_06_validatingDataFlowBetweenInterestRateSliderAndTextBox() {
	logger.info("---- TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveIntRateSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the interest rate textbox is not 10.75");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveIntRateSlider(112);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
			System.out.println("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_06_EMICalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----");
}
@Test(priority=10)
public void TC_03_07_validateLoanTenureTextBox() {
	
	logger.info("---- TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Tenure Text Box is visible
		if(loanCalculatorPageObj.getLoanTenureTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
			System.out.println("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Tenure Text Box is enabled
		if(loanCalculatorPageObj.getLoanTenureTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
			System.out.println("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was unsuccessful");
		
		logger.error("TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_07_EMICalculator_ValidatingLoanTenureTextBox Ended ----");
}	
@Test(priority=11)
public void TC_03_08_validateLoanTenureSlider() {
	
	logger.info("---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Started ----");

	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Tenure Slider is visible
		if(loanCalculatorPageObj.getLoanTenureSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Tenure Slider is enabled
		if(loanCalculatorPageObj.getLoanTenureSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was unsuccessful");
		
		logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Ended ----");
}

@Test(priority=12)
public void TC_03_09_validatingDataFlowBetweenLoanTenureSliderAndTextBox() {
	
	logger.info("---- TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveLoanTenureSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5", "The initial value of"
														+ " the loan tenure textbox is not"
														+ " 5");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveLoanTenureSlider(105);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getLoanTenureTextBoxValue().equals("10")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
			System.out.println("TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_09_EMICalculator_ScaleChangeForLoanTenureTextBoxAndSlider Ended ----");
}
@Test(priority=13)
public void TC_03_10_validateFeesAndChargesTextBox() {
	
	logger.info("---- TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Text Box is visible
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			System.out.println("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Text Box is enabled
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			System.out.println("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was unsuccessful");
		
		logger.error("TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_10_EMICalculator_ValidatingFeesAndChargesTextBox Ended ----");
}	
@Test(priority=14)
public void TC_01_11_validateFeesAndChargesSlider() {
	
	logger.info("---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Started ----");
	try {
		LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		obj1.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Slider is visible
		if(obj1.getFeesAndChargesSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Slider is enabled
		if(obj1.getFeesAndChargesSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was unsuccessful");
		
		logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Ended ----");
}
@Test(priority=15)
public void TC_03_12_validatingDataFlowBetweenFeesAndChargesSliderAndTextBox() {
	
	logger.info("---- TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(97);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
			System.out.println("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_12_EMICalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----");
}
@Test(priority=16)
public void TC_03_13_validatingValidatingEMITextBox() {
	
	logger.info("---- TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if EMI Text Box is visible
		if(loanCalculatorPageObj.getEMITextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
			System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if EMI Text Box is enabled
		if(loanCalculatorPageObj.getEMITextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
			System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was unsuccessful");
		
		logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox Ended ----");
}
@Test(priority=17)
public void TC_03_14_validatingEMISlider() {
	
	logger.info("---- TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if EMI Slider is visible
		if(loanCalculatorPageObj.getEMISlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			System.out.println("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if EMI Slider is enabled
		if(loanCalculatorPageObj.getEMISlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			System.out.println("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, validation of EMI Slider was unsuccessful");
		
		logger.error("TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider got failed, validation of EMI Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_14_LoanAmtCalculator_ValidatingEMISlider Ended ----");
}
@Test(priority=18)
public void TC_03_15_validatingDataFlowBetweenEMISliderAndTextBox() {
	
	logger.info("---- TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();;
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveEMISlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getEMITextBoxValue(), "21,617.95", "The initial value of the emi textbox is not 21,617.95");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveEMISlider(186);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getEMITextBoxValue().equals("50,000.00")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
			System.out.println("TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_15_LoanAmtCalculator_ScaleChangeForEMITextBoxAndSlider Ended ----");
}
@Test(priority=19)
public void TC_03_16_validateInterestRateTextBox() {
	
	logger.info("---- TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Text Box is visible
		if(loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			System.out.println("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Text Box is enabled
		if(loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			System.out.println("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was unsuccessful");
		
		logger.error("TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_16_LoanAmtCalculator_ValidatingInterestRateTextBox Ended ----");
}
@Test(priority=20)
public void TC_03_17_validatingDataFlowBetweenInterestRateSliderAndTextBox() {
	
	logger.info("---- TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();;
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Slider is visible
		if(loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Slider is enabled
		if(loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was unsuccessful");
		
		logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider Ended ----");
}

@Test(priority=21)
public void TC_03_18_validatingDataFlowBetweenInterestRateSliderAndTextBox() {
	
	logger.info("---- TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveIntRateSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the loan amount textbox is not 10.75");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveIntRateSlider(112);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
			System.out.println("TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_18_LoanAmtCalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----");
}
@Test(priority=22)
public void TC_03_19_validateLoanTenureTextBox() {
	
	logger.info("---- TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Tenure Text Box is visible
		if(loanCalculatorPageObj.getLoanTenureTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
			System.out.println("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Tenure Text Box is enabled
		if(loanCalculatorPageObj.getLoanTenureTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
			System.out.println("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, Loan Tenure Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was unsuccessful");
		
		logger.error("TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox got failed, validation of Loan Tenure Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_19_LoanAmtCalculator_ValidatingLoanTenureTextBox Ended ----");
}	
@Test(priority=23)
public void TC_03_20_validateLoanTenureSlider() {
	
	logger.info("---- TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Tenure Slider is visible
		if(loanCalculatorPageObj.getLoanTenureSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			System.out.println("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Tenure Slider is enabled
		if(loanCalculatorPageObj.getLoanTenureSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			System.out.println("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was unsuccessful");
		
		logger.error("TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_20_LoanAmtCalculator_ValidatingLoanTenureSlider Ended ----");
}
public void TC_03_21_validatingDataFlowBetweenLoanTenureSliderAndTextBox() {
	
	logger.info("---- TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveLoanTenureSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5", "The initial value of the loan tenure textbox is not 5");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveLoanTenureSlider(105);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getLoanTenureTextBoxValue().equals("10")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
			System.out.println("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Ended ----");
}
@Test(priority=24)
public void TC_03_22_validateFeesAndChargesTextBox() {
	
	logger.info("---- TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Text Box is visible
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			System.out.println("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Text Box is enabled
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			System.out.println("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was unsuccessful");
		
		logger.error("TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox got failed, validation of Fees And Charges Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_22_LoanAmtCalculator_ValidatingFeesAndChargesTextBox Ended ----");
}	
@Test(priority=25)
public void TC_03_23_validateFeesAndChargesSlider() {
	
	logger.info("---- TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Slider is visible
		if(loanCalculatorPageObj.getFeesAndChargesSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			System.out.println("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Slider is enabled
		if(loanCalculatorPageObj.getFeesAndChargesSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			System.out.println("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was unsuccessful");
		
		logger.error("TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_23_LoanAmtCalculator_ValidatingFeesAndChargesSlider Ended ----");
}
@Test(priority=26)
public void TC_03_24_validatingDataFlowBetweenFeesAndChargesSliderAndTextBox() {
	
	logger.info("---- TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanAmountCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(97);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
			System.out.println("TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_24_LoanAmtCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----");
}
@Test(priority=27)
public void TC_03_25_validateLoanAmountTextBox() {
	
	logger.info("---- TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Amount Text Box is visible
		if(loanCalculatorPageObj.getLoanAmtTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
			System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Amount Text Box is enabled
		if(loanCalculatorPageObj.getLoanAmtTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
			System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
			myAssert.fail();
		}

	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was unsuccessful");
		
		logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox Ended ----");
}
@Test(priority=28)
public void TC_03_26_validateLoanAmountSlider() {
	
	logger.info("---- TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Loan Amount Slider is visible
		if(loanCalculatorPageObj.getLoanAmtSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
			System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Loan Amount Slider is enabled
		if(loanCalculatorPageObj.getLoanAmtSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was unsuccessful");
		
		logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider Ended ----");
}
@Test(priority=29)
public void TC_03_27_validatingDataFlowBetweenLoanAmountSliderAndTextBox() {
	
	logger.info("---- TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveLoanAmtSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000", "The initial value of the loan amount textbox is not 10,00,000");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveLoanAmtSlider(130);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getLoanAmtTextBoxValue().equals("50,00,000")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and slider was not successful");
			System.out.println("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----");
}
@Test(priority=30)
public void TC_03_28_validatingValidatingEMITextBox() {
	
	logger.info("---- TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if EMI Text Box is visible
		if(loanCalculatorPageObj.getEMITextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
			System.out.println("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if EMI Text Box is enabled
		if(loanCalculatorPageObj.getEMITextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
			System.out.println("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was unsuccessful");
		
		logger.error("TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_28_LoanTenureCalculator_ValidatingEMITextBox Ended ----");
}
@Test(priority=31)
public void TC_03_29_validatingEMISlider() {
	
	logger.info("---- TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if EMI Slider is visible
		if(loanCalculatorPageObj.getEMISlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if EMI Slider is enabled
		if(loanCalculatorPageObj.getEMISlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, validation of EMI Slider was unsuccessful");
		
		logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, validation of EMI Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider Ended ----");
}
@Test(priority=32)
public void TC_03_30_validatingDataFlowBetweenEMISliderAndTextBox() {
	
	logger.info("---- TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();;
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveEMISlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getEMITextBoxValue(), "21,617.95", "The initial value of the emi textbox is not 21,617.95");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveEMISlider(186);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getEMITextBoxValue().equals("50,000.00")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
			System.out.println("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Ended ----");
}
@Test(priority=33)
public void TC_03_31_validateInterestRateTextBox() {
	
	logger.info("---- TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Text Box is visible
		if(loanCalculatorPageObj.getIntRateTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			System.out.println("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Text Box is enabled
		if(loanCalculatorPageObj.getIntRateTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			System.out.println("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, Interest Rate Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was unsuccessful");
		
		logger.error("TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox got failed, validation of Interest Rate Text Box was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_31_LoanTenureCalculator_ValidatingInterestRateTextBox Ended ----");
}
@Test(priority=34)
public void TC_03_32_validatingInterestRateSlider() {
	
	logger.info("---- TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Interest Rate Slider is visible
		if(loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			System.out.println("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Interest Rate Slider is enabled
		if(loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			System.out.println("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was unsuccessful");
		
		logger.error("TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_32_LoanTenureCalculator_ValidatingInterestRateSlider Ended ----");
}
@Test(priority=35)
public void TC_03_33_validateDataFlowBetweenInterestRateSliderAndTextBox() {
	
	logger.info("---- TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveIntRateSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the interest rate textbox is not 10.75");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveIntRateSlider(112);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
			System.out.println("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----");
}	
@Test(priority=36)
public void TC_03_34_validateFeesAndChargesTextBox() {
	
	logger.info("---- TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Text Box is visible
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			System.out.println("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Text Box is enabled
		if(loanCalculatorPageObj.getFeesAndChargesTextBox().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			System.out.println("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Fees And Charges Text Box is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Validation of fees and charges textbox  was unsuccessful");
		
		logger.error("TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox got failed, Validation of fees and charges textbox  was unsuccessful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_34_LoanTenureCalculator_ValidatingFeesAndChargesTextBox Ended ----");
}
@Test(priority=37)
public void TC_03_35_validateFeesAndChargesSlider() {
	
	logger.info("---- TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Validating if Fees And Charges Slider is visible
		if(loanCalculatorPageObj.getFeesAndChargesSlider().isDisplayed()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			System.out.println("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
			myAssert.fail();
		}
		
		//Validating if Fees And Charges Slider is enabled
		if(loanCalculatorPageObj.getFeesAndChargesSlider().isEnabled()) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			System.out.println("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was unsuccessful");
		
		logger.error("TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider Ended ----");
}
@Test(priority=38)
public void TC_036_validatingDataFlowBetweenFeesAndChargesSliderAndTextBox() {
	
	logger.info("---- TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the respective page
		loanCalculatorPageObj.navigatorForLoanTenureCalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Moving the Slider to Initial Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(0);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
		
		//Moving the slider to Desired Position
		loanCalculatorPageObj.moveFeesAndChargesSlider(97);
		
		//Validating if the value passed to the text box is same as it is showing in the slider
		if(loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
			System.out.println("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
		
		logger.error("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box ans Slider was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----");
}
@Test(priority=39)
public void TC_03_37_validatingDataFlowBetweenYearAndMonthButton() {
	
	logger.info("---- TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);
		
		//Navigating to the EMI Calculator Section
		loanCalculatorPageObj.navigatorForEMICalc();
		
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
		
		//Clicking on the year button
		loanCalculatorPageObj.clickYear();
		
		//Storing the value of year in a string 
		String yearVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
		
		//Converting the year value to the month value
		int yearValInInt = Integer.parseInt(yearVal);
		
		//Clicking on the month Button
		loanCalculatorPageObj.clickMonth();
		
		//Storing the value of month in a string 
		String monthVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
		
		//Asserting the values
		if(monthVal.equals(Integer.toString(yearValInInt*12))) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the EMI Calculator Section.");
			System.out.println("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the EMI Calculator Section..");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was unsuccessful");
		
		logger.error("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption Ended ----");
}
@Test(priority=40)
public void TC_03_38_validatingDataFlowBetweenYearAndMonthButton() {
	
	logger.info("---- TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption Started ----");
	try {
		LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
		
		//Waiting for the main menu to load
		wait.waitForMainMenu(driver);

		//Navigating to the Loan Amount Calculator Section
		loanCalculatorPageObj.navigatorForLoanAmountCalc();;
			
		//Waiting for all the fields to be visible
		wait.waitForTheTextBoxAndSlider(driver);
				
		//Clicking on the year button
		loanCalculatorPageObj.clickYear();
				
		//Storing the value of year in a string 
		String yearVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
				
		//Converting the year value to the month value
		int yearValInInt = Integer.parseInt(yearVal);
				
		//Clicking on the month Button
		loanCalculatorPageObj.clickMonth();
		
		//Storing the value of month in a string 
		String monthVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
				
		//Asserting the values
		if(monthVal.equals(Integer.toString(yearValInInt*12))) {
			myAssert.pass();
		}
		else {
			logger.error("TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the Loan Amount Calculator Section.");
			System.out.println("TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the Loan Amount Calculator Section..");
			myAssert.fail();
		}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was unsuccessful");
		
		logger.error("TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was not successful");
		myAssert.fail();
	}
	
	logger.info("---- TestCase_03_38_LoanAmtCalculator_ValidationForYearAndMonthOption Ended ----");
}


    
//    closing the browser
	@AfterClass
	void Afterclass() {
		//BaseClass bs=new BaseClass();
		BaseClass.driverTearDown();
	}
}


