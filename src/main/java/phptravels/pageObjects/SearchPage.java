package phptravels.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPage extends BasePage {
	
	public SearchPage() {
		initObjects();
		PageFactory.initElements(driver, this);
	}
	
	public void verifySearch(String type) {
		try {
			switch(type) {
			case "Hotels":
				Assert.assertEquals(driver.getTitle(), "Search Results");
				break;
			case "Flights":
				Assert.assertEquals(driver.getTitle(), "Flights List");
				break;
			
			default:
				Assert.assertEquals(driver.getTitle(), "Search Results");
			}
			
		}
		catch (Exception e) {
			logger.error(e.getStackTrace());
			Assert.fail();
		}
		
	}

}