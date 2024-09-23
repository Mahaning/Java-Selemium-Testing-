package com.hackathon.baseTest;


import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import com.hackathon.driver.DriverSetup;
import com.hackathon.homepageFunction.AdditionalRequirements;
import com.hackathon.homepageFunction.AllRequirementsofHotel;
import com.hackathon.homepageFunction.HomePageFunctions;

public class BaseTest extends DriverSetup{
	
	protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
	protected HomePageFunctions homePageFunctions = new HomePageFunctions();
	protected AllRequirementsofHotel hotel = new AllRequirementsofHotel();
	protected AdditionalRequirements requirements = new AdditionalRequirements();
	
	
	@BeforeSuite
	@Parameters({"baseURL", "browser"})
	public void initDriver(String baseURL, String browser){
		if(browser.equalsIgnoreCase("chrome")) {
			initChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			initEdgeDriver();
		}
		else {
			throw new SkipException("Browser is not available");
		}
		
		
		
		navigate(baseURL);
		
	}
	
	
	@AfterSuite
	protected void tearDown() {
		driver.quit();
		driver = null;
		
	}

}
