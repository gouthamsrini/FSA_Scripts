package Tstng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class S01_53_CreateNewCase extends BaseClass {

	@Test(dataProvider = "fetchData")
	public void runCreateNewCase(String subj, String description) throws InterruptedException {

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);

		// Click Sales
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();

		// select cases
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		WebElement element = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// select new case
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[13]")).click();
		WebElement newCase = driver.findElement(By.xpath("//span[text()='New Case']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", newCase);

		// Choose Contact Name from the drop down
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("gout");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Goutham Srinivas']")).click();

		// Select Case origin as email
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Email']")).click();

		// Select status as Escalated
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		driver.findElement(By.xpath("//span[@title='Escalated']")).click();

		// Enter Subject and description
		WebElement subject = driver.findElement(By.xpath("(//input[@class=' input'])[6]"));
		Thread.sleep(3000);
		subject.sendKeys(subj);
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);

		// Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);

		// Verify the message
		WebElement message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		String Text = actualText.replaceAll("\\d", ""); // to remove numbers
		String finalText = Text.replace("\"", ""); // to remove quotes
		String successMsg = finalText.replaceAll("\\s", ""); // to remove spaces
		System.out.println(successMsg);

		// Verify account is created
		String Expected = "Casewascreated";

		if (successMsg.contains(Expected)) {
			System.out.println("New Case is created successfully");
		} else {
			System.out.println("New Case is not created");
		}
	}

	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {

		ReadExcel re = new ReadExcel();
		return re.readData("CreateNewCase");
	}
}