package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class EMI_Calculator extends BasePage {
	public  EMI_Calculator(WebDriver driver) {
		super(driver);
	}

	//Elements 
 
	@FindBy(xpath="//*[@id=\"menu-item-3009\"]/a")
	WebElement loancalculator;

	@FindBy(id="loanamount")
    WebElement loanAmtTextbox;
	
	@FindBy(xpath="//*[@id='loanamountslider']")
	WebElement loanAmtSlider;
	
	@FindBy(xpath="//*[@id='loanamountslider']/span")
	public WebElement SlidertestloanAmount;
	
	@FindBy(xpath="//*[@id='loaninterest']")    
	WebElement IntrestrateTextbox;
	
	@FindBy(xpath="//*[@id='loaninterestslider']")
	 WebElement intrestrateSlider;
	
	@FindBy(xpath="//*[@id='loaninterestslider']/span")
	public WebElement Slidertestintrestrate;
	
	@FindBy(xpath="//*[@id='loanterm']")
	WebElement loantenureTextbox;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
	WebElement tenureInYear;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
	WebElement tenureInMonths;
	
	@FindBy(id="loanfees")
	WebElement loanfeesTextbox;
	
	@FindBy(xpath="//*[@id='loanfeesslider']")
	 WebElement loanfeesSlider;
	
	@FindBy(xpath="//*[@id='loanfeesslider']/span")
	public WebElement Slidertestloanfees;
 
	
	//Actions
	public boolean verifyLoanWebpage() {
		String resultWebsite = driver.getTitle();
        String expectedWebsite = "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate";
        try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return false;
		}
	}
	
	
	public void clickLoanCalculator() throws Throwable {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",loancalculator );
		 loancalculator.click();
	}
	
	public void takeScreenshot() throws InterruptedException, IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\EMI.png");
		FileUtils.copyFile(screenshotFile,destFile);
	}  
	
	public void testMethod() {
		System.out.println("********UI testing started for Loan EMI Calculator********");
		System.out.println("----------------------------------------------------------");
	}
	
	public WebElement loanAmount() {
		return loanAmtTextbox;
	}
	
	public WebElement Sliderloanamount() {
		return loanAmtSlider;
	}
	
	public WebElement IntrestRate() {
		return IntrestrateTextbox;
	}
	
	public WebElement IntrestrateSlider() {
		return intrestrateSlider;
	}
	
	public WebElement loanTenure() {
		return loantenureTextbox;
	}
	
	public WebElement loanfees() {
		return loanfeesTextbox;
	}
	
	public WebElement LoanfeesSlider() {
		return loanfeesSlider;
	}
	
	public WebElement tenureYear() {
		return  tenureInYear;
	}
	
	public WebElement tenureMonth() {
		return  tenureInMonths;
	}
 
 
}