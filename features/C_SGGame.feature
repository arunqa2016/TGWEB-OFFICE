Feature: SG Game functionality Feature

@SmokeTest
Scenario: SG 4D,3d,2D Game functionality

Given User is on Singapore Pools game
And User enters bet number and amount
And User calculate the bet amount
Then User click on Kirim button
Then User redirect on transaction page
Then User check current amount

@SmokeTest
Scenario: SG Bolak-Balik Game functionality

Given User is on Bolak_Balik game
And Enter numbers for Bet
Then Enter amount
Then Click on Kirim button
Then Check current amount

@SmokeTest
Scenario: SG 2D Depan Tengah Game functionality

Given User is on Depan Tengah game
And Enter numbers for Bet in Depan and Tengah
Then Enter amount Depan Tengah
Then Click on Kirim button Depan Tengah
Then Check current amount after bet on Depan Tengah