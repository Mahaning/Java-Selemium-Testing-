package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;

public class HomeLoanEMICalculatorPage {
	
	WebDriver driver;
	BaseClass bc=new BaseClass();
	JavascriptExecutor js;
	
	public HomeLoanEMICalculatorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
	 
	

	
	//*********************************Web Element For HomeLoanEMICalculator Page*********************************//
	
	//Main Menu Element
	@FindBy(xpath = "//a[@id = 'menu-item-dropdown-2696']")
	WebElement mainMenuBtn;
	
	//Home Loan EMI Calculator
	@FindBy(xpath = "//a[@title = 'Home Loan EMI Calculator']")
	WebElement homeLoanEmiCalcBtn;
	
	
	@FindBy(xpath = "//table[@class = 'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']")
	List<WebElement> rows;
	
	//Columns
	@FindBy(xpath = "//table[@class = 'noextras']/tbody/tr/th")
	List<WebElement> cols;
	
	//Home Value (HV)
	@FindBy(xpath="//input[@id='homeprice']") 
	WebElement textBoxHV;
	
	//Margin OR Down Payment (DP)
	@FindBy(xpath="//input[@id='downpayment']") 
	WebElement textBoxDP;
	
	//Loan Insurance
	@FindBy(xpath="//input[@id='homeloaninsuranceamount']") 
	WebElement textBoxLI;
	
	//Interest Rate
	@FindBy(xpath="//input[@id='homeloaninterest']") 
	WebElement textBoxInterestRate;
	
	//Loan Tenure
	@FindBy(xpath="//input[@id='homeloanterm']") 
	
	WebElement textBoxLoanTenure;
	
	//Loan Fees & Charges
	@FindBy(xpath="//input[@id='loanfees']") 
	WebElement textBoxLoanCharges;
	
	//One-time Expenses
	@FindBy(xpath="//input[@id='onetimeexpenses']") 
	WebElement textBoxOneTimeExpenses;
	
	//Property Taxes / year
	@FindBy(xpath="//input[@id='propertytaxes']") 
	WebElement textBoxPropertyTax;
	
	//Home Insurance / year
	@FindBy(xpath="//input[@id='homeinsurance']") 
	WebElement textBoxHomeInsurancePerYear;
	
	//Maintenance Expenses / month
	@FindBy(xpath="//input[@id='maintenanceexpenses']") 
	WebElement textBoxMaintenence;
	
	//Start Month & Year
	@FindBy(xpath="//input[@id='startmonthyear']") 
	WebElement calender;

	
	//*********************************Actions and Methods For HomeLoanEMICalculator Page*********************************//
	
	//Navigator for the page
	public void navigator() {
		mainMenuBtn.click();
		homeLoanEmiCalcBtn.click();
	}
	
	//setting value to home textbox
	public void setHomeValue(String homeValue)
	{
		textBoxHV.clear();
		textBoxHV.sendKeys(homeValue);
	}
	
	//setting value to downPayment textbox
	public void setDownPayment(String downPayment){
		textBoxDP.clear();
		textBoxDP.sendKeys(downPayment);
	}
	
	//setting value to loanInsurance textbox
	public void setLoanInsurance(String loanInsurance){
		textBoxLI.clear();
		textBoxLI.sendKeys(loanInsurance);
	}
	
	//setting value to interestRate textbox
	public void setInterestRate(String interestRate){
		textBoxInterestRate.clear();
		textBoxInterestRate.sendKeys(Keys.BACK_SPACE);
		textBoxInterestRate.sendKeys(interestRate);
	}
	
	//setting value to loanTenure textbox
	public void setLoanTenure(String loanTenure){
		textBoxLoanTenure.sendKeys(Keys.BACK_SPACE);
		textBoxLoanTenure.sendKeys(Keys.BACK_SPACE);
//		textBoxInterestRate.clear();
		textBoxLoanTenure.sendKeys(loanTenure);
	}
	
	//setting value to loanCharges textbox
	public void setLoanCharges(String loanCharges){
//		textBoxLoanCharges.sendKeys(Keys.BACK_SPACE);
//		textBoxLoanCharges.sendKeys(Keys.BACK_SPACE);
//		textBoxLoanCharges.sendKeys(Keys.BACK_SPACE);
//		textBoxLoanCharges.sendKeys(Keys.BACK_SPACE);
		textBoxLoanCharges.clear();
		textBoxLoanCharges.sendKeys(loanCharges);
	}
	
	//setting value to expenses textbox
	public void setOneTimeExpenses(String expenses){
		textBoxOneTimeExpenses.clear();
		textBoxOneTimeExpenses.sendKeys(expenses);
	}
	
	//setting value to propertyTax textbox
	public void setPropertyTax(String propertyTax){
		textBoxPropertyTax.clear();
		textBoxPropertyTax.sendKeys(propertyTax);
	}
	
	//setting value to HomeInsurancePerYear textbox
	public void setHomeInsurancePerYear(String hipy){
		textBoxHomeInsurancePerYear.clear();
		textBoxHomeInsurancePerYear.sendKeys(hipy);
	}
	
	//setting value to charge textbox
	public void setMaintenenceCharge(String charge){
		textBoxMaintenence.clear();
		textBoxMaintenence.sendKeys(charge);
	}
	
	public void setCalender(String yearInputString,String monthString){
		calender.click();
		int yearInput=Integer.parseInt(yearInputString);
		
		String yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
		int yearDisplayed=Integer.parseInt(yearDisplayedString);
		if(yearDisplayed<yearInput)
		{
			driver.findElement(By.xpath("(//th[@class=\"next\"])[2]")).click();
			yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
			yearDisplayed=Integer.parseInt(yearDisplayedString);
			
		}
		if(yearDisplayed>yearInput)
		{
			driver.findElement(By.xpath("(//th[@class=\"prev\"])[2]")).click();
			yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
			yearDisplayed=Integer.parseInt(yearDisplayedString);
		}
		
		List<WebElement> months=driver.findElements(By.xpath("//span[contains(@class,\'month\')]"));
		for(WebElement month:months)
		{
			if(month.getText().equalsIgnoreCase(monthString))
			{
				month.click();
				break;
			}
		}
		
	}


	//Returning The Whole Year Table in array
	public String[][] getTableData() {
		String[][] datas = new String[rows.size()][cols.size()];
		for(int i = 0; i < rows.size(); i++) {
			for(int j = 0; j < cols.size(); j++) {
				datas[i][j] = driver.findElement(By.xpath("//table[@class = 'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']["+(i+1)+"]/td["+(j+1)+"]")).getText();
			}
		}
		return datas;
	}
	
	
	//Scrolls to the displayed table
	public void scrollToTable() {
		
		js.executeScript("arguments[0].scrollIntoView();", rows.get(0));
	}
}
