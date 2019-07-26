package phptravels.stepDefinitions;


import io.cucumber.java.After;
import phptravels.dataset.DriverFactory;

public class Hooks {

	@After("@Finish")
    public void afterScenario(){
        DriverFactory.removeWebDriver();
    }
}
