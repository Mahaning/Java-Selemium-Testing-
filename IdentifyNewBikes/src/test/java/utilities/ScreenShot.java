package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot{
	WebDriver driver;
	public ScreenShot(WebDriver driver){
		this.driver=driver;
	}
public String screenshot(String name) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") + "\\screenShots\\" + name + " " + timeStamp + ".png";
	File targetLocation = new File(path);
	FileUtils.copyFile(file, targetLocation);
	return path;
}
}
