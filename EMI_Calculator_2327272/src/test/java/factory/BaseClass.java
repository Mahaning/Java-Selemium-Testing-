package factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass
{
	public static WebDriver driver;	
	public static String browsertype;
	public static Properties p;
    static Logger logger;
	
//	driverInstantiate
	public static  WebDriver driverInstantiate()  {
		
		try {
			
			System.out.println("Opening Browser...");
			browsertype = getProperties().getProperty("browser");
			if (browsertype.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browsertype.equalsIgnoreCase("edge")) {
				EdgeOptions opt=new EdgeOptions();
				opt.addArguments("–guest");
				driver = new EdgeDriver();
			}
			return driver;
		}catch(Exception e) {
    		e.getStackTrace();
    	}
		return driver;
	}
	
//	close browser
	public static void driverTearDown() 
	{
		driver.quit();
	}
	
	 public static WebDriver getDriver() {
			return driver;
		}
 
 
 public static Properties getProperties() throws IOException
	{		 
     FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
    		
     p=new Properties();
		p.load(file);
		return p;
	}
}



