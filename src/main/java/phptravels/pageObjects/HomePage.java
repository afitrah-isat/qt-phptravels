package phptravels.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import phptravels.dataset.GlobalDataset;

public class HomePage extends BasePage {
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")
	private WebElement myAccountMenu;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]")
	private WebElement signUpLink;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")
	private WebElement loginLink;
	
	@FindBy(xpath = "//span[contains(text(),'Hotels')]")
	private WebElement hotelsBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Flights')]")
	private WebElement flightsBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Search by Hotel or City Name')]")
	private WebElement locationHotelBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Enter City Or Airport')]")
	private WebElement locationFlightBtn;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input[@class='select2-input select2-focused']")
	private WebElement locationTxt;
	
	@FindBy(xpath = "//input[@name='checkin']")
	private WebElement checkInTxt;
	
	@FindBy(xpath = "//input[@name='checkout']")
	private WebElement checkOutTxt;
	
	@FindBy(xpath = "//input[@id='travellersInput']")
	private WebElement travellerTxt;
	
	@FindBy(xpath = "//button[@id='adultMinusBtn']")
	private WebElement adultMinusBtn;
	
	@FindBy(xpath = "//input[@id='adultInput']")
	private WebElement adultTxt;
	
	@FindBy(xpath = "//button[@id='adultPlusBtn']")
	private WebElement adultPlusBtn;
	
	@FindBy(xpath = "//button[@id='childMinusBtn']")
	private WebElement childMinusBtn;
	
	@FindBy(xpath = "//input[@id='childInput']")
	private WebElement childTxt;
	
	@FindBy(xpath = "//button[@id='childPlusBtn']")
	private WebElement childPlusBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
	private WebElement searchHotelBtn;
	
	@FindBy(xpath = "//input[@name='totalManualPassenger']")
	private WebElement passengerBtn;
	
	@FindBy(xpath = "//select[@name='madult']")
	private WebElement passAdultTxt;
	
	@FindBy(xpath = "//select[@name='mchildren']")
	private WebElement passChildTxt;

	@FindBy(xpath = "//select[@name='minfant']")
	private WebElement passInfantTxt;
	
	@FindBy(xpath = "//button[@id='sumManualPassenger']")
	private WebElement passSumBtn;
	
	@FindBy(xpath = "//label[contains(text(),'One Way')]")
	private WebElement oneWayBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Round Trip')]")
	private WebElement roundTripBtn;
	
	@FindBy(xpath = "//select[@name='cabinclass']")
	private WebElement cabinTxt;
	
	@FindBy(xpath = "//input[@name='departure']")
	private WebElement departTxt;
	
	@FindBy(xpath = "//input[@name='arrival']")
	private WebElement arrivalTxt;
	
	@FindBy(xpath = "//button[@class='btn-primary btn btn-lg btn-block pfb0']")
	private WebElement searchFlightBtn;

	
	public HomePage() {
		initObjects();
		PageFactory.initElements(driver, this);
	}
	
	public void setUrl() {
    	driver.get(GlobalDataset.testDataProperty.getValue("url"));
    }
	
	public void signUp() {
		myAccountMenu.click();
		signUpLink.click();
	}
	
	public void login() {
		myAccountMenu.click();
		loginLink.click();
	}
	
	public void checkInDate() {
		checkInTxt.click();
	}
	
	public void checkOutDate() {
		checkOutTxt.click();
	}
	
	public void selectDate(String date) {
		
		String[] dateArr = date.split("-");
		WebElement monYear = null;
		WebElement next = null;
		
		List<WebElement> monYearList = driver.findElements(By.xpath("//th[@class='switch']"));
		for(WebElement my: monYearList) {
			if(my.isDisplayed()) {
				monYear = my;
				break;
			}	
		}
		
		List<WebElement> nextList = driver.findElements(By.xpath("//th[@class='next']"));
		for(WebElement nx: nextList) {
			if(nx.isDisplayed()) {
				next = nx;
				break;
			}	
		}
		
		while(!dateArr[1].equals(monYear.getText())) {
			next.click();
		}
		
		List<WebElement> dayList = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day ']"));
		
		for(WebElement cell: dayList) {
			if(cell.getText().equals(dateArr[0])) {
				cell.click();
				break;
			}
		}
		
	}
	
	public void inputTraveller(int adult, int child) {
		
		travellerTxt.click();
		
		int adultNo = Integer.valueOf(adultTxt.getAttribute("value"));
		int childNo = Integer.valueOf(childTxt.getAttribute("value"));
		
		while(adultNo != adult) {
			if(adultNo > adult) {
				adultMinusBtn.click();
				adultNo--;
			} 
			else {
				adultPlusBtn.click();
				adultNo++;
			}
		}
		
		while(childNo != child) {
			if(childNo > child) {
				childMinusBtn.click();
				childNo--;
			} 
			else {
				childPlusBtn.click();
				childNo++;
			}
		}
	}
	
	public void search(String type) {
		
		switch(type) {
		case "Hotels":
			searchHotelBtn.click();
			break;
		case "Flights":
			wait.until(ExpectedConditions.elementToBeClickable(searchFlightBtn));
			searchFlightBtn.click();
			break;
		
		default:
			locationHotelBtn.click();
		}
	}
	
	public void inputLocation(String location, String type) {

		switch(type) {
		case "Hotels":
			locationHotelBtn.click();
			break;
		case "Flights":
			locationFlightBtn.click();
			break;
		
		default:
			locationHotelBtn.click();
		}
		
		
		locationTxt.sendKeys(location);
		
		WebElement locationChosen = driver.findElement(By.xpath("//span[contains(text(),'"+ location +"')]"));
		locationChosen.click();
	}
	
	public void clickHotels() {
		
		hotelsBtn.click();
	}

	public void clickFlights() {
		
		flightsBtn.click();
	}
	
	public void clickPassenger() {
		
		passengerBtn.click();
	}
	
	public void inputPassenger(String adult, String child, String infant) {
		
		Select adultDdl = new Select(passAdultTxt);
		adultDdl.selectByVisibleText(adult);
		
		Select childDdl = new Select(passChildTxt);
		childDdl.selectByVisibleText(child);
		
		Select infantDdl = new Select(passInfantTxt);
		infantDdl.selectByVisibleText(infant);
		
		passSumBtn.click();
	}
	
	public void inputTripCabin(String trip, String cabin) {
		
		if(trip.equals("One Way")) {
			oneWayBtn.click();
		} 
		else if(trip.equals("Round Trip")) {
			roundTripBtn.click();
		}
		
		Select cabinDdl = new Select(cabinTxt);
		cabinDdl.selectByVisibleText(cabin);
		
	}
	
	public void departDate() {
		departTxt.click();
	}
	
	public void arrivalDate() {
		arrivalTxt.click();
	}
}
