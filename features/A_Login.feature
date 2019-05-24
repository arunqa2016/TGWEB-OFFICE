Feature: Login test feature

@SmokeTest
Scenario: User is Logged In
	Given User navigate to the login page
	When User submit username and click Kirim
	When User submit password and click Kirim
	Then User access agreement page
	Then User should be logged in
	Then User redirect on Dashboard page