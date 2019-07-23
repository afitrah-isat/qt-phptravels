package phptravels.dataset;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.apache.logging.log4j.Logger;

import phptravels.dataset.GlobalDataset;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);
	
	public static final WebDriver driver = DriverFactory.getWebDriver();
    
	private DriverFactory() {
    }   
    
    public static WebDriver getWebDriver() {
    	
    	return getChrome();
    }

    public static void removeWebDriver() {
    	driver.quit();
    }
    
    private static WebDriver getChrome() {

		logger.info("Starting Chrome browser");
		
    	int timeoutInSeconds = Integer.valueOf(GlobalDataset.testDataProperty.getValue("timeout"));
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--touch-events=disabled");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-default-apps");
        options.setExperimentalOption("useAutomationExtension", false);
        
		
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(timeoutInSeconds * 1000),
                TimeUnit.MILLISECONDS);
        return driver;
    }

}
