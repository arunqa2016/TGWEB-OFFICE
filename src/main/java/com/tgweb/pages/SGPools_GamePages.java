package com.tgweb.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;
import com.tgweb.baseTest.BaseTest;
import com.tgweb.stepDefinition.SG_PoolsGame;
import com.tgweb.utilityFile.ScreenShotCaptured;
import com.tgweb.utilityFile.Support;
import com.tgweb.utilityFile.UserBasicInfo;

public class SGPools_GamePages extends BaseTest {

	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[3]/td/button[2]")
	@CacheLookup
	static WebElement clickKirim;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[1]")
	@CacheLookup
	WebElement betNum_4D_1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[2]")
	@CacheLookup
	WebElement betNum_4D_2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[3]")
	@CacheLookup
	WebElement betNum_4D_3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[4]")
	@CacheLookup
	WebElement betNum_4D_4;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[4]/input")
	@CacheLookup
	static WebElement bayarAmt_4d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[5]/input")
	@CacheLookup
	static WebElement bayarAmt_3d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[6]/input")
	@CacheLookup
	static WebElement bayarAmt_2d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[2]/td[4]/small")
	@CacheLookup
	static WebElement totalBayar;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[2]/button[2]")
	@CacheLookup
	static WebElement clickOK;

	public SGPools_GamePages() {
		PageFactory.initElements(driver, this);
	}

