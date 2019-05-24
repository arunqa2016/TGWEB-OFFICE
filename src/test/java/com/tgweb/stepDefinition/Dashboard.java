package com.tgweb.stepDefinition;

import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.baseTest.BaseTest;
import com.tgweb.pages.DashboardPage;
import com.tgweb.utilityFile.ScreenShotCaptured;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard extends BaseTest {
	
	@Given("^User is on Dashboard page$")
    public void user_is_on_dashboard_page() throws Throwable {
      System.out.println("---------- Dashboard - User is on Dashboard page");
      String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "Dashboard_ScreenShot");
      logger = extent.startTest("To verify Dashboard Page","User Info on Dashboard page");
	  logger.log(LogStatus.INFO, "User is on Dashboard" + logger.addScreenCapture(screenShotPath));
    }

    @When("^Get Title of Dashboard page$")
    public void get_title_of_dashboard_page() throws Throwable {
    	System.out.println("---------- Dashboard - Get the title of Dashboard page");
    	DashboardPage.onDashboardInfo();
    //	DashboardPage.userCurrrentBalance();
    //	DashboardPage.userInfo();
    }
    
    @And("^User clicks on Pools game$")
    public void user_clicks_on_pools_game() throws Throwable {
    	System.out.println("---------- Dashboard - User clicks on Pools game");
    	DashboardPage.clickOnTogelViewGames();
    }

    @Then("^User get the title of Pools game page$")
    public void user_get_the_title_of_pools_game_page() throws Throwable {
    	System.out.println("---------- Dashboard - User get the title of Pools game page");
    }

    @Then("^User clicks on SG Pools game link$")
    public void user_clicks_on_sg_pools_game_link() throws Throwable {
    	System.out.println("---------- Dashboard - User clicks on SG Pools game link");
    	DashboardPage.clickOnSGPoolsGame();
    	DashboardPage.getSGGameTitle();
    	DashboardPage.getSGGameCurrentURL();
    	
    }


}
