package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
	@Test(priority = 10)
	public void visitTheAdminCitiesPageAndListCities() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		Assert.assertTrue(navPage.getUrl().contains("/admin/cities"), "ERROR: Wrong url is displayed. Should contain '/admin/cities'");
	}
}
