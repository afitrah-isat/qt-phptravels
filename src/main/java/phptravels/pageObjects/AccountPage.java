package phptravels.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage extends BasePage {
	
	@FindBy(xpath = "//h3[@class='RTL']")
	private WebElement welcomeTxt;
	
	@FindBy(xpath = "//li[@class='open']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Logout')]")
	private WebElement logoutLink;
	
	public AccountPage() {
		initObjects();
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAccount(String expected) {
		try {
			Assert.assertEquals(welcomeTxt.getText(), expected);
		}
		catch(Exception e) {
			logger.error(e.getStackTrace());
			Assert.fail();
		}	
	}
	
	public void logout(String firstname) {
		WebElement accountMenu = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'"+ firstname +"')]"));
		accountMenu.click();
		logoutLink.click();
	}
}
