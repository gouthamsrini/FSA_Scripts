package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalCasesDetailsPage extends BaseTest{

	
	public ThreadLocalCasesDetailsPage verifyCaseName() {
		WebElement message = remoteWebDriver.get().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		String Text = actualText.replaceAll("\\d", ""); // to remove numbers
		String finalText = Text.replace("\"", ""); // to remove quotes
		String successMsg = finalText.replaceAll("\\s", ""); // to remove spaces
		System.out.println(successMsg);
		
		String Expected = "Casewascreated";

		if (successMsg.contains(Expected)) {
			System.out.println("New Case is created successfully");
		} else {
			System.out.println("New Case is not created");
		}
		return this;		
	}
	
	public ThreadLocalCasesDetailsPage verifyStausIsCorrect() {
		String statusText = remoteWebDriver.get().findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field']")).getText();
		System.out.println("Status is : " + statusText);
		return this;
	}
}