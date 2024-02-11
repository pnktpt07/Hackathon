package testCases;
 
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import pageObjects.LoanAmtCal;
import testBase.BaseClass;
 
public class TC_003_Amount extends BaseClass {
	
        SoftAssert softAssert;
	@Test(priority = 11,groups = {"sanity","regression"}) 
	public void loanAmtuiTest() throws Throwable {
		try {
		logger.info("**** starting TC_003_Amount TestCase  *****");
		LoanAmtCal lac = new LoanAmtCal(driver);
		lac.linkToLoan();
		lac.testMethod();
		boolean targetPage=lac.verifyLoanAmtWebpage();
		softAssert.assertEquals(targetPage, true,"EMI calculator page has not opened");
		System.out.println("Verified that EMI Calculator page has opened..");
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}
	
	@Test(priority = 12,groups="regression") 
	public void enterEMI() throws Throwable {
		try {
			logger.info("Entering Loan Value..");
		LoanAmtCal lac = new LoanAmtCal(driver);
		WebElement loanEMI=lac.loanEMI();
		EMIUICheck(loanEMI);
		WebElement loanEMIScaler = lac.EMISlider();
		WebElement loanEMISlidertest = lac.LoanFeesslidertest();
		testSliderMovement(loanEMIScaler,loanEMISlidertest,1);
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}
	
	
	@Test(priority = 13,groups="regression") 
	public void enterInterest() throws Throwable {
		try {
			logger.info("Entering Loan Interest Value..");
		LoanAmtCal lac = new LoanAmtCal(driver);
		WebElement loanInterest=lac.loanInterest();
		InterestTextboxCheck(loanInterest); 
		WebElement loanInterestScaler = lac.interestSlider();
		WebElement loanInterestScalertest = lac.LoanInterestslider();
		testSliderMovement(loanInterestScaler,loanInterestScalertest,20);
	} catch (Exception e) {
        e.printStackTrace();
        logger.error("Test Failed..");
    }
	}
	
	
	@Test(priority = 14,groups="regression") 
	public void enterTenure() throws Throwable {
		try {
			logger.info("Entering Loan Tenure Value..");
		LoanAmtCal lac = new LoanAmtCal(driver);
		WebElement loanTenure=lac.loanTenure();
		WebElement tenureInYear=lac.tenureInYear();
		WebElement tenureInMonths=lac.tenureInMonths();
		TenureTextboxCheck(loanTenure,tenureInYear,tenureInMonths);
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}
	
	@Test(priority = 15,groups="regression") 
	public void enterFees() throws Throwable {
		try {
			logger.info("Entering Loan Fees Value..");
		LoanAmtCal lac = new LoanAmtCal(driver);
		WebElement LoanFees=lac.loanFees();
		FeesTextboxCheck(LoanFees);
		WebElement loanFeesScaler = lac.FeesSlider();
		WebElement Slidertest = lac.LoanFeesslidertest();
		testSliderMovement(loanFeesScaler,Slidertest,1);
		lac.takeScreenshot();
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
}
 
}
