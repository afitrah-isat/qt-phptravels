package phptravels.pageObjects;

public class TestClass {

	public static void main(String[] args) {
		HomePage hp = new HomePage();
		SearchPage sp = new SearchPage();
		hp.setUrl();
		
		hp.clickMenuTab("Tours");
		hp.inputLocation("Oman", "Tours");
		hp.tourDate();
		hp.selectDate("22-September 2019");
		hp.inputGuest("3 Guests");
		hp.selectTourType("Adventure");
		hp.search("Tours");
		sp.verifySearch("Tours");
	}

}
