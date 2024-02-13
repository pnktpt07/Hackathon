package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import pageObjects.CarLoanEMI;
import pageObjects.EMI_Calculator;
import pageObjects.HomeLoanEMI;
import testBase.BaseClass;


public class TC_001_CarLoan extends BaseClass {

	CarLoanEMI cl;
	HomeLoanEMI hlm;
	EMI_Calculator ec;
	List<List<String>> tableData;

	@Test(priority = 1, groups = {"sanity","regression"})
	public void carLoanTest() {
		try {

			logger.info("**** starting TC_001_CarLoanEmi TestCase  *****");

			//logger.debug("application logs started......");

			cl = new CarLoanEMI(driver);
			boolean targetPage=cl.verifycarloanwebpage();
			Assert.assertEquals(targetPage, true,"Web page has not opened");
			System.out.println("Verified that actual page is same as expected page..");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Test Failed..");
		}

	}

	@Test(priority = 2,groups ="regression")
	public void carloanvalue() {
		try {
			logger.info("Entering Car Loan Amount..");
			cl.enterLoanAmount("1500000");
			logger.info("Entering Car Loan Interest..");
			cl.enterInterest("9.5");
			logger.info("Entering Car Loan Tenure..");
			cl.enterTenure("1");
			cl.clickonArrears();
			cl.clickonYear();
			logger.info("Printing Principal Amount and Interest Amount on console..");
			cl.printPincipalAmt();
			cl.takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Test Failed..");
		}

	}

	@Test(priority = 3,groups = {"sanity","regression"})  
	public void click_HomeLoan() {
		try {
			cl = new CarLoanEMI(driver);
			cl.linkToHomeLoanEMI(); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Test Failed..");
		}
	}


	@Test(priority = 4, groups ="regression")   
	public void homeLoanTest() {

		try {
			hlm = new HomeLoanEMI(driver);
			boolean targetPage=hlm.verifyHomeLoanWebpage();
			Assert.assertEquals(targetPage, true,"Web page has not opened");
			System.out.println("Verified that actual page is same as expected page..");
			hlm.HomeLoan("2500000","20","110000");
			hlm.loanDetails("12", "12", "0.25");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Test Failed..");
		}

	}
	@Test(priority = 5,groups={"sanity","regression"})
	public void excel() throws Throwable {

		try {
			tableData = hlm.extractandstoredata();
			ExcelUtils ex = new ExcelUtils();
			ex.writeToExcel(tableData);
			hlm.navigate();
			hlm.clickLoanCalculator();
			System.out.println("********UI testing started for Loan EMI Calculator********");
			System.out.println("----------------------------------------------------------");
			boolean targetPage=hlm.verifyLoanWebpage();
			Assert.assertEquals(targetPage, true,"EMI calculator page has not opened");
			System.out.println("EMI Calculator page has opened..");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Test Failed..");
		}
	}

}