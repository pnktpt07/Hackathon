package testCases;
 
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import pageObjects.EMI_Calculator;
import testBase.BaseClass;

 
public class TC_002_EMI extends BaseClass{
 
	EMI_Calculator EMI = new EMI_Calculator(driver);
	
	
	@Test(priority = 6,groups = {"sanity","regression"})
	public void emicalculator() throws Throwable {
		try {
		logger.info("**** starting TC_002_EMI TestCase  *****");
		EMI_Calculator EMI = new EMI_Calculator(driver);
		EMI.clickLoanCalculator();
		EMI.testMethod();
		boolean targetPage=EMI.verifyLoanWebpage();
		Assert.assertEquals(targetPage, true,"EMI calculator page has not opened");
		System.out.println("EMI Calculator page has opened..");
	} catch (Exception e) {
        e.printStackTrace();
        logger.error("Test Failed..");
    }
	}
	
	@Test(priority = 7,groups = "regression")
	public void enterLoanAmt() throws Throwable {
		try {
			logger.info("Entering loan Amount value..");
		EMI_Calculator EMI = new EMI_Calculator(driver);
		WebElement loanAmount= EMI.loanAmount();
		AmtTextUICheck(loanAmount);
		WebElement Sliderloanamount= EMI.Sliderloanamount();
		WebElement Slidertestloanamount=EMI.SlidertestloanAmount;
		testSliderMovement(Sliderloanamount,Slidertestloanamount,200);
		} 
		catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}
	
	
	@Test(priority = 8,groups = "regression")
	public void enterInterest() throws Throwable {
		try {
			logger.info("Entering loan Interest value..");
		EMI_Calculator EMI = new EMI_Calculator(driver);
		WebElement IntrestRate = EMI.IntrestRate();
		InterestTextboxCheck(IntrestRate);
		WebElement intrestrateSlider= EMI.IntrestrateSlider();
		WebElement Slidertestintrestrate=EMI.Slidertestintrestrate;
		testSliderMovement(intrestrateSlider,Slidertestintrestrate,20);
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}

	@Test(priority = 9,groups = "regression")
	public void enterLoan() throws Throwable {
		try {
			logger.info("Entering loan Tenure value..");
		EMI_Calculator EMI = new EMI_Calculator(driver);
		WebElement loanTenure=EMI.loanTenure();
		WebElement tenureYear = EMI.tenureYear();
		WebElement tenureMonth=EMI.tenureMonth();	    
		TenureTextboxCheck(loanTenure,tenureYear,tenureMonth);
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("Test Failed..");
        }
	}
	
	@Test(priority = 10,groups = "regression")
	public void enterFees() throws Throwable {
		try {
			logger.info("Entering loan Fees value..");
		EMI_Calculator EMI = new EMI_Calculator(driver);
		WebElement loanfees= EMI.loanfees();
		FeesTextboxCheck(loanfees);
		WebElement loanfeesSlider= EMI.LoanfeesSlider();
		WebElement Slidertestloanfees=EMI.Slidertestloanfees;
		testSliderMovement(loanfeesSlider,Slidertestloanfees,1);
		EMI.takeScreenshot();
	} catch (Exception e) {
        e.printStackTrace();
        logger.error("Test Failed..");
    }
		}
	}
