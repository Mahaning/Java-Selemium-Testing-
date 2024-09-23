/* 
 * This class File will validate the test case conditions
 */
package testScenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validation {
	WebDriver driver;
	WebDriverWait wait;
//	default class constructor
	public Validation() {
		
	}
//	class constructor
	public Validation(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
// get all listed Hotel Names
	public  String[] getHotelNames(){
		
		List<WebElement> hotelNameElements = driver.findElements(By.xpath("//button[@data-testid='item-name']/span"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(hotelNameElements));//using Explicit wait for element load
		
		String[] hotelNames = new String[hotelNameElements.size()];//storing list element into array
		//displaying all name value
		for(int i=0;i<hotelNameElements.size();i++) {
			String hotelName = hotelNameElements.get(i).getText();
			hotelNames[i] = hotelName;
		}
		
		return hotelNames;
	}

//	get All listed Hotel Prices
	public  String[] getPrice() {
		
		List<WebElement> hotelPriceElements = driver.findElements(By.xpath("//p[@data-testid='recommended-price']"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(hotelPriceElements));
		
		String[] prices = new String[hotelPriceElements.size()];
		
		for(int i=0;i<hotelPriceElements.size();i++) {
			String price = hotelPriceElements.get(i).getText().replace("₹","");
			prices[i] = price;
		}
		
		return prices;
	}
	
//	get All listed Hotel Rating
	public  String[] getRatings() {
		
		List<WebElement> hotelRatingElements = driver.findElements(By.xpath("//span[@itemprop='ratingValue']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfAllElements(hotelRatingElements));
		
		String[] ratings = new String[hotelRatingElements.size()];
		
		try {
			for(int i=0;i<hotelRatingElements.size();i++) {
				String rating = hotelRatingElements.get(i).getText();
				ratings[i] = rating;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return ratings;
	}

	// check ratings are in decreasing order or not
	public  String ratingValidation() {

		String[] ratings = getRatings();
		boolean result = true;
		try {
			for(int i=0;i<ratings.length-1;i++){
				double rating1 = Double.parseDouble(ratings[i]);
				double rating2 = Double.parseDouble(ratings[i+1]);
				if(rating1<rating2) {
					result=false;
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		if(result) {
			return "Test Passed";
		}else {
			return "Test Failed";
		}
	}
	
	//Check if the first 5 hotels belongs to the specific city searched for. Ex: Mumbai
	public  String cityNameValidation( String destination) {
		
		boolean result = true;
		List<WebElement> infoElements = driver.findElements(By.xpath("//button[@data-testid='distance-label-section']"));
		
		try {
			for(int i=0;i<5;i++) {
				infoElements.get(i).click();
				WebElement loc = driver.findElement(By.xpath("//span[@itemprop='addressLocaspanty']"));
				if(loc.isDisplayed()) {
					String hotelLoc =  loc.getText().replace(", ", "");
					System.out.println(hotelLoc);
					if(hotelLoc.equals(destination)) {
						result = true;
					}
					else {
						result = false;
					}
				}
				else {
					continue;
				}
			}
		}catch (Exception e) {
				// TODO: handle exception
		}
		
		if(result) {
			return "Test Passed";
		}
		else {
			return "Test Failed";
		}
	}
	
	//Printing Hotel Price
	public  void printHotelPrice() {
		try {
			
			String[] hotelName = getHotelNames();
			String[] hotelPrice = getPrice();

			
			for(int i=0;i<hotelName.length;i++) {
				
				System.out.println(hotelName[i]+"-----"+hotelPrice[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//Printing Hotel Ratings
	public  void printHotelRatings() {
		
		try {
			
			String[] hotelName = getHotelNames();
			String[] hotelRatings = getRatings();
		
			for(int i=0;i<hotelName.length;i++) {
				
				System.out.println(hotelName[i]+"-----"+hotelRatings[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
