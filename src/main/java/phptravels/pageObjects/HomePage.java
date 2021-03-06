package phptravels.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import phptravels.dataset.GlobalDataset;

public class HomePage extends ABasePage {

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

	@FindBy(xpath = "//span[contains(text(),'Tours')]")
	private WebElement toursBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Cars')]")
	private WebElement carsBtn;

	@FindBy(xpath = "//span[contains(text(),'Search by Hotel or City Name')]")
	private WebElement locationHotelBtn;

	@FindBy(xpath = "//span[contains(text(),'Enter Location')]")
	private WebElement locationFlightBtn;

	@FindBy(xpath = "//span[contains(text(),'Search by Listing or City Name')]")
	private WebElement locationTourBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Pick up')]")
	private WebElement locationPickupBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Drop off')]")
	private WebElement locationDropoffBtn;

	@FindBy(xpath = "//div[@id='select2-drop']//input[@class='select2-input select2-focused']")
	private WebElement locationTxt;

	@FindBy(xpath = "//input[@name='checkin']")
	private WebElement checkInTxt;

	@FindBy(xpath = "//input[@name='checkout']")
	private WebElement checkOutTxt;

	@FindBy(xpath = "//input[@id='htravellersInput']")
	private WebElement travellerTxt;

	@FindBy(xpath = "//button[@id='hadultMinusBtn']")
	private WebElement adultMinusBtn;

	@FindBy(xpath = "//input[@id='hadultInput']")
	private WebElement adultTxt;

	@FindBy(xpath = "//button[@id='hadultPlusBtn']")
	private WebElement adultPlusBtn;

	@FindBy(xpath = "//button[@id='hchildMinusBtn']")
	private WebElement childMinusBtn;

	@FindBy(xpath = "//input[@id='hchildInput']")
	private WebElement childTxt;

	@FindBy(xpath = "//button[@id='hchildPlusBtn']")
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

	@FindBy(xpath = "//input[@name='date']")
	private WebElement tourDateTxt;

	@FindBy(xpath = "//select[@id='adults']")
	private WebElement guestTxt;

	@FindBy(xpath = "//select[@id='tourtype']")
	private WebElement tourTypeTxt;
	
	@FindBy(xpath = "//button[@class='btn-primary btn btn-lg btn-block pfb0 loader']")
	private WebElement searchTourBtn;
	
	@FindBy(xpath = "//input[@id='departcar']")
	private WebElement departCarTxt;
	
	@FindBy(xpath = "//select[@name='pickupTime']")
	private WebElement pickupTimeTxt;
	
	@FindBy(xpath = "//input[@id='returncar']")
	private WebElement returnCarTxt;
	
	@FindBy(xpath = "//select[@name='dropoffTime']")
	private WebElement dropoffTimeTxt;
	
	@FindBy(xpath = "//div[@class='bgfade col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]")
	private WebElement searchCarBtn;
	
	private static String carLocation = "";

	public HomePage() {
		initObjects(this);
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
		for (WebElement my : monYearList) {
			if (my.isDisplayed()) {
				monYear = my;
				break;
			}
		}

		List<WebElement> nextList = driver.findElements(By.xpath("//th[@class='next']"));
		for (WebElement nx : nextList) {
			if (nx.isDisplayed()) {
				next = nx;
				break;
			}
		}

		while (!dateArr[1].equals(monYear.getText())) {
			next.click();
		}

		List<WebElement> dayList = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day ']"));

		for (WebElement cell : dayList) {
			if (cell.getText().equals(dateArr[0])) {
				cell.click();
				break;
			}
		}

	}

	public void inputTraveller(int adult, int child) {

		travellerTxt.click();

		int adultNo = Integer.valueOf(adultTxt.getAttribute("value"));
		int childNo = Integer.valueOf(childTxt.getAttribute("value"));

		while (adultNo != adult) {
			if (adultNo > adult) {
				adultMinusBtn.click();
				adultNo--;
			} else {
				adultPlusBtn.click();
				adultNo++;
			}
		}

		while (childNo != child) {
			if (childNo > child) {
				childMinusBtn.click();
				childNo--;
			} else {
				childPlusBtn.click();
				childNo++;
			}
		}
	}

	public void search(String type) {

		switch (type) {
		case "Hotels":
			searchHotelBtn.click();
			break;
		case "Flights":
			wait.until(ExpectedConditions.elementToBeClickable(searchFlightBtn));
			searchFlightBtn.click();
			break;
		case "Tours":
			searchTourBtn.click();
			break;
		case "Cars":
			wait.until(ExpectedConditions.elementToBeClickable(searchCarBtn));
			searchCarBtn.click();
			break;
			
		default:
			locationHotelBtn.click();
		}
	}

	public void inputLocation(String location, String type) {

		switch (type) {
		case "Hotels":
			locationHotelBtn.click();
			break;
		case "Flights":
			locationFlightBtn.click();
			break;
		case "Tours":
			locationTourBtn.click();
			break;

		default:
			locationHotelBtn.click();
		}

		locationTxt.sendKeys(location);

		WebElement locationChosen = driver.findElement(By.xpath("//span[contains(text(),'" + location + "')]"));
		locationChosen.click();
	}
	
	public void inputCarLocation(String location, String type) {
		if(type.equals("Pickup")) {
			locationPickupBtn.click();
			carLocation = location;
		} else {
			int loop = 0;
			List<WebElement> locationDropoffTxt = driver.findElements(By.xpath("//span[contains(text(),'"+ carLocation +"')]"));
			while((locationDropoffTxt.size() < 2) && (loop < 1000)) {
				locationDropoffTxt = driver.findElements(By.xpath("//span[contains(text(),'"+ carLocation +"')]"));
				loop++;
			}
			if(locationDropoffTxt.size() == 2)
				locationDropoffTxt.get(1).click();
		}
		
		locationTxt.sendKeys(location);

		WebElement locationChosen = driver.findElement(By.xpath("//span[contains(text(),'" + location + "')]"));
		locationChosen.click();
	}

	public void clickMenuTab(String type) {

		switch (type) {
		case "Hotels":
			hotelsBtn.click();
			break;
		case "Flights":
			flightsBtn.click();
			break;
		case "Tours":
			toursBtn.click();
			break;
		case "Cars":
			carsBtn.click();
			break;

		default:
			hotelsBtn.click();
		}

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

		if (trip.equals("One Way")) {
			oneWayBtn.click();
		} else if (trip.equals("Round Trip")) {
			roundTripBtn.click();
		}

		//Select cabinDdl = new Select(cabinTxt);
		//cabinDdl.selectByVisibleText(cabin);

	}

	public void departDate() {
		departTxt.click();
	}

	public void arrivalDate() {
		arrivalTxt.click();
	}

	public void tourDate() {
		tourDateTxt.click();
	}

	public void inputGuest(String guest) {

		Select guestDdl = new Select(guestTxt);
		guestDdl.selectByVisibleText(guest);
	}

	public void selectTourType(String tourType) {
		
		Select tourTypeDdl = new Select(tourTypeTxt);
		tourTypeDdl.selectByVisibleText(tourType);
	}
	
	public void departCarDate() {
		departCarTxt.click();
	}
	
	public void pickupTime(String time) {
		Select pickupTimeDdl = new Select(pickupTimeTxt);
		pickupTimeDdl.selectByVisibleText(time);
	}
	
	public void returnCarDate() {
		returnCarTxt.click();
	}
	
	public void dropoffTime(String time) {
		Select dropoffTimeDdl = new Select(dropoffTimeTxt);
		dropoffTimeDdl.selectByVisibleText(time);
	}
}
