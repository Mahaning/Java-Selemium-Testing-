package utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup
{
	

	public static WebDriver driver;	
	public static String baseUrl = "https://www.zigwheels.com/";
	public static String browsertype;
	public static WebDriver driverInstantiate(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			
			//Create prefs map to store all preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();
			    
			//Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			    
			//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
			driver = new ChromeDriver(options);
			
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseUrl);		
		return driver;
	}
	
	public static void explicitWait(WebElement Element)
	{
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public static void driverTearDown() {
		driver.quit();
	}
	


}
