package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalAccountsHomePage extends BaseTest {
	
	

	public ThreadLocalAccountsHomePage verifyAccountName() {
		WebElement message = remoteWebDriver.get().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		System.out.println(actualText);

		String Expected = "Salesforce Automation by Goutham";

		if (actualText.contains(Expected)) {
			System.out.println("Account is created successfully");
		} else {
			System.out.println("Account is not created");
		}

		return new ThreadLocalAccountsHomePage();
	}
}