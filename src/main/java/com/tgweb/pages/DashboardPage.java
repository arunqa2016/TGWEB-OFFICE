package com.tgweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.utilityFile.UserBasicInfo;
import com.tgweb.baseTest.BaseTest;

public class DashboardPage extends BaseTest {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content-wrapper-main\"]/div/div[2]/div/div/div/div[2]/a/img")
	@CacheLookup static WebElement clickTogelGameView;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public static void onDashboardInfo() {
		
		String currentTitle = UserBasicInfo.currentTitleOfOpenPage();
		logger.log(LogStatus.PASS, "Title on Dashboard" + " - " + currentTitle);
		System.out.println("Title on Dashboard -" + currentTitle);
	}

	public static void userCurrrentBalance() {
		
		String userBalance = UserBasicInfo.userCurrentBalanceInfo();
		logger.log(LogStatus.PASS, "User's Current balance is" + " - " + userBalance);
		System.out.println("User's Current Balance is -" + userBalance);
	}

	public static void userInfo() {
	
		String userName = UserBasicInfo.userCurrentName();
		logger.log(LogStatus.PASS, "Username info is" + " - " + userName);
		System.out.println("Username is - " + userName);
	}

	public static void clickOnTogelViewGames() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/ul/li[3]")));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/ul/li[3]")).click();
	}

	public static void clickOnSGPoolsGame() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"togel_list\"]/ul/li[1]")));
		driver.findElement(By.xpath("//*[@id=\"togel_list\"]/ul/li[1]")).click();
	}
	
	public static void getSGGameTitle() {
		String currentTitle = UserBasicInfo.currentTitleOfOpenPage();
		logger.log(LogStatus.PASS, "Title on SG Pools Games Page" + " - " + currentTitle);
		System.out.println("Title on SG Pools Games Page -" + currentTitle);
	}
	
	public static void getSGGameCurrentURL() throws InterruptedException {
		String currentURL = UserBasicInfo.currentURLOfOpenPage();
		logger.log(LogStatus.PASS, "URL of SG Pools Games Page" + " - " + currentURL);
		System.out.println("URL of SG Pools Games Page -" + currentURL);
	}

}
