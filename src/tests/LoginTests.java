package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	@Test(priority = 10)
	public void visitTheLoginPage() {
		navPage.getLanguageButton().click();
		navPage.getENLanguageButton().click();
		navPage.getLoginButton().click();
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: The current URL should contain /login");
	}

	@Test(priority = 20)
	public void checkInputTypes() {
		navPage.getLoginButton().click();
		Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
				"ERROR: Email input should contain type attribute email");
		Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
				"ERROR: Password input should contain type attribute password");
	}

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		popUpPage.waitDialogToApper();
		Assert.assertEquals(popUpPage.getPopUpMassageTextElement().getText(), "User does not exists",
				"ERROR: Wrong error massage is displayed should be 'User does not exists'");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: The current URL should contain /login");
	}
	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		popUpPage.waitDialogToApper();
		Assert.assertEquals(popUpPage.getPopUpMassageTextElement().getText(), "Wrong password",
				"ERROR: Wrong massage is displayed, should be 'Wrong password'");
		Assert.assertTrue(navPage.getUrl().contains("/login"), "ERROR: The current URL should contain /login");
	}
	@Test(priority = 50)
	public void login() throws InterruptedException {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		loginPage.waitLoginToFinish();
		Assert.assertTrue(navPage.getUrl().contains("/home"), "ERROR: The current URL should contain /home");
	}
	@Test(priority = 60)
	public void logout() {
		Assert.assertNotNull(navPage.getLogoutButton(), "ERROR: Logout element should be present");
		navPage.getLogoutButton().click();
	}
}
