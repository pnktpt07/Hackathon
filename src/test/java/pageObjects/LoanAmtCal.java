package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoanAmtCal extends BasePage{

		public LoanAmtCal(WebDriver driver) {
				super(driver);
			}
		
		@FindBy(xpath="//*[@id=\"loan-amount-calc\"]")
		WebElement linkToLoanAmtCal;
		
		@FindBy(id="loanemi")
		WebElement loanEMITextbox;
		
		@FindBy(id="loaninterest")
		WebElement InterestTextbox;
		
		@FindBy(id="loanterm")
		WebElement loantermTextbox;
		
		@FindBy(id="loanfees")
		WebElement loanFeesTextbox;
		
		@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div//label[1]")
		WebElement tenureInYear;
		
		@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]//label[2]")
		WebElement tenureInMonths;
		
		@FindBy(id="loanfees")
		WebElement loanFees;
		
		@FindBy(xpath="//*[@id=\"loanemislider\"]")
		WebElement EMIslider;
		
		@FindBy(xpath="id=\"loantermslider\"")
		WebElement TermSlider;
		
		@FindBy(xpath="//*[@id='loaninterestslider']")
		 WebElement intrestrateSlider;
		
		@FindBy(xpath="//*[@id='loaninterestslider']/span")
		public WebElement Slidertestintrestrate;
		
		@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
		WebElement loanTermSlider;
		
		@FindBy(xpath="//*[@id=\"loanemislider\"]/span")
		WebElement loanEMISlider;
		
		@FindBy(xpath="//*[@id='loanfeesslider']")
		 WebElement loanfeesSlider;
		
		@FindBy(xpath="//*[@id='loanfeesslider']/span")
		public WebElement Slidertestloanfees;
	
	//Methods
		public void testMethod() {
			System.out.println("*******UI testing started for Loan Amount Calculator******");
			System.out.println("----------------------------------------------------------");
		}
		
		public boolean verifyLoanAmtWebpage() {
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
			File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\Loan_Amount.png");
			FileUtils.copyFile(screenshotFile,destFile);
		} 
		
		public void linkToLoan() {
			linkToLoanAmtCal.click();
		}
		
		public WebElement loanEMI() {
			return loanEMITextbox;
		}
		
		public WebElement loanInterest() {
			return InterestTextbox;
		}
		
		public WebElement loanTenure() {
			return loantermTextbox;
		}
		
		public WebElement loanFees() {
			return loanFeesTextbox;
		}

		public WebElement tenureInYear() {
			return tenureInYear;
		}
		
		public WebElement tenureInMonths() {
			return tenureInMonths;
		}
		
		//sliders
	
	
		public WebElement EMISlider() {
			return EMIslider;
		}
		
		public WebElement interestSlider() {
			return intrestrateSlider;
		}
		
		public WebElement TermSlider() {
			return TermSlider;
		}
		
		public WebElement FeesSlider() {
			return loanfeesSlider;
		}
		
		
		
		//specific point on slider
		
		public WebElement LoanEMIScaler() {
			return loanEMISlider;
		}
		
		public WebElement LoanInterestslider() {
			return Slidertestintrestrate;
		}
		
		public WebElement LoanTermslider() {
			return loanTermSlider;
		}
		
		public WebElement LoanFeesslidertest() {
			return Slidertestloanfees;
		}
		
	
	}
