package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;

public class LoanCalculatorPage{
	
	WebDriver driver;
	BaseClass bc=new BaseClass();
	Actions act;
	JavascriptExecutor js;
	
	public LoanCalculatorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = (JavascriptExecutor)driver;
	}	
	

	
	//*********************************Web Elements For LoanCalculator Page*********************************//
	//Main Menu Element
	@FindBy(xpath = "//a[@id = 'menu-item-dropdown-2696']")
	WebElement mainMenuBtn;
	
	//Loan Calculator Element
	@FindBy(xpath = "//a[@title = 'Loan Calculator']")
	WebElement loanCalcBtn;
	
	
	//All the elements
	//Loan Amount Text Box
	@FindBy(xpath = "//input[@id = 'loanamount']")
	WebElement loanAmountTextBox;
	
	//Loan Amount Slider
	@FindBy(xpath = "//div[@id = 'loanamountslider']/span")
	WebElement loanAmountSlider;
	
	//Interest Rate Text Box
	@FindBy(xpath = "//input[@id = 'loaninterest']")
	WebElement IntRateTextBox;
	
	//Interest Rate Slider
	@FindBy(xpath = "//div[@id = 'loaninterestslider']/span")
	WebElement IntRateSlider;
	
	//Loan Tenure Text Box
	@FindBy(xpath = "//input[@id = 'loanterm']")
	WebElement loanTenureTextBox;
		
	//Loan Tenure Slider
	@FindBy(xpath = "//div[@id = 'loantermslider']/span")
	WebElement loanTenureSlider;
	
	//Fees & Charges Text Box
	@FindBy(xpath = "//input[@id = 'loanfees']")
	WebElement feesAndChargesTextBox;
	
	//Fees & Charges Slider
	@FindBy(xpath = "//div[@id = 'loanfeesslider']/span")
	WebElement feesAndChargesSlider;
	
	//EMI Text Box
	@FindBy(xpath = "//input[@id = 'loanemi']")
	WebElement emiTextBox;
	
	//EMI Slider
	@FindBy(xpath = "//div[@id = 'loanemislider']/span")
	WebElement emiSlider;
	
	//Year Button
	@FindBy(xpath = "//input[@id = 'loanyears']")
	WebElement yearBtn;
	
	//Month Button
	@FindBy(xpath = "//input[@id = 'loanmonths']")
	WebElement monthBtn;
	
	//Element of Loan Amount Calculator
	//Loan Amount Calculator Button
	@FindBy(id = "loan-amount-calc")
	WebElement loanAmountCalcBtn;
	
	
	//Element of Loan Tenure Calculator
	//Loan Amount Calculator Button
	@FindBy(id = "loan-tenure-calc")
	WebElement loanTenureCalcBtn;
	
	
	//Navigators for the Page
	
	//to EMI calc page
	public void navigatorForEMICalc() { 
		mainMenuBtn.click();
		loanCalcBtn.click();
	}
	
	//to loan amt calculator page
	public void navigatorForLoanAmountCalc() { 
		mainMenuBtn.click();
		loanCalcBtn.click();
		loanAmountCalcBtn.click();
	}
	
	//to loan Tenure Calculators page
	public void navigatorForLoanTenureCalc() { 
		mainMenuBtn.click();
		loanCalcBtn.click();
		loanTenureCalcBtn.click();
	}
	
	//*********************************Actions and Methods For LoanCalculator Page*********************************//
	
	//Clicking on Year and Month
	public void clickYear() {
		js.executeScript("arguments[0].click();", yearBtn);
	}
	
	public void clickMonth() {
		js.executeScript("arguments[0].click();", monthBtn);
	}
	
	//Methods for Loan Amount
	//Returning the Loan Amount Text Box Web Element
	public WebElement getLoanAmtTextBox() {
		return this.loanAmountTextBox;
	}
	//Returning the Loan Amount Text Box Web Element
	public WebElement getLoanAmtSlider() {
		return this.loanAmountSlider;
	}
	//Sliding the Loan Amount Slider
	public void moveLoanAmtSlider(int x) {
		act.dragAndDropBy(loanAmountSlider, x, 0).build().perform();
	}
	//Returning the value of Loan Amount Text Box Web Element
	public String getLoanAmtTextBoxValue() {
		return js.executeScript("return document.getElementById('loanamount').value").toString();
	}
	
	//Methods for Interest Rate
	//Returning the Interest Rate Text Box Web Element
	public WebElement getIntRateTextBox() {
		return this.IntRateTextBox;
	}
	//Returning the Interest Rate Text Box Web Element
	public WebElement getIntRateSlider() {
		return this.IntRateSlider;
	}
	//Sliding the Interest Rate Slider
	public void moveIntRateSlider(int x) {
		act.dragAndDropBy(IntRateSlider, x, 0).build().perform();
	}
	//Returning the value of Interest Rate Text Box Web Element
	public String getIntRateTextBoxValue() {
		return js.executeScript("return document.getElementById('loaninterest').value").toString();
	}
	
	//Methods for Loan Tenure
	//Returning the Loan Tenure Text Box Web Element
	public WebElement getLoanTenureTextBox() {
		return this.loanTenureTextBox;
	}
	//Returning the Loan Tenure Text Box Web Element
	public WebElement getLoanTenureSlider() {
		return this.loanTenureSlider;
	}
	//Sliding the Loan Tenure Slider
	public void moveLoanTenureSlider(int x) {
		act.dragAndDropBy(loanTenureSlider, x, 0).build().perform();
	}
	//Returning the value of Loan Tenure Text Box Web Element
	public String getLoanTenureTextBoxValue() {
		return js.executeScript("return document.getElementById('loanterm').value").toString();
	}
	
	//Methods for Fees & Charges
	//Returning the Fees & Charges Text Box Web Element
	public WebElement getFeesAndChargesTextBox() {
		return this.feesAndChargesTextBox;
	}
	//Returning the Fees & Charges Text Box Web Element
	public WebElement getFeesAndChargesSlider() {
		return this.feesAndChargesSlider;
	}
	//Sliding the Fees & Charges Slider
	public void moveFeesAndChargesSlider(int x) {
		act.dragAndDropBy(feesAndChargesSlider, x, 0).build().perform();
	}
	//Returning the value of Fees & Charges Text Box Web Element
	public String getFeesAndChargesTextBoxValue() {
		return js.executeScript("return document.getElementById('loanfees').value").toString();
	}
	
	//Methods for EMI
	//Returning the EMI Text Box Web Element
	public WebElement getEMITextBox() {
		return this.emiTextBox;
	}
	//Returning the EMI Text Box Web Element
	public WebElement getEMISlider() {
		return this.emiSlider;
	}
	//Sliding the EMI Slider
	public void moveEMISlider(int x) {
		act.dragAndDropBy(emiSlider, x, 0).build().perform();
	}
	//Returning the value of EMI Text Box Web Element
	public String getEMITextBoxValue() {
		return js.executeScript("return document.getElementById('loanemi').value").toString();
	}
	
	//set loan amount in loan amount textbox
	public void setLoanAmount(String Amt) {
		
		loanAmountTextBox.clear();
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		loanAmountTextBox.sendKeys(Keys.BACK_SPACE);
		
		loanAmountTextBox.sendKeys(Amt);
		loanAmountTextBox.sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].value=\""+Amt+"\"",loanAmountTextBox);
