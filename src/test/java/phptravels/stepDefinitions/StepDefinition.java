package phptravels.stepDefinitions;

import io.cucumber.java.en.*;
import phptravels.dataset.GlobalDataset;
import phptravels.pageObjects.*;


public class StepDefinition {
	
	String firstname = GlobalDataset.testDataProperty.getValue("firstname");
    String lastname = GlobalDataset.testDataProperty.getValue("lastname");
    String mobileNo = GlobalDataset.testDataProperty.getValue("mobile_no");
    String email = GlobalDataset.testDataProperty.getValue("email");
    String password = GlobalDataset.testDataProperty.getValue("password");
    String confirmPassword = GlobalDataset.testDataProperty.getValue("confirm_password");
    String hotelLocation = GlobalDataset.testDataProperty.getValue("hotel_location");
    String departLocation = GlobalDataset.testDataProperty.getValue("depart_location");
    String arrivalLocation = GlobalDataset.testDataProperty.getValue("arrival_location");
    String tourLocation = GlobalDataset.testDataProperty.getValue("tour_location");
    String pickupLocation= GlobalDataset.testDataProperty.getValue("pickup_location");
    String dropoffLocation= GlobalDataset.testDataProperty.getValue("dropoff_location");
    String checkinDate = GlobalDataset.testDataProperty.getValue("checkin_date");
    String checkoutDate = GlobalDataset.testDataProperty.getValue("checkout_date");
    String departDate = GlobalDataset.testDataProperty.getValue("depart_date");
    String returnDate = GlobalDataset.testDataProperty.getValue("return_date");
    String tourDate = GlobalDataset.testDataProperty.getValue("tour_date");
    String pickupDate = GlobalDataset.testDataProperty.getValue("pickup_date");
    String dropoffDate = GlobalDataset.testDataProperty.getValue("dropoff_date");
	
	HomePage hp = new HomePage();
	SignUpPage sup = new SignUpPage();
	AccountPage ap = new AccountPage();
	LoginPage lp = new LoginPage();
	SearchPage sp = new SearchPage();
	
    @Given("^User in Homepage$")
    public void user_in_homepage() throws Throwable {
    	hp.setUrl();
    }

    @When("^User click Sign Up$")
    public void user_click_sign_up() throws Throwable {
    	hp.signUp();
    }

    @Then("^User should be on Account page$")
    public void user_should_be_on_account_page() throws Throwable {
    	
    	String expected = "Hi, " + firstname + " " + lastname;
        ap.verifyAccount(expected);
    }

    @And("^User input data$")
    public void user_input_data() throws Throwable {
        
        sup.fillSignUp(firstname, lastname, mobileNo, email, password, confirmPassword);
    }

    @And("^User click Sign up button$")
    public void user_click_sign_up_button() throws Throwable {
        sup.clickSignUpBtn();
    }
    
    @When("^User click Login$")
    public void user_click_login() throws Throwable {
        hp.login();
    }

    @And("^User input email and password$")
    public void user_input_email_and_password() throws Throwable {
        lp.inputLogin(email, password);
    }

    @And("^User click login button$")
    public void user_click_login_button() throws Throwable {
        lp.clickLoginBtn();
    }
    
    @And("^User click logout button$")
    public void user_click_logout_button() throws Throwable {
        ap.logout(firstname);
    }
    
    @When("^User click \"([^\"]*)\"$")
    public void user_click_something(String strArg1) throws Throwable {
        hp.clickMenuTab(strArg1);
    }

    
    @Then("^Result page for \"([^\"]*)\" is displayed$")
    public void result_page_for_something_is_displayed(String strArg1) throws Throwable {
    	sp.verifySearch(strArg1);
    }

    @And("^User input data search Hotels$")
    public void user_input_data_search_hotels() throws Throwable {
    	hp.inputLocation(hotelLocation, "Hotels");
		hp.checkInDate();
		hp.selectDate(checkinDate);
		hp.selectDate(checkoutDate);
		hp.inputTraveller(2, 3);
    }
    
    @And("^User click Search button for \"([^\"]*)\"$")
    public void user_click_search_button_for_something(String strArg1) throws Throwable {
        hp.search(strArg1);
    }
    

    @And("^User input data search Flights$")
    public void user_input_data_search_flights() throws Throwable {
    	String trip = "Round Trip";
        hp.inputLocation(departLocation, "Flights");
        hp.inputLocation(arrivalLocation, "Flights");
        hp.inputTripCabin(trip, "Business");
        hp.departDate();
        hp.selectDate(departDate);
        if(trip.equals("Round Trip")) 
        		hp.selectDate(returnDate);
        hp.clickPassenger();
        hp.inputPassenger("2", "0", "3");
        
    }
    
    @And("^User input data search Tours$")
    public void user_input_data_search_tours() throws Throwable {
       
    	hp.inputLocation(tourLocation, "Tours");
		hp.tourDate();
		hp.selectDate(tourDate);
		hp.inputGuest("3 Guests");
		hp.selectTourType("Adventure");
    }
    
    @And("^User input data search Cars$")
    public void user_input_data_search_cars() throws Throwable {
    	hp.inputCarLocation(pickupLocation, "Pickup");
		hp.departCarDate();
		hp.selectDate(pickupDate);
		hp.selectDate(dropoffDate);
		hp.pickupTime("01:30");
		hp.dropoffTime("22:00");
    }


}