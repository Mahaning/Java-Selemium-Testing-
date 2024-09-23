package com.hackathon.stepdefinitions;

import com.hackathon.baseTest.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSelection extends BaseTest {

	@Given("user Rating Successful and all requirements are done") 
	public void userRating() throws InterruptedException {
		hotel.initPageFactory();
		hotel.userRating();
		
	
	}
	@When("Sorted the Hotel As Per The requirements")
	public void hotalRequirements() throws InterruptedException  {
		hotel.hotels();
	}
	
	@Then("Navigated to the base Url")
	public void previouspage() throws InterruptedException {
		hotel.navigateurl();
	}
}
