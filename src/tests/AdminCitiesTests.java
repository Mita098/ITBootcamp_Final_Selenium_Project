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
	@Test(priority = 20)
	public void checksInputTypesForCreateOrEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditItemDialogToApper();
		Assert.assertEquals(citiesPage.getAddCitiesFieldInput().getAttribute("type"), "text", "ERROR: Name field should contain attribute type='text'");
	}
	@Test(priority = 30)
	public void createNewCity(){
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditItemDialogToApper();
		citiesPage.getAddCitiesFieldInput().sendKeys("zzz");
		citiesPage.getSaveButton().click();
		popUpPage.waitForCitiesDialogToApper();
		Assert.assertTrue(popUpPage.getPopUpCitiesMassageTextElement().getText().contains("Saved successfully"), "ERROR: Popup massage should contain 'Saved successfully'");
	}
	@Test(priority = 40)
	public void editCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("zzz");
		citiesPage.waitForTableRowsToApper(1);
		citiesPage.getEditByRowButton(1).click();
		citiesPage.getAddCitiesFieldInput().sendKeys("edits");
		citiesPage.getSaveButton().click();
		popUpPage.waitForCitiesDialogToApper();
		Assert.assertTrue(popUpPage.getPopUpCitiesMassageTextElement().getText().contains("Saved successfully"), "ERROR: Popup massage should contain 'Saved successfully'");

	}
	@Test(priority = 50)
	public void searchCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("zzzedits");
		citiesPage.waitForTableRowsToApper(1);
		citiesPage.getCellByRow(2, 1);
		Assert.assertEquals(citiesPage.getCellByRow(2, 1).getText(), "zzzedits","ERROR: Wrong name is displayed");
	}
	@Test(priority = 60)
	public void deleteCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("zzzedits");
		citiesPage.waitForTableRowsToApper(1);
		citiesPage.getCellByRow(2, 1);
		Assert.assertEquals(citiesPage.getCellByRow(2, 1).getText(), "zzzedits","ERROR: Wrong name is displayed");
		citiesPage.getDeleteByRowButton(1).click();
		citiesPage.waitForDeleteItemDialogToApper();
		citiesPage.getDeleteFromDialogButton().click();
		popUpPage.waitForCitiesDialogToApper();
		Assert.assertTrue(popUpPage.getPopUpCitiesDeleteMassageTextElement().getText().contains("Deleted successfully"), "ERROR: Popup massage should contain 'Deleted successfully'");

	}
}
