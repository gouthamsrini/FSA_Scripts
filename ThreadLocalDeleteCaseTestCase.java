package threadLocalTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import threadLocalPages.ThreadLocalHomePage;

public class ThreadLocalDeleteCaseTestCase extends BaseTest{
	
	@Test
	public void runDeleteCase() throws InterruptedException {
		new ThreadLocalHomePage()
		.clickToggleMenu()
		.enterTextSales()
		.clickMoreOption()
		.clickCasesOption()
		.searchCase()
		.clickOnChosenCaseDropdown()
		.choseDeleteOption()
		.clickDeleteButton()
		.verifyCaseIsDeleted();
	}
}