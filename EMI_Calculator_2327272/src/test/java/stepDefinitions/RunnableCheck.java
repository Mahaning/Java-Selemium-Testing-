package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RunnableCheck 
{
	WebDriver driver=BaseClass.getDriver();
	
	@Given("the user navigates to the Application")
	public void the_user_navigates_to_the_application() 
	{
	    System.out.println("Searching for title");
	}

	@Then("the page title has to be displayed")
	public void the_page_title_has_to_be_displayed() 
	{
	    WebElement headder=driver.findElement(By.xpath("//h1[contains(text(),'EMI Calculator for Home Loan, Car Loan & Personal ')]"));
	    String title= headder.getText();
	    if(title.equals("EMI Calculator for Home Loan, Car Loan & Personal Loan in India"))
	    {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
