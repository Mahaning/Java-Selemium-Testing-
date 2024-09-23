package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions( features = {"@target/rerun:target/rerun.txt"}, 
					glue = {"com.example.definitions"},
					plugin = {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "rerun:target/failedrerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   
)
    
public class FailedRunnerTests extends AbstractTestNGCucumberTests {
    
}