package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
	@Test(priority = 10)
	public void setLocaleToES() {
		navPage.getLanguageButton().click();
		navPage.getESLanguageButton().click();
		Assert.assertEquals(navPage.getHomeHeader().getText(), "Página de aterrizaje","ERROR: Wrong massage is displayed in header tag");
	}
	@Test(priority = 20)
	public void setLocaleToEN() {
		navPage.getLanguageButton().click();
		navPage.getENLanguageButton().click();
		Assert.assertEquals(navPage.getHomeHeader().getText(), "Landing","ERROR: Wrong massage is displayed in header tag");
	}
	@Test(priority = 30)
	public void setLocaleToCN() {
		navPage.getLanguageButton().click();
		navPage.getCNLanguageButton().click();
		Assert.assertEquals(navPage.getHomeHeader().getText(), "首页","ERROR: Wrong massage is displayed in header tag");
	}
	@Test(priority = 40)
	public void setLocaleToFR() {
		navPage.getLanguageButton().click();
		navPage.getFRLanguageButton().click();
		Assert.assertEquals(navPage.getHomeHeader().getText(), "Page d'atterrissage","ERROR: Wrong massage is displayed in header tag");
	}
	@Test(priority = 50)
	public void setLocaleToUA() {
		navPage.getLanguageButton().click();
		navPage.getUALanguageButton().click();
		Assert.assertEquals(navPage.getHomeHeader().getText(), "Лендінг","ERROR: Wrong massage is displayed in header tag");
	}
}
