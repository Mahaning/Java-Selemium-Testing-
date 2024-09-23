package com.hackathon.stepdefinitions;

import com.hackathon.baseTest.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CruseLine_Selection extends BaseTest  {
	
	@Given("navigate to cruseLine")
	public void cruseLine() {
		hotel.initPageFactory();
		hotel.cruseLine();
	}
	@When("Get all Inclusions")
	public void inclusions() {
		hotel.inclusion();
	}
	@Then("Going for Appling Voucher")
	public void voucher() {
		hotel.voucher();
	}
	
	@Given("Window Handling Done")
	public void windowHandle() throws InterruptedException {
		requirements.windowHandle();
	}
	@When("Error Detection Done")
	public void errorDetection() throws InterruptedException {
		requirements.errorDetection();
	}
	@Then("ScreenShot Done")
	public void ScreenShot() {
		System.out.println("ScreenShotDone");
	}
	
	
	

}
