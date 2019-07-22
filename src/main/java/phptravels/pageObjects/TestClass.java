package phptravels.pageObjects;

public class TestClass {

	public static void main(String[] args) {
		HomePage hp = new HomePage();
		SearchPage sp = new SearchPage();
		hp.setUrl();
		
		hp.clickFlights();
		String trip = "Round Trip";
        hp.inputLocation("London", "Flights");
        hp.inputLocation("Changi", "Flights");
        hp.inputTripCabin(trip, "Business");
        hp.departDate();
        hp.selectDate("13-August 2019");
        if(trip.equals("Round Trip")) 
        		hp.selectDate("15-August 2019");
        hp.clickPassenger();
        hp.inputPassenger("2", "0", "3");
		hp.search("Flights");
		
	}

}
