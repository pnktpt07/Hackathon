package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;


	@BeforeTest(groups = {"sanity","regression"})
	@Parameters({"os", "br"})
	public void setup(String os, String br) throws IOException

	{
		logger=LogManager.getLogger(this.getClass().getName());//Log4j
		//loading properties file
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{	

			DesiredCapabilities capabilities=new DesiredCapabilities();

			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}

			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
			return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
	}

	public  int getRandom(int size) {
		Random random=new Random();
		int generatedNumber = random.nextInt(size);
		return generatedNumber;
	}

	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\ExtentReportScreenshot\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}


	public void AmtTextUICheck(WebElement element) {
		boolean isDisplayed=element.isDisplayed();
		System.out.println("Loan Amount Textbox displayed: "+isDisplayed);

		boolean isEnabled=element.isEnabled();
		System.out.println("Loan Amount Textbox enabled: "+isEnabled);

		String textBoxValue=element.getAttribute("value");
		System.out.println("Loan Amount Textbox value "+textBoxValue);
	}


	public void InterestTextboxCheck(WebElement element) {
		boolean isDisplayed=element.isDisplayed();
		System.out.println("Interest Textbox displayed: "+isDisplayed);

		boolean isEnabled=element.isEnabled();
		System.out.println("Interest Textbox enabled: "+isEnabled);

		String textBoxValue=element.getAttribute("value");
		System.out.println("Interest Textbox value: "+textBoxValue);

	}

	public void FeesTextboxCheck(WebElement element) {

		boolean isDisplayed=element.isDisplayed();
		System.out.println("Fees Textbox displayed: "+isDisplayed);

		boolean isEnabled=element.isEnabled();
		System.out.println("Fees Textbox enabled: "+isEnabled);

		String textBoxValue=element.getAttribute("value");
		System.out.println("Fees value: "+textBoxValue);

	}

	public void EMIUICheck(WebElement element) {
		boolean isDisplayed=element.isDisplayed();
		System.out.println("EMI Textbox displayed: "+isDisplayed);

		boolean isEnabled=element.isEnabled();
		System.out.println("EMI Textbox enabled: "+isEnabled);

		String textBoxValue=element.getAttribute("value");
		System.out.println("EMI Textbox value "+textBoxValue);
	}

	public void TenureTextboxCheck(WebElement loantenureTextbox,WebElement tenureInYr , WebElement tenureInMons ) {

		boolean isDisplayed=loantenureTextbox.isDisplayed();
		System.out.println("Tenure Textbox displayed: "+isDisplayed);
		boolean isEnabled=loantenureTextbox.isEnabled();
		System.out.println("Tenure Textbox enabled: "+isEnabled);
		tenureInYr.click();
		String textBoxValueinYear=loantenureTextbox.getAttribute("value");
		int textBoxValueinYr=Integer.parseInt(textBoxValueinYear);
		System.out.println("Tenure Textbox value in year: "+textBoxValueinYr);
		//Converting Years to months for comparing
		int loanTenureValuesInMonths=textBoxValueinYr*12;
		tenureInMons.click();
		String textBoxValueinMonths=loantenureTextbox.getAttribute("value");
		int textBoxValueinMon=Integer.parseInt(textBoxValueinMonths);
		System.out.println("Tenure Textbox value in Months: "+textBoxValueinMon);
		Assert.assertEquals(loanTenureValuesInMonths, textBoxValueinMon,"Values are not equal..");
		System.out.println("Tenure values are Verified");

	}


	public void testSliderMovement(WebElement slider,WebElement element, int n) throws Throwable {

		// Use the Actions class to move the slider
		int intialX = element.getLocation().getX();
		System.out.println("Intial value of slider:"+ intialX);
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).moveByOffset(10, 0).release().perform();
		Thread.sleep(2000);
		// Get the slider's current position
		int finalX = element.getLocation().getX();
		System.out.println("Final value of slider: "+finalX);
		actions.dragAndDropBy(slider, getRandom(n), 0).perform();
		Assert.assertNotEquals(intialX,finalX,"slider didnot move as expected");

	}

	@AfterTest(groups = {"sanity","regression"})
	public void teardown() {
		driver.quit();
	}

}


