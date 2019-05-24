Feature: TG web Dashboard page Feature

@SmokeTest
Scenario: TG Web valid Link redirection Test Scenario

Given User is on Dashboard page
When Get Title of Dashboard page
And User clicks on Pools game 
Then User get the title of Pools game page
Then User clicks on SG Pools game link