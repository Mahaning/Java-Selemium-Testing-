package testObjectRepository;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	public HomePage() {}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	//destinationElement
	public  WebElement getDestinationElement() {
		By destination_loc=By.id("input-auto-complete");
		WebElement location=driver.findElement(destination_loc);
		return location;
	}
	//checkInElement
	public  WebElement getCheckInElement() {
		By checkin_loc=By.cssSelector("button[data-testid=search-form-calendar-checkin");
		WebElement checkin=	driver.findElement(checkin_loc);
		return checkin;
	}
	//checkOutElemet
	public  WebElement getCheckOutElement() {
		
		By checkOut_loc = By.cssSelector("button[data-testid=search-form-calendar-checkout");
		WebElement checkOutElement = driver.findElement(checkOut_loc);
		return checkOutElement;
	}
    //Calender Naxt Buuton
	public  WebElement getCalenderNextButtonElement() {
		By next_loc=By.cssSelector("button[data-testid=calendar-button-next");
		WebElement next= driver.findElement(next_loc);
		return next;
	}
	//checkoutmonthYear 
	public  List<WebElement> checkMonthYear() {
		By checkoutmonthYear_loc=By.cssSelector("h3.Heading_heading__xct3h.Heading_h-s___YnjF.mx-3.pb-3.font-bold");
		List<WebElement> checkoutmonthYear= driver.findElements(checkoutmonthYear_loc);
		return checkoutmonthYear;
	}
	//guests And Rooms Element
	public  WebElement getGuestsAndRoomsElement() {
		By guestsAndRoomsElement_loc=By.cssSelector("button[data-testid=search-form-guest-selector]");
		WebElement guestsAndRoomsElement = driver.findElement(guestsAndRoomsElement_loc);
		return guestsAndRoomsElement;	
	}
//	get Guests-And-Rooms-DropDown Element
	public  WebElement getGuestsAndRoomsDropDownElement() {
		
		By guestsAndRoomsDropDown_loc = By.cssSelector("div[data-testid='guest-selector-popover']");
		WebElement guestsAndRoomsDropDownElement = driver.findElement(guestsAndRoomsDropDown_loc);
		return guestsAndRoomsDropDownElement;
	}
	
//	get Adults-Count-Increasing-Element
	public  WebElement getAdultsCountIncreasingElement() {
		
		By adultsCountIncreasing_loc = By.xpath("//button[@data-testid='adults-amount-plus-button']");
		WebElement adultsCountIncreasingElement = driver.findElement(adultsCountIncreasing_loc);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(adultsCountIncreasingElement));
		
		return adultsCountIncreasingElement;
	}
	
	//adults-Count-Decreaseing-Element
	public  WebElement getAdultsCountDecreasingElement() {
		
		By adultsCountDecreasing_loc = By.xpath("//button[@data-testid='adults-amount-minus-button']");
		WebElement adultsCountDecreasingElement = driver.findElement(adultsCountDecreasing_loc);
		return adultsCountDecreasingElement;
	}
	
	
	//current-Adult-Count-Element
	public  int getAdultsCount() {
		By adultsCount_loc = By.xpath("//input[@data-testid='adults-amount']");
		String adultsCount = driver.findElement(adultsCount_loc).getAttribute("value");
		int count = Integer.parseInt(adultsCount);
		return count;
	}
	
	//children-Count-Increasing-Element
	public  WebElement getChildrenCountIncreasingElement() {
		
		By childrenCountIncreasingElementBy = By.xpath("//button[@data-testid='children-amount-plus-button']");
		WebElement childrenCountIncreasingElement = driver.findElement(childrenCountIncreasingElementBy);
		return childrenCountIncreasingElement;
	}
	
	//children-Count-Decreasing-Elemnet
	public  WebElement getChildrenCountDecreasingElement() {
		
		By childrenCountDecreasing_loc = By.xpath("//button[@data-testid='children-amount-minus-button']");
		WebElement childrenCountDecreasingElement = driver.findElement(childrenCountDecreasing_loc);
		return childrenCountDecreasingElement;
	}
	
	//current-Room-Count-Element
	public  int getRoomCount() {
		
		By childrenCount_loc = By.xpath("//input[@data-testid='rooms-amount']");
		String roomsCount = driver.findElement(childrenCount_loc).getText();
		int count = Integer.parseInt(roomsCount);
		return count;
	}
	
	//rooms-Count-Increasing-Element
	public  WebElement getRoomsCountIncreasingElement() {
		
		By roomsCountIncreasing_loc = By.xpath("//button[@data-testid='rooms-amount-plus-button']");
		WebElement roomsCountIncreasingElement = driver.findElement(roomsCountIncreasing_loc);
		return roomsCountIncreasingElement;
	}
	
	
	//applyButtonElement
	public  WebElement getApplyButtonElement() {
		By applyButtonElement_loc=By.cssSelector("button[data-testid='guest-selector-apply']");
		WebElement applyButtonElement = driver.findElement(applyButtonElement_loc);
		return applyButtonElement;
	}
	//get hotel Names
	public  List<WebElement> gethotelNames(){
		By hotelNames_loc=By.cssSelector("span[itemprop=name]");
		List<WebElement> hotelNames=driver.findElements(hotelNames_loc);
		return hotelNames;
	}
	
	//get hotel Prices
	public  List<WebElement> gethotelPrices(){
		By hotelPrice_loc=By.cssSelector("p[data-testid=recommended-price]");
		List<WebElement> hotelPrice=driver.findElements(hotelPrice_loc);
		return hotelPrice;
	}
	
	//get hotel Rating
	public  List<WebElement> gethotelRating(){
		By hotelRating_loc=By.cssSelector("span[itemprop=ratingValue]");
		List<WebElement> hotelRating=driver.findElements(hotelRating_loc);	
		return hotelRating;
	}
	
	//get Short By Element
	public  WebElement getShortByElement() {
		By sortByDropDownEle_loc=By.id("sorting-selector");
		WebElement sortByDropDownEle=driver.findElement(sortByDropDownEle_loc);
		return sortByDropDownEle;
	}


}
