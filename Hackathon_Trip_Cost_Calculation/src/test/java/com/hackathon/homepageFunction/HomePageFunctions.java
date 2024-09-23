package com.hackathon.homepageFunction;
	

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;


import com.hackathon.driver.DriverSetup;



public class HomePageFunctions extends DriverSetup{

	
@FindBy(xpath = "//span[text()='Hotels']")
WebElement hotelIconElement;

@FindBy(xpath =  "//input[@id='BE_hotel_destination_city']")
WebElement hotelSearchBoxElement;





public void initPageFactory() {
	PageFactory.initElements(driver, this);
}
public void hotelPlaceRequirements() throws InterruptedException  {		
	
	hotelIconElement.click();

	
	
	Thread.sleep(5000);
	
	 
}

public void placeSelection() throws InterruptedException {


	hotelSearchBoxElement.click();
	Thread.sleep(5000);
	hotelSearchBoxElement.sendKeys("Goa");
	Thread.sleep(5000);
	hotelSearchBoxElement.sendKeys(Keys.ENTER);
	
}

public void clickcheckinhotelDate() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	        // Find and click on the check-out date field to open the calendar
	 WebElement checkOutDateField = driver.findElement(By.id("BE_hotel_checkout_date"));
	 
	 checkOutDateField.click();

	 // Calculate date after 5 days from tomorrow for check-out
	 LocalDate checkOutDate = LocalDate.now().plusDays(6);

	 String checkOutDateFormatted = checkOutDate.format(formatter);

	 // Select the date after 5 days for check-out

	 String checkOutDateXpath = String.format("//td[@data-date='%s']", checkOutDateFormatted);
	   
	 WebElement checkOutDateElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkOutDateXpath))); 
	 
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkOutDateElement);
		
	}

	public void travellerscount() {
		WebElement travellersElement  = driver.findElement(By.xpath("//span[@class='txt-ellipses hotel_passengerBox travellerPaxBox']"));
		travellersElement.click();
		
//		WebElement plusElement = driver.findElement(By.xpath("(//span[@class='ddSpinnerPlus'])[1]"));
		 WebElement plusElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ddSpinnerPlus'])[1]"))); 
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", plusElement);
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", plusElement);
	}
	
	public void searchButtonClick() {
		WebElement submitElement = driver.findElement(By.xpath("//input[@type='submit']"));
		submitElement.click();
		
	}
	
	

}






	

