package testrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				tags = "@SmokeTest",
				features = "src/test/resources/Features", 
				glue =  "com.hackathon.stepdefinitions" , 
				plugin = {"pretty", "html:target/cucumber-html-report.html"},									
				monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
