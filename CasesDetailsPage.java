package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class CasesDetailsPage extends BaseClass_POM{
	
	public CasesDetailsPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CasesDetailsPage verifyCaseName() {
		WebElement message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
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
}