package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.DriverSetup;

public class UpcomingBikesPage extends DriverSetup
{
	
	
    WebDriver driver;
    JavascriptExecutor js;
    Actions actions;
    String Bike;
    String Price;
    String LaunchDate;
    double price;
     
	
	
	//Constructor
	public UpcomingBikesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
		actions = new Actions(driver);
		
	}

	
	
	//Locators
	@FindBy(className="custom-select")
	WebElement bikeCompanies;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement viewMoreBikes;
	
	@FindBy(xpath="//a[@data-track-label='model-name']")
	List<WebElement> bikesName;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> bikesPrice;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> bikesLaunchDate;
		
	
	
	
	
	//Action Methods
	public void selectHonda()
	{
         
		DriverSetup.explicitWait(bikeCompanies);
		Select manufacture = new Select(bikeCompanies);
		manufacture.selectByVisibleText("Honda");
	}
	
	public void clickOnViewMoreBikes() throws InterruptedException
	{
		
		//ScrollDown
		js.executeScript("window.scrollBy(0,1300);");
		
		Thread.sleep(5000);
		DriverSetup.explicitWait(viewMoreBikes);
		viewMoreBikes.click();
		Thread.sleep(2000);
		
	}
	
	public void hondaBikeList()
	{
		for(int i=0; i<bikesName.size(); i++)
		{
			
			
			Bike = bikesName.get(i).getAttribute("title");
			Price = bikesPrice.get(i).getText();
			LaunchDate = bikesLaunchDate.get(i).getText();
			
			String p=Price.replace("Rs. ","").replace(",", "");
			if(p.contains("Lakh")) 
			{
			   price = Double.parseDouble(p.replace(" Lakh", ""))*100000; 
			}
			else 
			{
				price = Double.parseDouble(p);
			}
			
			  if(price<400000)
			    {
				    System.out.println("Bike name:"+Bike);
				    System.out.println("Bike price:"+Price);
			        System.out.println(LaunchDate);
			        System.out.println();
			    }


		}
		
		  
	}
	
	public void displayHondaBikesLessThan4Lac()
	{
		for(int i=0; i<bikesName.size(); i++)
		{ 
		
		    if(price<400000)
		    {
			    System.out.println("Bike name:"+Bike);
			    System.out.println("Bike price:"+Price);
		        System.out.println(LaunchDate);
		        System.out.println();
		    }
		}
		
	}


	
}
