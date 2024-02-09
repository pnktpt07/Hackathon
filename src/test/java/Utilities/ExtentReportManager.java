package Utilities;

 
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult; 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
 
import testBase.BaseClass;
 
public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String reportName;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-"+ timeStamp +".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
		sparkReporter.config().setDocumentTitle(" Interest Amount for current year report");
		sparkReporter.config().setReportName(" Interest Amount for current year Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "Be.cognizant");
		extent.setSystemInfo("project_Name", " Interest Amount for current year");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customer");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Priyanka Tripathy");

//		String os = testContext.getCurrentXmlTest().getParameter("os");

//		extent.setSystemInfo("operating System", os);

//		

//		String browser = testContext.getCurrentXmlTest().getParameter("browser");

//		extent.setSystemInfo("operating System", browser);

	}

//		public void IncludeGroups(ITestContext testContext) {

//		try {

//		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();

//		if(includedGroups != null && !includedGroups.isEmpty()) {

//		extent.setSystemInfo("Groups", includedGroups.toString());	

//		}else {

//			Assert.fail("Test Failed because included groups is null");

//		}

//		}catch(ClassCastException | NullPointerException| IllegalArgumentException e) {

//			Assert.fail("Test failed due to classcassException or NUllPointerException or IllegalArgumentException:" + e.getMessage());

//		}

//	}


	public void onTestSuccess(ITestResult result) {
		 
		test = extent.createTest(result.getTestClass().getName()); //Create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, result.getName() + " got successfully executed"); //Update Status
		try {
			String imgPath1 = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath1);
 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
 
	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+ "got Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		try {
		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

		public void onTestSkipped(ITestResult result) {

			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,result.getName()+ "got Skipped");
			test.log(Status.INFO,result.getThrowable().getMessage());

		}

	    public void onFinish(ITestContext testContext) {

	    	extent.flush();
	    	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
	    	File extentReport = new File(pathOfExtentReport);
	    	try {
	    		Desktop.getDesktop().browse(extentReport.toURI());
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}

	    }
 
}