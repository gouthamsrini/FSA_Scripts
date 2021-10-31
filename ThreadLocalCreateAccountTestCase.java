package threadLocalTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import threadLocalPages.ThreadLocalHomePage;

public class ThreadLocalCreateAccountTestCase extends BaseTest {
	
	@BeforeTest
	public void setFileName() {
		
		filename="CreateAccount";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateAccount(String name, String closeDate) throws InterruptedException {
	     new ThreadLocalHomePage()
		.clickToggleMenu()
		.enterTextSales()
		.clickOpportunitiy()
		.clickNewButton()
		.enterAccountName(name)
		.enterCloseDate(closeDate)
		.chooseStage()
		.clickSaveButton()
		.verifyAccountName();	
	}
}