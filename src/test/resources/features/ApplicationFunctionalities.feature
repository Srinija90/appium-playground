@ApplicationFunctionalities

Feature: Testing the Preferences Features
	As a user of the application
	I want to be able to add new Wifi settings, and switch preferences of my profile
	In order to use the Preferences

    
	Scenario: User is able to add new Wifi setting in the preferences screen of the application 
		Given a valid user
		When user navigates to the preferences screen
		And user navigates to the preferences-dependencies screen
		And user clicks the Wifi checkbox
		And user enters the text in Wifi settings text box
		And user click on ok button
		Then a new Wifi setting is added
		
		
	@Ignore	
	Scenario: User is able to turn ON the switch preference in the In-line preferences screen of the application
		Given a valid user
		When user navigates to the preferences screen
        And user navigates to the In-line preferences screen
        And user turn ON the first switch preference
        Then switch preference should get turn ON
		
