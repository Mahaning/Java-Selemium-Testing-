/*
 * This class file consists main method major methods which are used to enter input values
 */

package testScenario;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelUtility;
import userDefinedLibraries.ScreenShot;
import testObjectRepository.HomePage;



public class TestDetails {
	public WebDriver driver;
	TestMethods testMethods;
	Validation validation;
	HomePage HomePage;
	ScreenShot screenShot;
	
	public static String[] data;
	static String excelFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx";
//	creating class objects
	public void setUp() {
		
		driver = DriverSetup.getWebDriver();
		
		testMethods = new TestMethods(driver);
		validation = new Validation(driver);
		screenShot = new ScreenShot(driver);
		HomePage=new HomePage(driver);
		
	}
	//readingExcelData
    public String[] getExcelData(){
		
		//readingExcelData
		return ExcelUtility.readExcelData(excelFilePath,"data");
		
	}
    //used to call all methods
	public  void test() {
//		driver=getWebDriver1();
		testMethods.handleCookies();//cookie handling
		
		testMethods.setDestination(data[0]); //entering city/destination name
		System.out.println("==================================================================================================================");
		System.out.println("Destination input is selected(cliked).In destination Feild Data is Entered\ninput Value :"+data[0]);
		
		HomePage.getCheckInElement().click(); //clicking check in button of calender
		System.out.println("==================================================================================================================");
		System.out.println("Check In Date Element is Clicked");

		testMethods.setCheckIndate(data[1]); // entering check-in date
		System.out.println("==================================================================================================================");
		System.out.println("For Check In Date,calender is navigated and date is selected\n selected date value :"+data[1]);
		
		testMethods.setCheckOutdate(data[2]); //entering check-out-date
		System.out.println("==================================================================================================================");
		System.out.println("For Check Out Date,calender is navigated and date is selected\n selected date value :"+data[2]);

		
		HomePage.getGuestsAndRoomsElement().click();
		HomePage.getGuestsAndRoomsElement().click();//clicking Guests and room section/button
		System.out.println("==================================================================================================================");
		System.out.println("Geuests And Room is selected(clicked)");
		
		testMethods.setAdults(data[3]);//entering adult number value
		System.out.println("==================================================================================================================");
		System.out.println("Adults value is :"+data[3]);
		
		testMethods.setRooms(data[4]); //entering room values
		System.out.println("==================================================================================================================");
		System.out.println("Room Count value is :"+data[4]);
		screenShot.screenShotTC(driver,"value_Entry.png");
		HomePage.getApplyButtonElement().click(); //clicking apply button for search

		System.out.println("==================================================================================================================");
		System.out.println("Guests and rooms Section Apply Button is Clicked.");
		testMethods.setSortBy(data[5]); //selecting Sort by section value

		System.out.println("==================================================================================================================");
		System.out.println("From Sort By select box Rating Only is selected\n selected option :"+data[5]);

		
		
		//printingHotelPrice
		System.out.println("============================================================================================");
		System.out.println("************************ printing Hotel Price*****************************");
		validation.printHotelPrice();
		
		System.out.println("============================================================================================");
		
		//printingAllTheHotelRatings
		System.out.println("============================================================================================");
		System.out.println("************************printing All TheHotel Ratings *****************************");
		String excelFilePath1 = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx";
//		String excelFilePath1= "C:\\Users\\2327272\\eclipse-workspace\\trivago\\src\\test\\resources\\testdata\\TestData.xlsx";
		validation.printHotelRatings();
		String ratingValidation = validation.ratingValidation();
		System.out.println(ratingValidation);
		ExcelUtility.writeData(excelFilePath1, "Validation", 1, 2, ratingValidation);
		if(ratingValidation.equalsIgnoreCase("Test Passed")) {
			System.out.println("Rating Validation:Test Passed:");
			ExcelUtility.fillGreenColor(excelFilePath1, "Validation", 1, 2);
		}
		else {
			ExcelUtility.fillRedColor(excelFilePath1, "Validation", 1, 2);
			System.out.println("Rating Validation:Test Failed:");

		}
		
		System.out.println("============================================================================================");
		
		//takingScreenShotOfHotelDetailsPage
		screenShot.screenShotTC(driver,"hotelDetails.png");	
		System.out.println("ScreenShot Of HotelDetails Page is Taken");
		//validatingHotelsBelongToMumbaiCityOrNot
		System.out.println("=============================================================================================");
		
		System.out.println("Checking if the first 5 hotels belongs to the specific city searched for. Ex: "+data[0]);
		try{
			String cityNameValidation = validation.cityNameValidation(data[0]);
			System.out.println(cityNameValidation);
			ExcelUtility.writeData(excelFilePath1, "Validation", 2, 2, cityNameValidation);
			if(cityNameValidation.equalsIgnoreCase("Test Passed")) {
				System.out.println("City Name Validation Passed:");

				ExcelUtility.fillGreenColor(excelFilePath1,"Validation", 2, 2);
			}
			else {
				ExcelUtility.fillRedColor(excelFilePath1, "Validation", 2, 2);
				System.out.println("City Name Validation Failed:");

			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("=============================================================================================");
			
	
	}
	
//	used to close browser
	public  void closeBrowser() {
		
		driver.quit();
	}
	
	//Main Method
	public static  void main(String[] args){
		TestDetails td=new TestDetails();
		td.setUp();
		try {
			data = td.getExcelData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		td.test();
		td.closeBrowser();



		}

	
}
