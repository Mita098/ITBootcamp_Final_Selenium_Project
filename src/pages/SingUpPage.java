package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingUpPage {
	private WebDriver driver;

	public SingUpPage(WebDriver driver) {
		super();
		this.driver = driver;
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

}
