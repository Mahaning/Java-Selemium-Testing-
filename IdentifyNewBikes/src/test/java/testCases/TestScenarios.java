package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.DriverSetup;
import pageObjectRepository.HomePage;
import pageObjectRepository.LoginPage;
import pageObjectRepository.UpcomingBikesPage;
import pageObjectRepository.UsedCarsPage;




public class TestScenarios extends DriverSetup
{
	
	public static WebDriver driver;
	static HomePage homePage;
	static UpcomingBikesPage upcomingBikesPage;
	static UsedCarsPage usedCarsPage;
	static LoginPage loginPage;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) {
		
		driver = DriverSetup.driverInstantiate(br);
		homePage = new HomePage(driver);	
		upcomingBikesPage = new UpcomingBikesPage(driver);
		usedCarsPage = new UsedCarsPage(driver);
		loginPage = new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	void upcomingBikes()
	{
		homePage.hoverOnNewBikes();
		homePage.clickUpcomingBikes();
		
	}
	
	@Test(priority=2)
	void displayHondaUpcomingBikes() throws InterruptedException
	{
	    upcomingBikesPage.selectHonda();
		upcomingBikesPage.clickOnViewMoreBikes();
		upcomingBikesPage.hondaBikeList();
		upcomingBikesPage.displayHondaBikesLessThan4Lac();
		
	}
	
	@Test(priority=3)
	void chennaiUsedCars()
	{
		usedCarsPage.hoverOnUsedCars();
		usedCarsPage.clickOnChennai();
	}
	
	@Test(priority=4)
	void displayPopularUsedCars()
	{
		usedCarsPage.scrollDownCarList();
		usedCarsPage.usedCarList();
	}
	
	@Test(priority=5)
	void login() throws InterruptedException
	{
		loginPage.navigateToHomePage();
		loginPage.clickOnLogin();
		
	}
	
	@Test(priority=6)
	void googleSignIn() throws InterruptedException
	{
		loginPage.clickOnGoogle();
		loginPage.switchToGoogleWindow();
		
	}
	
	@Test(priority=7, dataProvider="EmailId")
	void signIn(String mailId) throws InterruptedException
	{
		loginPage.giveEmailId(mailId);
		loginPage.clickOnSignIn();
	}
	
	
	@Test(priority=8)
	void captureErrorMessage()
	{
		loginPage.captureErrorMessage();
	}
	
	@DataProvider(name="EmailId")
	String [][] loginData()
	{
		String data[][]= {
				{"sh"},
				{"abc@gmail.com"},
				{"gf@gmail.com"},
				{"hh@gmail.com"}		
		};
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	

}
