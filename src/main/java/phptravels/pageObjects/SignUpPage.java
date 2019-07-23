package phptravels.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends ABasePage {
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstnameTxt;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnameTxt;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneTxt;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@name='confirmpassword']")
	private WebElement confirmPasswordTxt;
	
	@FindBy(xpath = "//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")
	private WebElement signUpBtn;
	
	public SignUpPage() {
		initObjects(this);
	}
	
	public void fillSignUp(String firstname, String lastname, String mobileNo, String email, String password, String confirmPassword) {
		
		firstnameTxt.sendKeys(firstname);
		lastnameTxt.sendKeys(lastname);
		phoneTxt.sendKeys(mobileNo);
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		confirmPasswordTxt.sendKeys(confirmPassword);
	}
	
	public void clickSignUpBtn() {
		
		signUpBtn.click();
	}

}
