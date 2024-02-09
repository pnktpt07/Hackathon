package pageObjects;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarLoanEMI extends BasePage {

	public CarLoanEMI(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//*[@id=\"car-loan\"]/a")
	WebElement carloan;
	
	@FindBy(id="loanamount")
	WebElement carLoanAmt;
	
	@FindBy(id="loaninterest")
	WebElement carLoanInterest;
	
	@FindBy(id="loanterm")
	WebElement carLoanTenure;
	
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table")
	WebElement FirstScroll;
	
	@FindBy(id="year2024")
	WebElement clickOnYear;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	WebElement EMIArrears;
	
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[2]")
	WebElement FirstPrincipalAmt;
	
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[3]")
	WebElement FirstIntrestAmt;
	
	@FindBy(xpath="//*[@id=\"menu-item-3293\"]/a")
	WebElement linkToHomeLoanEMI;
	
	
	@FindBy(xpath="//*[@id=\"dismiss-button\"]")
	WebElement dismissAd;
	
	
	//Methods
	
	public boolean verifycarloanwebpage() {
		String resultWebsite = driver.getTitle();
        String expectedWebsite = "EMI Calculator for Home Loan, Car Loan & Personal Loan in India";
        try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return false;
		}
	}
	
	//Sending Loan Amount
	public void enterLoanAmount(String amount) {
		carloan.click();
	    carLoanAmt.sendKeys(Keys.CONTROL, "a");
	    carLoanAmt.sendKeys(Keys.BACK_SPACE);
	    carLoanAmt.sendKeys(amount);
	}
	
	//Sending Interest Value
	public void enterInterest(String interest) {
		carLoanInterest.sendKeys(Keys.CONTROL, "a");
		carLoanInterest.sendKeys(Keys.BACK_SPACE);
		carLoanInterest.sendKeys(interest);
	}
	
	//Sending Tenure Value
	public void enterTenure(String tenure) {
		carLoanTenure.sendKeys(Keys.CONTROL, "a");
		carLoanTenure.sendKeys(Keys.BACK_SPACE);
		carLoanTenure.sendKeys(tenure);
	}
	
	public void clickonArrears() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", EMIArrears);
		EMIArrears.click();
	}
	
	//Clicking on year in Table
	public void clickonYear() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnYear);
		clickOnYear.click();
	}
	
	//Printing Principal Amount and Interest on console
	public void printPincipalAmt() {
		System.out.println("Principal amount of first year: "+FirstPrincipalAmt.getText());
		System.out.println("Interest amount of first year: "+FirstIntrestAmt.getText());
		//dismissAd.click();
	}
	
	public void takeScreenshot() throws InterruptedException, IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\carLoan.png");
		FileUtils.copyFile(screenshotFile,destFile);
	}
	
	public void linkToHomeLoanEMI() {
		linkToHomeLoanEMI.click();
	}
	
	
}
