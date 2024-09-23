package pageObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverSetup;

public class LoginPage extends DriverSetup
{
	
	WebDriver driver;
	String zigWheelWindow;
	Set<String> windows;
	String errorMessage;
	
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	//Locators
	@FindBy(id="forum_login_title_lg")
	WebElement login;
	
	@FindBy(xpath="(//div[@class='newgf-login'])[2]/div")
	WebElement googleSignIn;
	
	@FindBy(id="identifierId")
	WebElement email;
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement next;
	
	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']")
	WebElement error;
	
	
		
	
	//Action Methods
	public void navigateToHomePage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.navigate().to(baseUrl);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnGoogle()
	{
		googleSignIn.click();
	}
		
	public void switchToGoogleWindow() throws InterruptedException
	{
		
		zigWheelWindow = driver.getWindowHandle();
		windows = driver.getWindowHandles();
		
		for (String googleSignInWindow : windows) 
		{
	            driver.switchTo().window(googleSignInWindow);     
	    }
		Thread.sleep(5000);
		
	}
	
	public void giveEmailId(String Email) throws InterruptedException
	{
		email.clear();
		email.sendKeys(Email);
		Thread.sleep(5000);
	}
	
	public void clickOnSignIn()
	{
		next.click();
	}
	
	public void captureErrorMessage()
	{
		String Message = error.getText();
		System.out.println(Message);
	}
	
	

}
