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
import utilities.AddFluentWait;
import utilities.Assertions;

public class CarLoanCalculationSteps {
	WebDriver driver=BaseClass.getDriver();
	public static Properties p;
	public Logger logger=(Logger) LogManager.getLogger(this.getClass());
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();

	EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
	BaseClass bs=new BaseClass();
	
	
	
	@Given("the user navigates to Car Loan section")
	public void the_user_navigates_to_car_loan_section() 
	{
		logger.info("---- TestCase_01_01_EnteringRequiredValuesInHomePage Started ----");
		//Waiting for the main menu element
		wait.waitForMainMenu(driver);
		
		//Navigating to the page - 
		//homePageObj.navigator();
		homePageObj.clickCarLoan();
		
	}
	
	@When ("user enters the Car Loan Amount")
	
	public void user_enters_the_Car_Loan_Amoun() {
		try {
			p=BaseClass.getProperties();
			String amt=p.getProperty("carouLoanAmnt");
			homePageObj.setLoanAmt(amt);
			logger.info("---- user enters the Car Loan Amoun : "+amt+" ----");
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	@When("user enters the Interest Rate")
	public void user_enters_the_interest_rate() 
	{
		try {
			String intrest=p.getProperty("carInterestRate");
			homePageObj.setInterest(intrest);
			logger.info("---- user enters the Interest Rate : "+intrest+"  ----");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	@When("user enters the Loan Tenure")
	public void user_enters_the_loan_tenure() 
	{
		try {
//			homePageObj.moveLoanTenureSlider(-375);
			String tenure=p.getProperty("carLoanTenure");
			homePageObj.setLoanTenure(tenure);
			homePageObj.clickOnYear();
			logger.info("---- user enters the Loan Tenure Year : 1 ----");
			logger.info("---- TestCase_01_01_EnteringRequiredValuesInHomePage Ended ----");
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	@Then("display interest and principal amount on console")
	public void display_interest_and_principal_amount_on_console() 
	{
		logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Started ----");
		try {
			//Scroll to Table
			homePageObj.printFisrtMonthEMIPayment();
			homePageObj.scrollToTable();
			//Click on the Years
			homePageObj.clickOnYears();
			//Displaying the data
			homePageObj.printTheEMIPaymentTable();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_01_01_EnteringRequiredValuesInHomePage got failed, displaying the datas wasn't successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Ended ----");
	}	
	
}
