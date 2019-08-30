Feature: PhpTravels Test

Scenario: Create new customer
	Given User in Homepage
	When User click Sign Up
	And User input data
	And User click Sign up button
	Then User should be on Account page
	And User click logout button
	
Scenario: Search Hotels as Guest User
	Given User in Homepage 
	When User click "Hotels"
	And User input data search Hotels
	And User click Search button for "Hotels"
	Then Result page for "Hotels" is displayed

#Scenario: Book Hotels as Guest User
#	Given Result page for "Hotels" is displayed 
#	When User click Details for "Hotels"
#	And User click Book Now for selected room
#	And User input booking data
#	And User click Complete Booking
#	Then Result page for "Hotels" is displayed

Scenario: Search Flights as Guest User
	Given User in Homepage 
	When User click "Flights"
	And User input data search Flights
	And User click Search button for "Flights"
	Then Result page for "Flights" is displayed
	
Scenario: Search Tours as Guest User
	Given User in Homepage 
	When User click "Tours"
	And User input data search Tours
	And User click Search button for "Tours"
	Then Result page for "Tours" is displayed
	
Scenario: Search Cars as Guest User
	Given User in Homepage 
	When User click "Cars"
	And User input data search Cars
	And User click Search button for "Cars"
	Then Result page for "Cars" is displayed
	
@Finish	
Scenario: Login
	Given User in Homepage
	When User click Login
	And User input email and password
	And User click login button
	Then User should be on Account page
	

	
