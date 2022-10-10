package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public SingUpPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	public WebElement getNameInput() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	public WebElement getConfirmPasswordInput() {
		return driver.findElement(By.id("confirmPassword"));
	}
	public WebElement getSingMeUpButton() {
		return driver.findElement(By.xpath("//*[text()='Sign me up']"));
	}
	public void waitSingupPageToOpen() {
		wait.until(ExpectedConditions.urlContains("/signup"));
	}
}
