package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public PopUpPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	public WebElement getPopUpMassageTextElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'background ')]//li"));
	}
	public void waitDialogToApper() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'background ')]//li")));
	}
	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[text()='Close']"));
	}
	public void waitForVerifyYourAccountDialogToApper() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}
	public WebElement getVerifyYourAccountDialogTextElement() {
		return driver.findElement(By.className("card__text"));
	}
	public WebElement getVerifyYourAccountDialogCloseButton() {
		return driver.findElement(By.className("btnClose "));
	}
}
