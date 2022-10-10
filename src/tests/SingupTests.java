package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingupTests extends BasicTest{
	@Test(priority = 10)
	public void visitTheSingupPage() {
		navPage.getSingUpButton().click();
		singUpPage.waitSingupPageToOpen();
		Assert.assertTrue(navPage.getUrl().contains("/signup"), "ERROR: The current URL should contain /signup");

	}
	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSingUpButton().click();
		Assert.assertEquals(singUpPage.getEmailInput().getAttribute("type"), "email",
				"ERROR: Email input should contain type attribute email");
		Assert.assertEquals(singUpPage.getPasswordInput().getAttribute("type"), "password",
				"ERROR: Password input should contain type attribute password");
		Assert.assertEquals(singUpPage.getConfirmPasswordInput().getAttribute("type"), "password",
				"ERROR: Confirm password input should contain type attribute password");
			
	}
	@Test(priority = 30)
	public void displaysErrorsWhenUserAlreadyExists() {
		navPage.getSingUpButton().click();
		singUpPage.waitSingupPageToOpen();
		Assert.assertTrue(navPage.getUrl().contains("/signup"), "ERROR: The current URL should contain /signup");
		singUpPage.getNameInput().sendKeys("Another User");
		singUpPage.getEmailInput().sendKeys("admin@admin.com");
		singUpPage.getPasswordInput().sendKeys("12345");
		singUpPage.getConfirmPasswordInput().sendKeys("12345");
		singUpPage.getSingMeUpButton().click();
		popUpPage.waitDialogToApper();
		Assert.assertEquals(popUpPage.getPopUpMassageTextElement().getText(), "E-mail already exists",
				"ERROR: Wrong massage is displayed, should be 'E-mail already exists'");
		Assert.assertTrue(navPage.getUrl().contains("/signup"), "ERROR: The current URL should contain /signup");
	}
	@Test(priority = 40)
	public void singup() {
		navPage.getSingUpButton().click();
		singUpPage.waitSingupPageToOpen();
		Assert.assertTrue(navPage.getUrl().contains("/signup"), "ERROR: The current URL should contain /signup");
		singUpPage.getNameInput().sendKeys("Dimitrije Stojanovic");
		singUpPage.getEmailInput().sendKeys("Dimitrije.Stojanovic@itbootcamp.rs");
		singUpPage.getPasswordInput().sendKeys("12345");
		singUpPage.getConfirmPasswordInput().sendKeys("12345");
		singUpPage.getSingMeUpButton().click();
		popUpPage.waitForVerifyYourAccountDialogToApper();
		Assert.assertEquals(popUpPage.getVerifyYourAccountDialogTextElement().getText(), "IMPORTANT: Verify your account",
				"ERROR: Wrong massage is displayed, should be 'IMPORTANT: Verify your account'");
		popUpPage.getVerifyYourAccountDialogCloseButton().click();
		navPage.getLogoutButton().click();
	}
}