//		loanAmountTextBox.sendKeys(Keys.ENTER);
//		js.executeScript("arguments[0].click();", yearBtn);

		System.out.println("=======================================================================================");
		System.out.println("ENterd loan amt value: "+Amt);
		System.out.println("=======================================================================================");
	}
	
	//set loan amount in loan Intrest Rate textbox
	public void setLoanIntrestRate(String interest) {
		
		IntRateTextBox.click();
		IntRateTextBox.clear();
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(Keys.BACK_SPACE);
		IntRateTextBox.sendKeys(interest);
//		js.executeScript("arguments[0].value=\""+interest+"\"",IntRateSlider);
//		js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter' }))", yearBtn);
		IntRateTextBox.sendKeys(Keys.ENTER);

		System.out.println("=======================================================================================");
		System.out.println("ENterd Intrest Rate amt value: "+interest);
		System.out.println("=======================================================================================");
	}
	
	//set loan amount in loan Tenure textbox
	public void setLoanTenure(String loanTenure) {

		loanTenureTextBox.click();
		loanTenureTextBox.clear();
		loanTenureTextBox.sendKeys(Keys.BACK_SPACE);
		loanTenureTextBox.sendKeys(Keys.BACK_SPACE);
		loanTenureTextBox.sendKeys(loanTenure);
		loanTenureTextBox.sendKeys(Keys.ENTER);
		System.out.println("=======================================================================================");
		System.out.println("ENterd loanTenure  value: "+loanTenure);
		System.out.println("=======================================================================================");
	}
	
	//set loan amount in Fees And Charges textbox
	public void setFeesAndCharges(String fees) {

		feesAndChargesTextBox.click();
		feesAndChargesTextBox.clear();
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(Keys.BACK_SPACE);
		feesAndChargesTextBox.sendKeys(fees);
		feesAndChargesTextBox.sendKeys(Keys.ENTER);
		System.out.println("=======================================================================================");
		System.out.println("ENterd fees and charges amt value: "+fees);
		System.out.println("=======================================================================================");
	}
	public void setEMI(String emi) {
		emiTextBox.clear();
//		js.executeScript("arguments[0].value=\""+emi+"\"", emiTextBox);
		feesAndChargesTextBox.click();
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(Keys.BACK_SPACE);
		emiTextBox.sendKeys(emi);
		emiTextBox.sendKeys(Keys.ENTER);
		System.out.println("=======================================================================================");
		System.out.println("ENterd Emi value: "+emi);
		System.out.println("=======================================================================================");
	}
	
	public double getLoanAmountSliderValue() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String location=loanAmountSlider.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		return per;
	}
	
	public double getLoanIntrestRateSliderValue() {
		String location=IntRateSlider.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		return per;
	}
	
	public double getLoanTenureSliderValue() {
		String location=loanTenureSlider.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		return per;
	}
	public double getFeesAndChargesSliderValue() {
		String location=feesAndChargesSlider.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		return per;
	}
	public double getEMISliderValue() {
		String location=emiSlider.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		return per;
	}
	
}
