package com.hackathon.homepageFunction;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hackathon.driver.DriverSetup;


public class AllRequirementsofHotel extends DriverSetup{
	
	
@FindBy(xpath= "//a[normalize-space()='User Rating']")
WebElement userRatingElement;
	
@FindBy(xpath= "//span[@class='checkbox']//parent::label[text()=contains(.,'Free Breakfast')]")
WebElement breakfastElement;

@FindBy(xpath="//span[@class='checkbox']//parent::label[text()=contains(.,'Free WiFi')]")
WebElement wifiElement;

@FindBy(xpath="//span[@class='checkbox']//parent::label[text()=contains(.,'Laundry facilities')]")
WebElement laundryElement;

@FindBy(xpath="//span[@class='checkbox']//parent::label[text()=contains(.,'Swimming pool')]")
WebElement swimmingpoolElement;

@FindBy(css="h2.hotel-name")
List<WebElement> hotel;

@FindBy(css="span.bold.ng-binding")
List<WebElement> price;

@FindBy(xpath = "//span[normalize-space()='Cruise']")
WebElement cruise;

@FindBy(css="ul.incl-desc.mtop20.listContent")
WebElement inclusion;


public void initPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void userRating() throws InterruptedException {
	

		wait.until(ExpectedConditions.visibilityOf(userRatingElement)).click();	
	
		wait.until(ExpectedConditions.visibilityOf(breakfastElement)).click();	
		wait.until(ExpectedConditions.visibilityOf(wifiElement)).click();	
		wait.until(ExpectedConditions.visibilityOf(laundryElement)).click();	
		wait.until(ExpectedConditions.visibilityOf(swimmingpoolElement)).click();	
			
		
		
		
	}
	
	
	public void hotels() throws InterruptedException {
		
		Thread.sleep(10000);

		int n;
		
		if(hotel.size()<2) n=hotel.size();else n=2;
		
		for(int i=0;i<=n;i++){
			String options=hotel.get(i).getText();
			System.out.println("Hotel Name : "+options);
			System.out.println("List WebElement Present");
			Thread.sleep(3000);
			System.out.println("Price : "+price.get(i*2+1).getText());
			System.out.println();
			}
	}
	
	public void navigateurl() throws InterruptedException {
		Thread.sleep(5000);
		String url = "https://yatra.com";
		driver.navigate().to(url);
		driver.manage().deleteAllCookies();
	}
	public void cruseLine() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("more-arr")));
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.className("more-arr"))).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(cruise));
		
		
		driver.findElement(By.id("booking_engine_cruise")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("item-name")));
		
		driver.findElement(By.className("item-name")).click();
		
	}
	public void inclusion() {
	
		 
		System.out.println("Inclusion");
		
		System.out.println();
		
		System.out.println(inclusion.getText());
		
		driver.navigate().to("https://yatra.com");
		
		driver.manage().deleteAllCookies();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("more-arr")));
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.className("more-arr"))).build().perform();

	}
	
	public void voucher() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("booking_engine_gift_voucher")));
		driver.findElement(By.id("booking_engine_gift_voucher")).click();
	}
}
