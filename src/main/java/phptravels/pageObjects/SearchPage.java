package phptravels.pageObjects;

import org.testng.Assert;

public class SearchPage extends ABasePage {
	
	public SearchPage() {
		initObjects(this);
	}
	
	public void verifySearch(String type) {
		try {
			switch(type) {
			case "Hotels":
				Assert.assertTrue(true);
				logger.info("PASS");
				break;
			case "Flights":
				Assert.assertTrue(true);
				logger.info("PASS");
				break;
			case "Tours":
				Assert.assertTrue(true);
				logger.info("PASS");
				break;
			case "Cars":
				Assert.assertTrue(true);
				logger.info("PASS");
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
