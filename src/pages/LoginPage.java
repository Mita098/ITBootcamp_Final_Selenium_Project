package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//button/span[text()='Login']"));
	}
	public void waitLoginToFinish() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("btnProfile")));
	}

}