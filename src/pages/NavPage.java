package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	private WebDriver driver;

	public NavPage(WebDriver driver) {
		super();
		this.driver = driver;
}
	public WebElement getHomePageLink() {
		return driver.findElement(By.xpath("//*[text()=' Home ']"));
	}
	public WebElement getAboutLink() {
		return driver.findElement(By.xpath("//*[text()=' About ']"));
	}
	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}
	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}
	public WebElement getCitiesLink() {
		return driver.findElement(By.id("list-item-117"));
	}
	public WebElement getUsersLink() {
		return driver.findElement(By.id("list-item-120"));
	}
	public WebElement getSingUpButton() {
		return driver.findElement(By.className("btnLogin"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')]"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}
	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}
	public WebElement getENLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[1]"));
	}
	public WebElement getESLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[2]"));
	}
	public WebElement getFRLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[3]"));
	}
	public WebElement getCNLanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[4]"));
	}
	public WebElement getUALanguageButton() {
		return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[5]"));
	}
}
