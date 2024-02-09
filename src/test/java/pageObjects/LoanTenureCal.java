package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanTenureCal extends BasePage{

	public LoanTenureCal(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"loan-tenure-calc\"]")
	WebElement linkToLoanTenureCal;
	
	@FindBy(id="loanamount")
	WebElement loanAmtTextbox;
	
	@FindBy(id="loaninterest")
	WebElement InterestTextbox;
	
	@FindBy(id="loanemi")
	WebElement loanemiTextbox;
	
	@FindBy(id="loanfees")
	WebElement loanFeesTextbox;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div//label[1]")
	WebElement tenureInYear;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div//label[2]")
	WebElement tenureInMonths;
	
	@FindBy(xpath="//*[@id='loanamountslider']")
	WebElement Amtslider;
	
	@FindBy(xpath="//*[@id='loaninterestslider']")
	 WebElement intrestrateSlider;
	
	@FindBy(xpath="id=\"loanemislider\"")
	public WebElement EMISlider;
	
	@FindBy(xpath="//*[@id='loanfeesslider']")
	 WebElement loanfeesSlider;
	
	@FindBy(id="loanfees")
	WebElement loanFees;
	
	//points on slider
	
	@FindBy(xpath="//*[@id='loanfeesslider']/span")
	public WebElement Slidertestloanfees;
	
	@FindBy(xpath="//*[@id='loaninterestslider']/span")
	public WebElement Slidertestintrestrate;
	
	@FindBy(xpath="//*[@id=\"loanemislider\"]/span")
	WebElement loanEMISlider;
	
	@FindBy(xpath="//*[@id=\"loanamountslider\"]/span")
	WebElement loanAmtSlider;
	
	
	//Methods
	public void testMethod() {
		System.out.println("*******UI testing started for Loan Tenure Calculator******");
		System.out.println("----------------------------------------------------------");
	}
	
	public boolean verifyLoanWebpage() {
		String resultWebsite = driver.getTitle();
        String expectedWebsite = "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate";
        try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return false;
		}
	}
	
	public void takeScreenshot() throws InterruptedException, IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\Loan_Tenure.png");
		FileUtils.copyFile(screenshotFile,destFile);
	} 
	
	public void linkToLoan() {
		linkToLoanTenureCal.click();
	}
	
	public WebElement loanAmt() {
		return loanAmtTextbox;
	}
	
	public WebElement loanInterest() {
		return InterestTextbox;
	}
	
	public WebElement loanEMI() {
		return loanemiTextbox;
	}
	
	public WebElement loanFees() {
		return loanFeesTextbox;
	}
	
	public WebElement AmtScaler() {
		return Amtslider;
	}
	
	public WebElement interestSlider() {
		return intrestrateSlider;
	}
	
	public WebElement EMIslider() {
		return EMISlider;
	}
	
	public WebElement FeesSlider() {
		return loanfeesSlider;
	}
	
	public WebElement LoanAmtSlider() {
		return loanAmtSlider;
	}
	
	public WebElement loanEMISlider() {
		return loanEMISlider;
	}
	
	public WebElement loanInterestSlider() {
		return Slidertestintrestrate;
	}
	
	public WebElement loanFeesslidertest() {
		return Slidertestloanfees;
	}
	
	}
