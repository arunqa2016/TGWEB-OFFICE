package com.tgweb.stepDefinition;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.baseTest.BaseTest;
import com.tgweb.pages.LoginPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Test
public class LoginSteps extends BaseTest {
	
//	public LoginSteps() {
//		super();
//	}
	
	LoginPages login = new LoginPages();
	String actualTitle;
	
	@Given("^User navigate to the login page$")
	public void User_navigate_to_the_login_page() throws Throwable {
		
		BaseTest.initialize();
		//login = new LoginPages();
		System.out.println("User is on Login Page");
	}

	@When("^User submit username and click Kirim$")
	public void User_submit_username_and_click_Kirim() throws Throwable {
		System.out.println("User enters valid creds");
	  
		logger = extent.startTest("To verify Login Test Scenario", "Below given steps to enter login as player.");
		logger.log(LogStatus.INFO, "Steps to login as player");
		
		login = PageFactory.initElements(driver, LoginPages.class);
		
		login.enterUsername();
		login.click1LoginButton();
		
	}

	@When("^User submit password and click Kirim$")
	public void User_submit_password_and_click_Kirim() throws Throwable {
		login.enterPassword();
		login.click2LoginButton(); 
	}
	
	@Then("^User access agreement page$")
	public void User_access_agreement_page() throws Throwable {
		login.clickOnAgreement();
	}

	@Then("^User should be logged in$")
	public void User_should_be_logged_in() throws Throwable {
	   
	}

	@Then("^User redirect on Dashboard page$")
	public void User_redirect_on_Dashboard_page() throws Throwable {
		login.getUserInfo();
	}
}
