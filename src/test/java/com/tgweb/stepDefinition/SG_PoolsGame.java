package com.tgweb.stepDefinition;

import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.baseTest.BaseTest;
import com.tgweb.pages.SGPools_GamePages;
import com.tgweb.utilityFile.ScreenShotCaptured;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SG_PoolsGame extends BaseTest {
	
	SGPools_GamePages sgGame;

	@Given("^User is on Singapore Pools game$")
	public void User_is_on_Singapore_Pools_game() throws Throwable {
	   System.out.println("User is on Singapore Pools game");
	   String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "screenShotName");
	   logger = extent.startTest("To verify 4D/3D/2D game Functionality","On SG Game page");
	   logger.log(LogStatus.INFO, "User is on SG Game" + logger.addScreenCapture(screenShotPath));
	   SGPools_GamePages.captureCurrentScreenShot();
	   SGPools_GamePages.getSGGamePeriode();
	   //SGPools_GamePages.userCurrrentBalance();
	}

	@And("^User enters bet number and amount$")
	public void User_enters_bet_number_and_amount() throws Throwable {
		System.out.println("User is on Singapore 4D/3D/2Dgame");
		sgGame = new SGPools_GamePages();
		sgGame.enterBetNumberAndAmount();
	}

	@And("^User calculate the bet amount$")
	public void User_calculate_the_bet_amount() throws Throwable {
	    System.out.println("User calculate the bet amount");
	    SGPools_GamePages.bayarAmtCaclulation();
	}

	@Then("^User click on Kirim button$")
	public void User_click_on_Kirim_button() throws Throwable {
	  System.out.println("User click on Kirim button");
	  SGPools_GamePages.clickKirimButton();
	}

	@Then("^User redirect on transaction page$")
	public void User_redirect_on_transaction_page() throws Throwable {
	    
	}

	@Then("^User check current amount$")
	public void User_check_current_amount() throws Throwable {
	 System.out.println("User check current amount");
	 
	}
	
	@Given("^User is on Bolak_Balik game$")
	public void user_is_on_Bolak_Balik_game() throws Throwable {
		//SGPools_GamePages.onBolakBalik();
		logger = extent.startTest("To verify Bolak-Balik Game Functionality","On SG Game page");
	}

	@Given("^Enter numbers for Bet$")
	public void enter_numbers_for_Bet() throws Throwable {
		SGPools_GamePages.enterNumbers_BolakBalik();
	}

	@Then("^Enter amount$")
	public void enter_amount() throws Throwable {
		SGPools_GamePages.enterBetAmount_BolakBalik();
		SGPools_GamePages.getBayarAmount_BolakBalik();
	}

	@Then("^Click on Kirim button$")
	public void click_on_Kirim_button() throws Throwable {
		SGPools_GamePages.clickKirim_BolkaBalik();
	}

	@Then("^Check current amount$")
	public void check_current_amount() throws Throwable {
		SGPools_GamePages.userCurrrentBalance();
		System.out.println("User after Bolak-Balik bet ");
	}

	@Given("^User is on Depan Tengah game$")
	public void user_is_on_Depan_Tengah_game() throws Throwable {
		 logger = extent.startTest("To verify 2D Depan Tengah game Functionality","On SG Game page");
		SGPools_GamePages.userOnDepanTengah();
	}

	@Given("^Enter numbers for Bet in Depan and Tengah$")
	public void enter_numbers_for_Bet_in_Depan_and_Tengah() throws Throwable {
		SGPools_GamePages.enterNum_DepanTengah();
	}

	@Then("^Enter amount Depan Tengah$")
	public void enter_amount_Depan_Tengah() throws Throwable {
		SGPools_GamePages.enterAmt_DepanTengah();
		SGPools_GamePages.calculateBayarAmt_DepanTengah();
		SGPools_GamePages.calculateTotalBayar_DepanTengah();
	}

	@Then("^Click on Kirim button Depan Tengah$")
	public void click_on_Kirim_button_Depan_Tengah() throws Throwable {
		SGPools_GamePages.clickKirim_DepanTengah();
		SGPools_GamePages.clickBatalBtn_DepanTengah();
	}

	@Then("^Check current amount after bet on Depan Tengah$")
	public void check_current_amount_after_bet_on_Depan_Tengah() throws Throwable {
		System.out.println("User after 2D Depan Tengah bet ");
		BaseTest.tearDown();
	}
	
}
