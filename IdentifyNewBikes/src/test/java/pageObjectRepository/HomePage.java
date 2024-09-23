package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverSetup;




public class HomePage
{
	
	WebDriver driver;
	Actions actions;
	
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	
	
	//Locators
	@FindBy(linkText="New Bikes")
	WebElement newBikes;
	
	@FindBy(xpath="//span[@data-tag-url='/upcoming-bikes']")
	WebElement upcomingBikes;
	
		
	
	//Action Methods
	public void hoverOnNewBikes()
	{
	    actions.moveToElement(newBikes).build().perform();
	}
	
	public void clickUpcomingBikes()
	{
		DriverSetup.explicitWait(upcomingBikes);
		upcomingBikes.click();   
	}
	
	

	
	

}
