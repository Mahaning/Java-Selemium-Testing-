package com.hackathon.driver;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverSetup {
	protected static WebDriver driver;
	protected static WebDriverWait wait;


	
	protected void initChromeDriver() {
		driver = new ChromeDriver();
		setUpWait();
		driver.manage().window().maximize();
		
	}
	
	protected void initEdgeDriver() {
		driver = new EdgeDriver();
		setUpWait();
		driver.manage().window().maximize();
	}

	private void setUpWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	protected void navigate(String URL) {
		driver.navigate().to(URL);
		
	}
	
}
