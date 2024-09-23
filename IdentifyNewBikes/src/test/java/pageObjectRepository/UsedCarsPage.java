package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UsedCarsPage 
{
	
	WebDriver driver;
    JavascriptExecutor js;
	Actions actions;
	String CarModel;
	String CarPrice;
	
	//Constructor
	public UsedCarsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver;
	}

	
	
	//Locators
	
	@FindBy(linkText="Used Cars")
	WebElement usedCar;
	
	@FindBy(xpath="//span[@data-tag-url='/used-car/Chennai']")
	WebElement chennai;
	
	@FindBy(xpath="//div[@class='pl-30 zw-sr-paddingLeft']/a")
	List<WebElement> carsModel;
	
	@FindBy(xpath="//div[@class='pt-10']/span")
	List<WebElement> carsPrice;
	
		
	
	//Action Methods
	
	
	public void hoverOnUsedCars()
	{
		//ScrollUp
		js.executeScript("window.scrollBy(0, -1200);");
		actions.moveToElement(usedCar).build().perform();	
	}
	
	public void clickOnChennai()
	{
		chennai.click();
	}
	
	public void scrollDownCarList()
	{
		js.executeScript("window.scrollBy(0, 400);");
	}
	
	public void usedCarList()
	{
		
		for(int i=0; i<3; i++)
		{
			
			CarModel = carsModel.get(i).getText();
			System.out.println("Popular used Car Model: "+CarModel);
			
			CarPrice = carsPrice.get(i).getText();
			System.out.println("Popular used Car Price: "+CarPrice);
			
			System.out.println();
			
			
		}
		
		

	}
	
	public void displayPopularUsedCarModels()
	{
		for(int i=0; i<3; i++)
		{
			System.out.println("Popular used Car Model: "+CarModel);
			System.out.println("Popular used Car Price: "+CarPrice);
			System.out.println();
		}
	}
	
	

}
