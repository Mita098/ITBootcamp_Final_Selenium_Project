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
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
}
	public WebElement getPopUpMassageTextElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'background ')]//li"));
	}
	public WebElement getPopUpCitiesMassageTextElement() {
		return driver.findElement(By.xpath("//div[contains(@class, 'success')]//div[@role='status']"));
	}
	public WebElement getPopUpCitiesDeleteMassageTextElement() {
		return driver.findElement(By.xpath("//div[contains(@class, 'success')]//div[@role='status']"));
	}
	public void waitDialogToApper() {
		wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'background ')]"), "class", "v-snack--active"));
	}
	public void waitForCitiesDialogToApper() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]//div[@role='status']")));
	}

	public void waitForVerifyYourAccountDialogToApper() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dlgVerifyAccount")));


	}
	public WebElement getVerifyYourAccountDialogTextElement() {
		return driver.findElement(By.className("dlgVerifyAccount"));
	}
	public WebElement getVerifyYourAccountDialogCloseButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-card__actions')]/button"));
	}
}
