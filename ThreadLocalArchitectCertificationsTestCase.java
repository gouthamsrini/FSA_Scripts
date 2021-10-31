package threadLocalTestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import threadLocalPages.ThreadLocalHomePage;

public class ThreadLocalArchitectCertificationsTestCase extends BaseTest {
	
	
    @Test
	public void runArchitectCertifications() throws InterruptedException  {
    	new ThreadLocalHomePage()
		.clickLearnMore()
		.switchSecondWindow()
		.chooseResourcesOption()
		.clickSalesforceCertification()
		.switchThirdWindow()
		.clickSalesforceArchitect()
		.verifyCertificateNames()
		.switchParentWindow();
	}
}