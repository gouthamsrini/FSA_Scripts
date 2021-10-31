package threadLocalTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import threadLocalPages.ThreadLocalHomePage;

public class ThreadLocalEditCaseTestCase extends BaseTest{
	
	@Test
	public void runEditCase() throws InterruptedException {
		new ThreadLocalHomePage()
		.clickToggleMenu()
		.enterTextSales()
		.clickMoreOption()
		.clickCasesOption()
		.searchCase()
		.clickOnChosenCaseDropdown()
		.choseEditOption()
		.updateStatus()
		.updatePriority()
		.updateCaseOrigin()
		.updateSLA()
		.clickSave()
		.verifyCaseIsEdited()
		.verifyEditedStatus()
		.clickSearchedCaseName()
		.verifyStausIsCorrect();
	}
}
