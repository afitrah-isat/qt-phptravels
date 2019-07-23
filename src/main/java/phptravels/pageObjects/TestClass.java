package phptravels.pageObjects;

public class TestClass {

	public static void main(String[] args) {
		HomePage hp = new HomePage();
		SearchPage sp = new SearchPage();
		hp.setUrl();
		
		hp.clickMenuTab("Cars");
		hp.inputCarLocation("Manchester", "Pickup");
		hp.departCarDate();
		hp.selectDate("13-August 2019");
		hp.selectDate("15-August 2019");
		hp.pickupTime("01:30");
		hp.dropoffTime("22:00");
		hp.search("Cars");
	}

}
