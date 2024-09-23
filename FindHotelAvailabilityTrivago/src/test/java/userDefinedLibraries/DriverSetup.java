/*
 * This Class File is used to setup for BrowserDriver for Edge and Chrome browser
 */

package userDefinedLibraries;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	static WebDriver driver;

	public static WebDriver getWebDriver() {
		
		//reading user input 
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the Browser you want to test the website(1:chrome ,2:edge )");
		int choice = sc.nextInt();
		
		if(choice==1) {

			driver = new ChromeDriver();
		}
		else if(choice ==2) {
			
			driver = new EdgeDriver();
		}
		
		//ursl of web page
		String baseUrl = "https://www.trivago.in/";
		
		driver.get(baseUrl);
		System.out.println("Browser is Launched and website is loading");
		//Adding implicit wait for 10 Sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();//Maximizing Full screen
		
		driver.manage().deleteAllCookies();//deleting all cookies
		
		return driver;
	}

}
