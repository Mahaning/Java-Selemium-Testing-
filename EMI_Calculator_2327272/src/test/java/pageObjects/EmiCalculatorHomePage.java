package pageObjects;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;
 
public class EmiCalculatorHomePage {
	WebDriver driver;
	BaseClass bc=new BaseClass();
	Actions act;
	JavascriptExecutor js;
	
	public EmiCalculatorHomePage(WebDriver driver)
	{
		this.driver=driver;
		act = new Actions(driver);
		
		PageFactory.initElements(driver, this);
		 js = (JavascriptExecutor)driver;
	}

	

	
	//*********************************Web Elements For EmiCalculators Page*********************************//
	
	//EMI Calculator Element
	@FindBy(xpath = "//a[@title = 'EMI Calculator']")
	WebElement emiCalcBtn;
	
	//Car Loan Element
	@FindBy(id = "car-loan")
	WebElement carLoan;
	
	//Car Loan Amount Text Box
	@FindBy(id = "loanamount")
	WebElement carLoanAmtTextBox;
	
	//Loan Interest Text Box
	@FindBy(id = "loaninterest") 
	WebElement intRateTextBox;
	
	@FindBy(xpath = "//input[@id = 'loanterm']")
	WebElement loanTenureTextBox;
	
	//Loan Tenure Slider
	@FindBy(xpath = "//*[@id='loantermslider']/span")
	WebElement loanTenSlider;
	
	//Loan Tenure Year Button
	@FindBy(xpath = "//label[@class = 'btn btn-secondary active']/input[@id = 'loanyears']")
	WebElement year;
	
	//Year 2024 in the table
	@FindBy(xpath = "//td[@id = 'year2024']")
	WebElement year2024;
	
	//Year 2025 in the table
	@FindBy(xpath = "//td[@id = 'year2025']")
	WebElement year2025;
	
	//Months of 2024
	@FindBy(xpath = "//tr[@id = 'monthyear2024']/td/div/table/tbody/tr")
	List<WebElement> months2024;
	
	//Months of 2025
	@FindBy(xpath = "//tr[@id = 'monthyear2025']/td/div/table/tbody/tr")
	List<WebElement> months2025;
	
	//*********************************Actions and Methods For EmiCalculators Page*********************************//
	
	//Navigator for the page
	public void navigator() {
		emiCalcBtn.click();
	}
	//Clicking on the car loan element
	public void clickCarLoan() {
		carLoan.click();
	}
	//Sending value to the Loan Amount Text Box
	public void setLoanAmt(String amt) {
		 
		js.executeScript("arguments[0].value=\""+amt+"\"",carLoanAmtTextBox);
//		carLoanAmtTextBox.clear();
//		carLoanAmtTextBox.sendKeys(amt);
		
	}
	//Sending value to the Loan Interest Text Box
	public void setInterest(String interest) {
		
		js.executeScript("arguments[0].value=\""+interest+"\"", intRateTextBox);
//		intRateTextBox.clear();
//		intRateTextBox.sendKeys(interest);
	}
	//Sliding the Loan Tenure Slider
	public void moveLoanTenureSlider(int x) {
		 
		js.executeScript("arguments[0].scrollIntoView(true)", loanTenSlider);
		act.dragAndDropBy(loanTenSlider,x,0).build().perform();
	}
	//Clicking on Loan Tenure Year Button
	public void clickOnYear() {
		 
		js.executeScript("arguments[0].click();", year);
	}
	//Scrolling to the Table Element
	public void scrollToTable() {
		 
		js.executeScript("arguments[0].scrollIntoView();", year2024);
	}
	//Clicking on 2024 and 2025
		public void clickOnYears() {
			 
			js.executeScript("arguments[0].click();", year2024);
			js.executeScript("arguments[0].click();", year2025);
//			year2024.click();
//			year2025.click();
		}
		
		public void setLoanTenure(String loanTenure) {
			js.executeScript("arguments[0].value=\""+loanTenure+"\"", loanTenureTextBox);
//			loanTenureTextBox.click();
//			loanTenureTextBox.clear();
//			loanTenureTextBox.sendKeys(loanTenure);
		}
		
	public void printFisrtMonthEMIPayment() {
		WebElement year=driver.findElement(By.xpath("((//table)[1]//following::tr/td)[1]"));
		js.executeScript("arguments[0].scrollIntoView();", year);
		js.executeScript("arguments[0].click();", year);
		String principal=driver.findElement(By.xpath("((//table)[1]//following::tr/td[2])[2]")).getText();
	    String interest=driver.findElement(By.xpath("((//table)[1]//following::tr/td[3])[2]")).getText();
	    System.out.println("First month principal is: "+principal);
	    System.out.println("First month interest is: "+interest);
	}
	//Printing the EMI Payment Table
	public void printTheEMIPaymentTable() {
		int cols = 3;
		//Printing the row of year 2024
		for(int j = 0; j < cols; j++) {
			System.out.print(driver.findElement(By.xpath("//tbody/tr[@class = "
							+ "'row no-margin yearlypaymentdetails'][1]/"
							+ "td["+(j + 1)+"]\t")).getText());
		}
		System.out.println(); //Moving the cursor to next line
		//Printing the rows of months under year 2024
		for(int i = 0; i < months2024.size(); i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(driver.findElement(By.xpath("//tr[@id = "
								+ "'monthyear2024']/td/div/table/tbody/tr["+(i+1)+"]/"
								+ "td["+(j+1)+"]\t")).getText());
			}
			System.out.println();
		}
		//Printing the row of year 2025
		for(int j = 0; j < cols; j++) {
			System.out.print(driver.findElement(By.xpath("//tbody/tr[@class = "
							+ "'row no-margin yearlypaymentdetails'][2]/td["+(j + 1)+"]"
							+ "\t")).getText());
		}
		System.out.println(); //Moving the cursor to next line
		//Printing the rows of months under year 2025
		for(int i = 0; i < months2025.size(); i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(driver.findElement(By.xpath("//tr[@id = 'monthyear2025']/td/div/table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]\t")).getText());
			}
			System.out.println();
		}
	}
}