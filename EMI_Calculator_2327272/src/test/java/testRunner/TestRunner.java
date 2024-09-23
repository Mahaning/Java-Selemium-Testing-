package testRunner;

//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;

//import factory.BaseClass;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import stepDefinitions.Hooks;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features/"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
//							  "rerun:target/failedrerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							dryRun=false,    // checks mapping between scenario steps and step definition methods
							monochrome=true,    // to avoid junk characters in output
							publish=true   // to publish report in cucumber server
//,									tags="@functional"
									//tags="@regression"
									//tags="@smoke"
			
		)
public class TestRunner extends AbstractTestNGCucumberTests{
//	@DataProvider(parallel = false)
//
//	public Object[][] scenarios() {
//
//		return super.scenarios();
//
//	}
//
//	@BeforeTest
//
//	@Parameters({ "browser" })
//
//	public void defineBrowser(String browser) throws Throwable {
//		Hooks hooks=new Hooks();
//		hooks.setup(browser);
//
//	}
}
