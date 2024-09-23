Feature: Browser navigate to yatra.com page
@SmokeTest
  Scenario: Navigate to the page and giving the HotelRequirements
    Given yatra.com page landed successfully
    When Click on the Hotel Icon successful
    Then Click and search location as "GOA"
  @SmokeTest  
  Scenario: Calender Element Handling
  Given Calender Element Handling done For Checkin and Checkout date
  When Select traveller and room selection done
  Then Click for Search Element Done
  @SmokeTest
  Scenario: Hotel selection is successful
  	Given user Rating Successful and all requirements are done
  	When Sorted the Hotel As Per The requirements
  	Then Navigated to the base Url
  	@SmokeTest
  Scenario: CruseLine Selection 
  	Given navigate to cruseLine
  	When Get all Inclusions
  	Then Going for Appling Voucher
  	@SmokeTest
  Scenario: Voucher & Error Detection
  	Given Window Handling Done
  	When Error Detection Done
  	Then ScreenShot Done
  		
  	
    