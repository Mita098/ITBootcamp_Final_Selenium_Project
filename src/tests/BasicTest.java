package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasicTest {
	protected WebDriver driver;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";


	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("C:\\Users\\PC\\eclipse-workspace\\ITBootcamp_Final_Selenium_Project\\Screenshots\\Screenshot.png");
			FileHandler.copy(srcFile, destFile);
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
