package phptravels.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
		features = "src/test/resources/features",
		glue="phptravels.stepDefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {

}
