package com.hackathon.homepageFunction;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hackathon.driver.DriverSetup;

public class AdditionalRequirements extends DriverSetup{

	public void windowHandle() throws InterruptedException {
		Thread.sleep(7000);
		Set<String> wh=driver.getWindowHandles();
		for(String w:wh) {
			driver.switchTo().window(w);
		if(driver.getTitle().equals("Yatra Gift Cards -  Buy Yatra Gift Vouchers Online, Gift Vouchers")) {
			System.out.println("Successfully Switches into Yatra Gift Cards -  Buy Yatra Gift Vouchers Online, Gift Vouchers Page \n");
			break;
		} 
		else {
			continue;
			
		}
	}
		System.out.println();
	
	}
		
	

		

	public void errorDetection() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("phone"))));
		WebElement phone=driver.findElement(By.id("phone"));
		
		Actions action=new Actions(driver);
		action.moveToElement(phone).build().perform();
	
		driver.findElement(By.id("Name")).sendKeys("Abc");
		
		phone.sendKeys("23211");
		
		driver.findElement(By.xpath("//*[@id=\"rescheduleRequest\"]/ul/li[9]/input")).click();
		
		Thread.sleep(1000);
		
		action.moveToElement(phone).build().perform();
		
		phone.sendKeys("9321187756");
		
		WebElement email=driver.findElement(By.id("email"));
		
		email.sendKeys("123@abc");
		
		String phoneerr=phone.getAttribute("data-errormsg");
		
		String emailerr=email.getAttribute("data-errormsg");
		
		System.out.println("Phone number error message : "+phoneerr);
		
		System.out.println("Email error message : "+emailerr);
		
		driver.findElement(By.xpath("//*[@id=\"rescheduleRequest\"]/ul/li[9]/input")).click();
	
		
	}
}
