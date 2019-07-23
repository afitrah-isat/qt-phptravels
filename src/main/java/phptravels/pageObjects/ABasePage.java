package phptravels.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import phptravels.dataset.DriverFactory;
import phptravels.dataset.GlobalDataset;

public abstract class ABasePage {

	protected WebDriver driver;
	protected WebDriverWait wait ;
	
	protected static final Logger logger = LogManager.getLogger(ABasePage.class);
			
    protected WebDriver getDriver() {
        return DriverFactory.driver;
    }
	
    protected void initObjects(Object childPage) {
    	this.driver = getDriver();
    	PageFactory.initElements(driver, childPage);
    	this.wait = new WebDriverWait(this.driver, Integer.valueOf(GlobalDataset.testDataProperty.getValue("timeout")));
	}
    
}
