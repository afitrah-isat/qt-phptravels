package phptravels.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ABasePage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath = "//button[@class='btn btn-action btn-lg btn-block loginbtn']")
	private WebElement loginBtn;
	
	public LoginPage() {
		initObjects(this);
	}
	
	public void inputLogin(String email, String password) {
		
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		
		loginBtn.click();
	}
	
}
