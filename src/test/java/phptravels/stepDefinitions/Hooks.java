package phptravels.stepDefinitions;

import cucumber.api.java.After;
import phptravels.dataset.DriverFactory;

public class Hooks {

	@After("@Finish")
    public void afterScenario(){
        DriverFactory.removeWebDriver();
    }
}
