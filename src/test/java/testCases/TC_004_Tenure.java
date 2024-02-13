package testCases;
 
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import pageObjects.LoanTenureCal;
import testBase.BaseClass;

//import testBase.BaseClass;
 
public class TC_004_Tenure extends BaseClass{

	LoanTenureCal ltc = new LoanTenureCal(driver);
        
	
	@Test(priority = 15,groups = {"sanity","regression"})
	public void loanTenureuiTest() throws Throwable {
		try {
		logger.info("**** starting TC_004_LoanTenureCal TestCase  *****");
		LoanTenureCal ltc = new LoanTenureCal(driver);
		ltc.linkToLoan();
		ltc.testMethod();
		boolean targetPage=ltc.verifyLoanWebpage();
		Assert.assertEquals(targetPage, true,"Tenure calculator page has not opened");
		System.out.println("Verified that Tenure Calculator page has opened..");
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
		
	}
	
	@Test(priority=16,groups="regression")
	public void loantenuretest() throws Throwable {
		try {
			logger.info("Entering Loan Amount Value..");
		LoanTenureCal ltc = new LoanTenureCal(driver);
		WebElement loanAmt=ltc.loanAmt();
		AmtTextUICheck(loanAmt);
		WebElement loanAmtScaler = ltc.AmtScaler();
		WebElement loanAmountScalertest = ltc.LoanAmtSlider();
		testSliderMovement(loanAmtScaler,loanAmountScalertest,200);
		WebElement loanEMI=ltc.loanEMI();
		EMIUICheck(loanEMI);
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}

	@Test(priority = 17,groups="regression")
	public void loanInterestTest() throws Throwable {
		try {
			logger.info("Entering Interest Value..");
		LoanTenureCal ltc = new LoanTenureCal(driver);
		WebElement loanInterest=ltc.loanInterest();
		InterestTextboxCheck(loanInterest);
		WebElement loanInterestScaler = ltc.interestSlider();
		WebElement loanInterestScalertest = ltc.loanInterestSlider();
		testSliderMovement(loanInterestScaler,loanInterestScalertest,20);
	} catch (Exception e) {
        e.printStackTrace();
        logger.error("Test Failed..");
    }
	}

	@Test(priority = 18,groups="regression")
	public void loanFeesTest() throws Throwable {
		try {
			logger.info("Entering Tenure Value..");
		LoanTenureCal ltc = new LoanTenureCal(driver);
		WebElement LoanFees=ltc.loanFees();
		FeesTextboxCheck(LoanFees);
		WebElement loanFeesScaler = ltc.FeesSlider();
		WebElement Slidertest = ltc.loanFeesslidertest();
		testSliderMovement(loanFeesScaler,Slidertest,1);
		ltc.takeScreenshot();
	} catch (Exception e) {
        e.printStackTrace();
        logger.error("Test Failed..");
    }

	}

}
