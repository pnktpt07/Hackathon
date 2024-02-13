package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLoanEMI extends BasePage{

	public HomeLoanEMI(WebDriver driver) {
		super(driver);
	}

	//Elements
	@FindBy(id="homeprice")
	WebElement homeValue;

	@FindBy(id="downpayment")
	WebElement downPayment;

	@FindBy(xpath="//*[@id=\"homeloanemicalculatorformInner\"]/div[1]/div[1]/div[2]/div[2]/div/div/div/div/label[2]")
	WebElement clickonRupees;

	@FindBy(id="homeloaninsuranceamount")
	WebElement loanInsuranceAmt;

	@FindBy(id="homeloanamount")
	WebElement loanAmt;

	@FindBy(id="homeloaninterest")
	WebElement LoanInterest;

	@FindBy(id="homeloanterm")
	WebElement LoanTerm;

	@FindBy(id="loanfees")
	WebElement loanFees;

	@FindBy(id="startmonthyear")
	WebElement startMonthYear;

	@FindBy(id="yearheader")
	WebElement years;

	@FindBy(xpath="//*[@class=\"month\" or @class=\"month focused active\"]")
	List <WebElement> months;

	@FindBy(xpath="/html/body/div[4]/div[2]/table/thead/tr[2]/th[2]")
	WebElement year;

	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table/tbody")
	WebElement table;

	@FindBy(xpath="//*[@class=\"row no-margin yearlypaymentdetails\"]")
	List <WebElement> rows;

	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table/tbody/tr[2]/td")
	List <WebElement> cells;
	
	@FindBy(xpath="//*[@id=\"menu-item-3009\"]/a")
	WebElement loancalculator;

	List<List<String>> tableData = new ArrayList<List<String>>();

	//Methods
	public boolean verifyHomeLoanWebpage() {
		String resultWebsite = driver.getTitle();
		String expectedWebsite = "Home Loan EMI Calculator with Prepayments, Taxes & Insurance";
		try {
			return(resultWebsite.equals(expectedWebsite));
		}   catch(Exception e) {
			return false;
		}
	}

	//Sending Home Loan details
	public void HomeLoan(String amount, String downPaymentAmt, String insuranceAmt) throws InterruptedException {
		homeValue.sendKeys(Keys.CONTROL, "a");
		homeValue.sendKeys(Keys.BACK_SPACE);
		homeValue.sendKeys(amount);

		//clickonRupees.click();
		// Thread.sleep(1000);
		downPayment.sendKeys(Keys.CONTROL, "a");
		downPayment.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		downPayment.sendKeys(downPaymentAmt);

		loanInsuranceAmt.sendKeys(Keys.CONTROL, "a");
		loanInsuranceAmt.sendKeys(Keys.BACK_SPACE);
		loanInsuranceAmt.sendKeys(insuranceAmt);

		loanAmt.sendKeys(Keys.CONTROL, "a");
		loanAmt.sendKeys(Keys.BACK_SPACE);

		// Convert strings to numerical types
		double homeValue = Double.parseDouble(amount);
		double downpaymentValue = Double.parseDouble(downPaymentAmt);
		double insuranceValue = Double.parseDouble(insuranceAmt);

		// Perform subtraction
		double loanAmountValue = homeValue + insuranceValue - downpaymentValue;

		// Convert the result back to a string
		String loanAmountString = String.valueOf(loanAmountValue);

		// Send the result to the element
		loanAmt.sendKeys(loanAmountString);

	}


	public void loanDetails(String interestRate,String tenureAmt,String loanfees) {
		LoanInterest.sendKeys(Keys.CONTROL, "a");
		LoanInterest.sendKeys(Keys.BACK_SPACE);
		LoanInterest.sendKeys(interestRate);

		LoanTerm.sendKeys(Keys.CONTROL, "a");
		LoanTerm.sendKeys(Keys.BACK_SPACE);
		LoanTerm.sendKeys(tenureAmt);

		loanFees.sendKeys(Keys.CONTROL, "a");
		loanFees.sendKeys(Keys.BACK_SPACE);
		loanFees.sendKeys(loanfees);
	}

	public List<List<String>> extractandstoredata() throws IOException {

		List<List<String>> tableData = new ArrayList<>();
		WebElement table = driver.findElement(By.xpath("//*[@id=\"paymentschedule\"]/table/tbody"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table );

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\HomeLoanTabledata.png");
		FileUtils.copyFile(screenshotFile,destFile);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"noextras\"]//tr[@class=\"row no-margin yearlypaymentdetails\"]"));

		for (WebElement row : rows) {
			List<String> rowData = new ArrayList<>();
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				rowData.add(cell.getText());
			}
			tableData.add(rowData);
			//System.out.println(rowData);
		}

		return tableData;
	}
	

	public void takeScreenshot() throws InterruptedException, IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\screenshots\\HomeLoan.png");
		FileUtils.copyFile(screenshotFile,destFile);
	} 

	public void navigate() {
		driver.navigate().back();
	}
	
	public void clickLoanCalculator() throws Throwable {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",loancalculator );
		 loancalculator.click();
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

}
