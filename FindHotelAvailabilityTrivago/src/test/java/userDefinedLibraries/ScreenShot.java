/*
 * this file consists of screenshiots code
 */
package userDefinedLibraries;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ScreenShot {
	
	WebDriver driver;
//	default Constructor
	public ScreenShot() {}
	
	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}
//	get screen shot
	public void getScreenShot(String imgName) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+imgName+"");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	get screen shot
	public void getScreenShot(String imgName,WebElement element) {
		
		File src = element.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+imgName+"");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\";
//	get screen shot
	public  void screenShotTC(WebDriver scdriver,String fileName){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
		File src=((TakesScreenshot)scdriver).getScreenshotAs(OutputType.FILE);       
		try
		{  // now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File(filepath+fileName+"_"+dateFormat.format(date)+".png"));
			System.out.println(filepath+fileName+"_"+dateFormat.format(date)+".png");
        }catch (IOException e)      
			{
        		System.out.println(e.getMessage());      
			}
	  }

}

