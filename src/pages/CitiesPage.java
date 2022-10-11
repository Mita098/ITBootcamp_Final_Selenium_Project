package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	public WebElement getNewItemButton() {
		return driver.findElement(By.xpath("//form//button"));
	}
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	public WebElement getAddCitiesFieldInput() {
		return driver.findElement(By.id("name"));
	}
	public void waitForEditItemDialogToApper() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'dialog__content--active')]/div/div")));
		
	}
	public void waitForDeleteItemDialogToApper() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Cancel ']")));
		
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.className("btnSave"));
	}
	public void waitForTableRowsToApper(int rows) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rows + 1));
	}
	public WebElement getCellByRow(int cell, int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + cell + "]"));
	}
	public WebElement getEditByRowButton(int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
					 .findElement(By.id("edit"));
	}
	public WebElement getDeleteByRowButton(int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
					 .findElement(By.id("delete"));
	}
}
