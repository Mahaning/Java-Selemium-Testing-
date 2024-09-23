###Problem Statement: Find the Interest Amount for current year
 
1. Buying a  car of 15 Lac<br>
2. Interest rate of 9.5% <br>
3. Tenure should be 1 year.<br>
Display the interest amount & principal amount of first month.<br>
(Suggested Site: emicalculator.net  / HDFCbank.com etc. however you are free to use any other legitimate site)<br>
 
###Detailed Description: 
 
1. Find the EMI for Car with price of 15 Lac, Interest rate of 9.5% & Tenure 1 year; Display the interest amount & principal amount for one month<br>
2. From Menu, pick Home Loan EMI Calculator, fill relevant details & extract all the data from  year on year table & store in excel;<br>
3. From Menu, pick Loan Calculator and under EMI calculator, do all UI check for text box & scales; change the Loan tenure for year & month,check the <br>
   change in scale; Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator<br>
(Suggested Site: emicalculator.net  however you are free to use any other legitimate site)<br>
 
###Automation concepts used:
 
-> Validation of transactions & do calculations;<br>
-> Extract table values & store in excel<br>
-> Filling data in screen & multiple UI validations<br>
-> Navigation from Menus<br>
-> Reusable methods<br>
-> Extract multiple options items & store in collections.<br>
-> logs and screenshot in Extent report<br>
-> Data Driven approach.<br>
-> Cross Browser Testing.<br>
-> Cucumber framework.<br>
-> TestNG framework.<br>
-> Page object model with PageFactory.<br>
-> Run on Grid<br>


----------------------------------------------------------------------------------------------------------------------------------------------------
 
Output: [Chrome and Edge]
==================
 
Home Page Loaded<br>
Opened emicalculator.net application<br>
Navigated to Car Loan EMI Calculator<br>
Entered all the required inputs from properties file<br>
Displayed Interest and Principle on the console<br>
Navigated to Home Loan EMI Calculator<br>
Entered all the required inputs from properties file<br>
Extracted year on year table to EXCEL<br>
Validated all the UI Checks for EMI Calculator, Loan Amount Calculator and Loan Tenure Calculator<br>
Closed the webpage<br>
<br>
-Note:For Detail Output please refer :\reports\myreport.html
----------------------------------------------------------------------------------------------------------------------------------------------------

###Tools with its version 

-maven : 4.0.0 <br>
-selenium : 4.17.0 <br>
-testng : 7.9.0 <br>
-apache.poi: 5.2.5<br>
-Cucumber:7.14.1 <br>

###Dependencies and Plugins:
 
`<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>EMI_Calculator_2327272</groupId>
	<artifactId>EMI_Calculator_2327272</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
	<name>EMI_Calculator_2327272</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<build>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.11.0</version>
					<configuration>
						<source>17</source>
						<target>17</target>
					</configuration>
				</plugin>

				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-surefire-plugin</artifactId>
					<version>3.1.2</version>
					<configuration>
						<suiteXmlFiles>
							<suiteXmlFile>testng.xml</suiteXmlFile>
						</suiteXmlFiles>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
	</build>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.15.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.18.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.9.0</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.2.5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.2.5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>3.0.0-beta2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>3.0.0-beta2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>7.16.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>7.16.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-testng</artifactId>
			<version>7.16.1</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter -->
		<dependency>
			<groupId>tech.grasshopper</groupId>
			<artifactId>extentreports-cucumber7-adapter</artifactId>
			<version>1.14.0</version>
		</dependency>
		
		 <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->

		<!--<dependency>

			<groupId>io.github.bonigarcia</groupId>

			<artifactId>webdrivermanager</artifactId>

			<version>5.3.1</version>

		</dependency>-->
	</dependencies>

</project>`
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