	public static void captureCurrentScreenShot() throws IOException {

		String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "screenShotName");
		logger.log(LogStatus.INFO, "Current Game Page Screen - " + logger.addScreenCapture(screenShotPath));
	}

	public static void getSGGamePeriode() {
		// ..........Market close login will be place here..........
		String getSGGamePeriod = UserBasicInfo.currentGamePeriode();
		logger.log(LogStatus.INFO, "Current Game period is - " + getSGGamePeriod);
		System.out.println("Current Game period is - " + getSGGamePeriod);
	}

	public static void userCurrrentBalance() {
		String userBalance = UserBasicInfo.userCurrentBalanceInfo();
		logger.log(LogStatus.PASS, "User's Current balance is" + " - " + userBalance);
		System.out.println("User's Current Balance is -" + userBalance);
	}

	public void enterBetNumberAndAmount() {

		Support.scrollPage(driver);

		betNum_4D_1.sendKeys(prop.getProperty("4D_Number_1"));
		betNum_4D_2.sendKeys(prop.getProperty("4D_Number_2"));
		betNum_4D_3.sendKeys(prop.getProperty("4D_Number_3"));
		betNum_4D_4.sendKeys(prop.getProperty("4D_Number_4"));

		List<WebElement> listofbetamt = driver.findElements(By.id("txtbetamount"));
		for (int i = 0; i < listofbetamt.size(); i++) {
			WebElement listelement = listofbetamt.get(i);
			String betrow = listelement.getAttribute("data-game-number");
			String betcol = listelement.getAttribute("data-game");
			// System.out.println(listelement.getAttribute("data-game"));

			if (betrow.equals("1") && betcol.equals("4d")) {
				listelement.sendKeys(prop.getProperty("4D_BetAmount"));
			}
			if (betrow.equals("1") && betcol.equals("3d")) {
				listelement.sendKeys(prop.getProperty("3D_BetAmount"));
			}
			if (betrow.equals("1") && betcol.equals("2d")) {
				listelement.sendKeys(prop.getProperty("2D_BetAmount"));
			}
		}
		System.out.println("Bet Amount entered in 4D/3D/2D game");
	}

	public static void bayarAmtCaclulation() {

		String bayar4D = bayarAmt_4d.getText();
		String bayar3D = bayarAmt_3d.getText();
		String bayar2D = bayarAmt_2d.getText();
		System.out.println("Bayar Amount is - " + bayar4D + ", " + ", " + bayar3D + ", " + ", " + bayar2D);
		String totalAmount = totalBayar.getText();
		System.out.println("Total amount is -" + totalAmount);
	}

	public static void clickKirimButton() throws IOException, InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[3]/td/button[2]")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/button[1]")));
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/button[1]")).click();

		String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "4D3D2D_Bet_Transaction");
		logger.log(LogStatus.INFO, "4D/3D/2D Game Page Screen with popup - " + logger.addScreenCapture(screenShotPath));
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"4Dgame\"]/div/div/ul/li[2]/a")
	@CacheLookup
	static WebElement BolakBalik_Game;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input")
	@CacheLookup
	static WebElement betNum_BB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"txtbetamount\"]")
	@CacheLookup 
	static WebElement betAmount_4d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"4dsetbayartotal\"]") 
	@CacheLookup 
	static WebElement totalBayar4D_BB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"3dsetbayartotal\"]") 
	@CacheLookup 
	static WebElement totalBayar3D_BB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"2dsetbayartotal\"]") 
	@CacheLookup 
	static WebElement totalBayar2D_BB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[2]/td[4]/small")
	@CacheLookup 
	static WebElement totalBayar_BB;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[3]/td/button[2]")
	@CacheLookup 
	static WebElement bolakBalik_Kirim;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[2]/button[1]")
	@CacheLookup 
	static WebElement bolakBalik_Batal;
	

	public static void enterNumbers_BolakBalik() {
		Support.scrollUpPage(driver);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input")));
		BolakBalik_Game.click();
		//betNum_BB.sendKeys(prop.getProperty("BolakBalik_Num"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input")));
		betNum_BB.sendKeys(prop.getProperty("BolakBalik_Num"));
	}

	public static void enterBetAmount_BolakBalik() {

		// .......On Bolak Balik Game Page.......
		List<WebElement> listOfBetAmt = driver.findElements(By.id("txtbetamount"));

		for (int i = 0; i < listOfBetAmt.size(); i++) {
			System.out.println("List element size is - " + listOfBetAmt.size());
			WebElement listElement = listOfBetAmt.get(i);
			String bet4d = listElement.getAttribute("data-game"); // 4dset
			String bet3d = listElement.getAttribute("data-game"); // 3dset
			String bet2d = listElement.getAttribute("data-game"); // 2dset

			if (bet4d.equals("4dset")) {
				listElement.sendKeys(prop.getProperty("4D_BetAmount"));
			} else if (bet3d.equals("3dset")) {
				listElement.sendKeys(prop.getProperty("3D_BetAmount"));
			} else if (bet2d.equals("2dset")) {
				listElement.sendKeys(prop.getProperty("3D_BetAmount"));
			}
		}
	}

	public static void getBayarAmount_BolakBalik() {
		String BB4D_Bayar = totalBayar4D_BB.getText();
		String BB3D_Bayar = totalBayar4D_BB.getText();
		String BB2D_Bayar = totalBayar4D_BB.getText();
		
		System.out.println("4D Total Bayar - " + BB4D_Bayar);
		System.out.println("4D Total Bayar - " + BB3D_Bayar);
		System.out.println("4D Total Bayar - " + BB2D_Bayar);
		
		String total_Bayar = totalBayar_BB.getText();
		System.out.println("Total Bayar amount in Bolak Balik is - " + total_Bayar);
		
	}

	public static void clickKirim_BolkaBalik() {
		bolakBalik_Kirim.click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/button[1]")));
		bolakBalik_Batal.click();
		logger.log(LogStatus.INFO, "Bolak Balik game page bet functionality - ");
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id=\"4Dgame\"]/div/div/ul/li[3]/a")
	@CacheLookup 
	static WebElement depanTengah_Game;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[1]")
	@CacheLookup 
	static WebElement depan_BetNum1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[2]")
	@CacheLookup 
	static WebElement depan_BetNum2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[2]/td[2]/div/input[2]")
	@CacheLookup 
	static WebElement tengah_BetNum1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[2]/td[2]/div/input[3]")
	@CacheLookup 
	static WebElement tengah_BetNum2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"txtbetamount\"]")
	@CacheLookup 
	static WebElement depan_BetAmt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"txtbetamount\"]")
	@CacheLookup 
	static WebElement tengah_BetAmt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[3]/input")
	@CacheLookup 
	static WebElement calc_DepanBayar;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[4]/input")
	@CacheLookup 
	static WebElement calc_TengahBayar;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[2]/td[3]/small")
	@CacheLookup 
	static WebElement calc_TotalBayar;
	
	public static void userOnDepanTengah() {
		depanTengah_Game.click();
	}

	public static void enterNum_DepanTengah() {
		depan_BetNum1.sendKeys(prop.getProperty("Depan_Num1"));
		depan_BetNum2.sendKeys(prop.getProperty("Depan_Num2"));
		tengah_BetNum1.sendKeys(prop.getProperty("Tengah_Num1"));
		tengah_BetNum2.sendKeys(prop.getProperty("Tengah_Num2"));
		
		logger.log(LogStatus.PASS, "Number entered in Depan and Tengah field");
		
	}

	public static void enterAmt_DepanTengah() {
		
		depan_BetAmt.sendKeys(prop.getProperty("Depan_betAmt"));
		depan_BetAmt.sendKeys(prop.getProperty("Tengah_betAmt"));
		
		logger.log(LogStatus.PASS, "Amount entered in Depan and Tengah field");
	}

	public static void calculateBayarAmt_DepanTengah() {
		String depanBayar = calc_DepanBayar.getText();
		String tengahBayar = calc_TengahBayar.getText();
		
		logger.log(LogStatus.PASS, "2D Depan Bayar amount - " + depanBayar + "2D Tengah Bayar Amount - " + tengahBayar);
	}

	public static void calculateTotalBayar_DepanTengah() {
		String totalBayar = calc_TotalBayar.getText();
		logger.log(LogStatus.PASS, "2D Depan Tengah Total Bayar amount - " + totalBayar);
		
	}

	public static void clickKirim_DepanTengah() {
		bolakBalik_Kirim.click();
		
	}

	public static void clickBatalBtn_DepanTengah() {
		bolakBalik_Batal.click();
		
	}

}
