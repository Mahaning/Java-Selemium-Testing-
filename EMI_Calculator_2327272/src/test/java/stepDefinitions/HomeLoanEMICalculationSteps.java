package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EmiCalculatorHomePage;
import pageObjects.HomeLoanEMICalculatorPage;
import utilities.AddFluentWait;
import utilities.Assertions;
import utilities.WriteExcel;

public class HomeLoanEMICalculationSteps {
	WebDriver driver = BaseClass.getDriver();
	public static Properties p;
	static String excelFilePath = System.getProperty("user.dir") + "\\InputTestData\\inputData.xlsx";
	public Logger logger = (Logger) LogManager.getLogger(this.getClass());
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	WriteExcel write = new WriteExcel();
	public static String[] data;
	EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
	HomeLoanEMICalculatorPage HomeLoanPageObj = new HomeLoanEMICalculatorPage(driver);

	@Given("the user navigates to Home Loan EMI Calculator")
	public void the_user_navigates_to_home_loan_emi_calculator() {
		try {
			logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Started ----");
			// Waiting for the main menu button
			wait.waitForMainMenu(driver);

			// Navigating to the respective page
			HomeLoanPageObj.navigator();
			logger.info("---- the user navigates to Home Loan EMI Calculator ----");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@When("the user fills the relevant details")
	public void the_user_fills_the_relevant_details() {
		try {
			data = write.readExcelData(excelFilePath, "data");
			HomeLoanPageObj.setHomeValue(data[0]);
			HomeLoanPageObj.setDownPayment(data[1]);
			HomeLoanPageObj.setLoanInsurance(data[2]);
			HomeLoanPageObj.setInterestRate(data[3]);
			HomeLoanPageObj.setLoanTenure(data[4]);
			HomeLoanPageObj.setLoanCharges(data[5]);
			HomeLoanPageObj.setCalender(data[6], data[7]);
			HomeLoanPageObj.setOneTimeExpenses(data[8]);
			HomeLoanPageObj.setPropertyTax(data[9]);
			HomeLoanPageObj.setHomeInsurancePerYear(data[10]);
			HomeLoanPageObj.setMaintenenceCharge(data[11]);
			logger.info("---- the user filled the relevant details ----");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Then("extract the data from year on year table to excel")
	public void extract_the_data_from_year_on_year_table_to_excel() {
		try {
			Thread.sleep(5000);
			// Scrolling to the table
			HomeLoanPageObj.scrollToTable();

			// Getting the year table in a 2 Dimensional Array
			String[][] datas = HomeLoanPageObj.getTableData();
			System.out.println(datas);
			// Writing the data into the excel sheet
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for the
																								// excel file
			String fileName = "YearTable" + timeStamp + ".xlsx";
			String path = ".//testData/" + fileName;
			write.writeExcel(datas, path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("TestCase_02_01_StoringTheYearTableInExcel got failed, storing the data was unsuccessful");
			myAssert.fail();
		}

		logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Ended ----");
	}

}
