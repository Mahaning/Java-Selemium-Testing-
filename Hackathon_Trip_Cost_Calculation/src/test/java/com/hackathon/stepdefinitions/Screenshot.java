package com.hackathon.stepdefinitions;





import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hackathon.baseTest.BaseTest;


import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Screenshot extends BaseTest {
	@AfterStep
	public void captureScreenShot(Scenario scenario)  {
		final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","Screenshots");
		
	}

}
