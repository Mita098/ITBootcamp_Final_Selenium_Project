package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
	@Test(priority = 10)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	@Test(priority = 20)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	@Test(priority = 30)
	public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
	@Test(priority = 40)
	public void forbidsVisitsToAdminUserseUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: Wrong page is visited");
	}
}
