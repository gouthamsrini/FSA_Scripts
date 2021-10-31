package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class AccountsHomePage extends BaseClass_POM {
	
	public AccountsHomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public AccountsHomePage verifyAccountName() {
		WebElement message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		System.out.println(actualText);

		String Expected = "Salesforce Automation by Goutham";

		if (actualText.contains(Expected)) {
			System.out.println("Account is created successfully");
		} else {
			System.out.println("Account is not created");
		}

		return new AccountsHomePage(driver);
	}
}