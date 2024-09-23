
----------------------------------------
###------Find Hotel Availability-----###
----------------------------------------

## Case Study: Find Hotel Availability

## Problem Statement:  
---------------------
--Hotel Availability Automation

1) Availability of hotel rooms in next week (e.g. 27 July Check in and 28 July Check out) for a specific city. Ex: Mumbai

2) Get the Price of All the Hotels

3) Sort the hotels by rating

4) Check if the first 5 hotels belongs to the specific city searched for. Ex: Mumbai

--Suggested site: https://www.trivago.in/



## Detailed Description:
------------------------
1)Open the application https://www.trivago.in/ in chrome or fire fox browser.
2)In search field, enter City “Mumbai” as destination.
3)Select Check-In Date for the next week (e.g. 27 July)
4)Select Check-Out Date for the next week (e.g.28 July)
5)Select Adults 1
6)Select Rooms 1
7)Click on Apply.
8)Click on Search.
9)Select Sort By “Rating only”
10)Get the list of Rent of the hotels displayed.
11)Check that the all the ratings of the hotels is in descending order (e.g. 10.0>9.8>9.6..)
12)Close the browser



## Key Automation Scope:
------------------------
-Multiple browser handling
-Assign synchronization technique
-Use Calendar or Date-Picker
-Navigation to Home page
-Exception Handling
-Locating Elements


Note : Screen Shots are Stored In path : "./FindHotelAvailabilityTrivago/src/test/resources/Screenshot"
 --------------------------
| ##Results from Browsers: |
 --------------------------
 
Select the Browser you want to test the website(1:chrome ,2:edge )
1
Browser is Launched and website is loading
==================================================================================================================
Destination input is selected(cliked).In destination Feild Data is Entered
input Value :Mumbai
==================================================================================================================
Check In Date Element is Clicked
Checking for calender Page: -----> September 2024
Current Calender Page(Check-In):March 2024   April 2024
Check-In-Next button of calender page  cliked
Current Calender Page(Check-In):April 2024   May 2024
Check-In-Next button of calender page  cliked
Current Calender Page(Check-In):May 2024   June 2024
Check-In-Next button of calender page  cliked
Current Calender Page(Check-In):June 2024   July 2024
Check-In-Next button of calender page  cliked
Current Calender Page(Check-In):July 2024   August 2024
Check-In-Next button of calender page  cliked
Current Calender Page(Check-In):August 2024   September 2024
Calender Page Founded..... 
Check in month number 09
Check-In Value is  Enterd
 [Value is: 11-09-2024
==================================================================================================================
For Check In Date,calender is navigated and date is selected
 selected date value :11-Sep-2024
Checking for calender Page: -----> September 2024
Current Calender Page(Check-Out):August 2024   September 2024
Calender Page Founded..... 
Check out month number 09
Check-In Value is  Enterd
 [Value is: 19-09-2024
========================================================
==================================================================================================================
For Check Out Date,calender is navigated and date is selected
 selected date value :19-Sep-2024
==================================================================================================================
Geuests And Room is selected(clicked)
Adults-Count-Increase Displayed
==================================================================================================================
Adults value is :1.0
==================================================================================================================
Room Count value is :1.0
C:\Users\2327272\eclipse-workspace\HV\src\test\resources\Screenshot\value_Entry.png_18-33-2024 3-33-18.png
==================================================================================================================
Guests and rooms Section Apply Button is Clicked.
==================================================================================================================
From Sort By select box Rating Only is selected
 selected option :Rating only
============================================================================================
************************ printing Hotel Price*****************************
============================================================================================
============================================================================================
************************printing All TheHotel Ratings *****************************
Taj The Trees, Mumbai-----9.6
FabHotel Landmark Guestline-----9.8
FabExpress Embassy Grand Ghatkopar-----9.8
The Oberoi Mumbai-----9.7
Nap Manor-----9.7
Hammock Hostels - Bandra-----9.9
Taj Mahal Tower, Mumbai-----9.6
Hotel Nirvana Grace-----9.6
FabExpress Adore Inn Andheri East-----9.6
Treebo Trend Olive Inn-----9.6
Nexstage Terraces-----9.8
FabExpress Bliss Executive Andheri East-----9.6
Hotel Hometown-----9.6
Treebo Tryst Metropolis Mumbai-----9.5
Treebo Trend Blue Moon-----9.5
The Taj Mahal Palace, Mumbai-----9.5
Golden Tulipz Andheri East-----9.5
Treebo Tryst Laxvas-----9.5
Treebo Tryst Royal Garden Juhu Tara-----9.4
Empire Suites Andheri East-----9.4
Treebo Trend Amber International-----9.4
Capital O 30550 Riva International-----9.4
Avirahi Hotel-----9.4
BKC-----9.4
Hotel Mantra-----9.3
Metro Residency-----9.3
Trident Nariman Point-----9.2
Taj Lands End, Mumbai-----9.2
Trident Bandra Kurla-----9.2
Taj Santacruz, Mumbai-----9.2
JW Marriott Mumbai Sahar-----9.2
Aurika Mumbai Skycity-----9.3
The Westin Mumbai Garden City-----9.2
The St. Regis Mumbai-----9.2
Aralia International Airport Mumbai-----9.2
Test Failed
Rating Validation:Test Failed:
============================================================================================
C:\Users\2327272\eclipse-workspace\HV\src\test\resources\Screenshot\hotelDetails.png_18-33-2024 3-33-27.png
ScreenShot Of HotelDetails Page is Taken
=============================================================================================
Checking if the first 5 hotels belongs to the specific city searched for. Ex: Mumbai
Mumbai
Mumbai
Mumbai
Mumbai
Mumbai
Test Passed
City Name Validation Passed:
=============================================================================================
