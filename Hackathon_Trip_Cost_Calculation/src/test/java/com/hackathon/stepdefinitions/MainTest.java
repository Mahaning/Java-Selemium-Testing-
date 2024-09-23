package com.hackathon.stepdefinitions;


import com.hackathon.baseTest.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainTest extends BaseTest{
	@Given("yatra.com page landed successfully")
	public void yatra_com_page_landed_successfully() {
		
	    homePageFunctions.initPageFactory();
	}
	@When("Click on the Hotel Icon successful")
	public void click_on_the_hotel_icon_successful() throws InterruptedException {
		
	    homePageFunctions.hotelPlaceRequirements();
	    
	}
	@Then("Click and search location as {string}")
	public void click_and_search_location_as(String string) throws InterruptedException {
	    homePageFunctions.placeSelection();
	}
	
	@Given("Calender Element Handling done For Checkin and Checkout date")
	public void calenderHandling() {
		homePageFunctions.clickcheckinhotelDate();
	}
	@When("Select traveller and room selection done")
	public void travellercount() {
		homePageFunctions.travellerscount();
	}
	@Then("Click for Search Element Done")
	public void submitElement() {
		homePageFunctions.searchButtonClick();
		
	}

}
