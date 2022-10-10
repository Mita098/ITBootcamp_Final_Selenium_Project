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

import pages.CitiesPage;
import pages.LoginPage;
import pages.NavPage;
import pages.SingUpPage;

public class BasicTest {
	protected WebDriver driver;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	protected LoginPage loginPage;
	protected NavPage navPage;
	protected SingUpPage singUpPage;
	protected CitiesPage citiesPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		loginPage = new LoginPage(driver);
		navPage = new NavPage(driver);
		singUpPage = new SingUpPage(driver);
		citiesPage = new CitiesPage(driver);
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
