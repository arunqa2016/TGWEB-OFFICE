package com.tgweb.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.baseTest.BaseTest;
import com.tgweb.utilityFile.ScreenShotCaptured;
import com.tgweb.utilityFile.Support;

public class LoginPages extends BaseTest {

	@FindBy(how = How.XPATH, using = "//*[@id=\"user\"]")@CacheLookup WebElement username;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_form\"]/div/button")@CacheLookup	WebElement clickUserButton;
	@FindBy(how = How.NAME, using = "password")	@CacheLookup	WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password-form\"]/div[6]/div[2]/button")	@CacheLookup	WebElement clickPassButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"accept_btn\"]")	@CacheLookup	WebElement agree;
	
	public LoginPages() {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername() throws InterruptedException {

		Assert.assertTrue(username.isDisplayed());
		username.sendKeys(prop.getProperty("Username"));
		System.out.println("- In EnterUsername");
		logger.log(LogStatus.PASS, "Step 1 - Enter Username - Success");
	}

	public void click1LoginButton() throws InterruptedException {
		Assert.assertTrue(clickUserButton.isDisplayed());
		clickUserButton.click();
		System.out.println("- In Click Login1");
		Support.waitFor5Seconds();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		logger.log(LogStatus.PASS, "Step 2 - Click on Login Button - Success");
		logger.log(LogStatus.PASS, "Step 3 - Redirect on Password page - Success");
	}

	public void enterPassword() {
		System.out.println("--------- Password Page is Open ---------");
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys(prop.getProperty("Password"));
		System.out.println("- In EnterPassword");
		logger.log(LogStatus.PASS, "Step 4 - Enter Password - Success");
	}

	public void click2LoginButton() throws InterruptedException, IOException {
		Support.waitFor5Seconds();
		Assert.assertTrue(clickPassButton.isDisplayed());
		clickPassButton.click();
		System.out.println("- In Click Login2");
		//Support.waitFor3Seconds();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept_btn\"]")));
		String currentTitle = "Togel | Password";
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is - " + actualTitle);
		if (!currentTitle.equals(actualTitle)) {
			System.out.println("####### In If Method block #######");
			logger.log(LogStatus.PASS, "Step 5 - Click on Login Button - Success");
		} else {
			System.out.println("####### In else Method block #######");
			String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "FailLogin_ScreenShot");
			logger.log(LogStatus.FAIL, "Step 5 - Click on Login Button - Fail" + logger.addScreenCapture(screenShotPath));
			BaseTest.tearDown();
			try {
				Assert.assertFalse(actualTitle.contains("Password"));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void clickOnAgreement() {
		Assert.assertTrue(agree.isDisplayed());
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accept_btn\"]")));
		// //*[@id=\"accept_btn\"]
		agree.click();
		logger.log(LogStatus.PASS, "On Agreement Page, button clicked");
	}

	public void getUserInfo() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is - " + currentUrl);
		logger.log(LogStatus.PASS, "Successfully land on Dashboard Page, current URL is" + " - " + currentUrl);
	}
}
