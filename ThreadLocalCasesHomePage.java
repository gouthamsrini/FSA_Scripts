package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalCasesHomePage extends BaseTest {
	
	
	public ThreadLocalCaseCreationPage clickCasesDropdown() throws InterruptedException {
		remoteWebDriver.get().findElement(
				By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[13]")).click();

		WebElement newCase = remoteWebDriver.get().findElement(By.xpath("//span[text()='New Case']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) remoteWebDriver;
		executor1.executeScript("arguments[0].click();", newCase);
		Thread.sleep(2000);
		return new ThreadLocalCaseCreationPage();		
	}
	
	public ThreadLocalCasesHomePage searchCase() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search = remoteWebDriver.get().findElement(By.xpath("//input[@name='Case-search-input']"));
		search.sendKeys("00001247");
		search.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ThreadLocalCasesHomePage clickOnChosenCaseDropdown() throws InterruptedException {
		Thread.sleep(5000);
		remoteWebDriver.get().findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		return this;
	}
	
	public ThreadLocalEditCasePage choseEditOption() {
		remoteWebDriver.get().findElement(By.xpath("//a[@title='Edit']")).click();
		return new ThreadLocalEditCasePage();
	}
	
	public ThreadLocalCasesHomePage choseDeleteOption() {
		remoteWebDriver.get().findElement(By.xpath("//a[@title='Delete']")).click();
		return this;
	}
	
	public ThreadLocalCasesHomePage clickDeleteButton() {
		remoteWebDriver.get().findElement(By.xpath("//span[text()='Delete']")).click();
		return this;
	}
	
	public ThreadLocalCasesHomePage verifyCaseIsEdited() throws InterruptedException {
		WebElement message = remoteWebDriver.get().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		String Text = actualText.replaceAll("\\d", ""); // to remove numbers
		String finalText = Text.replace("\"", ""); // to remove quotes
		String successMsg = finalText.replaceAll("\\s", ""); // to remove spaces
		System.out.println(successMsg);

		String Expected = "Casewassaved";

		if (successMsg.contains(Expected)) {
			System.out.println("Case is Edited");
		} else {
			System.out.println("Case is not Edited");
		}
		Thread.sleep(8000);
		return this;	
	}
	
	public ThreadLocalCasesHomePage verifyCaseIsDeleted() throws InterruptedException {
		Thread.sleep(1000);
		WebElement delMsg = remoteWebDriver.get().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		System.out.println("Message displayed is :" + delMsg);
		Thread.sleep(2000);
		remoteWebDriver.get().findElement(By.xpath("//button[@data-element-id='searchClear']//lightning-primitive-icon[1]")).click();
		WebElement search = remoteWebDriver.get().findElement(By.xpath("//input[@name='Case-search-input']"));
		search.sendKeys("00001247");
		search.sendKeys(Keys.ENTER);
		String successMessage = remoteWebDriver.get().findElement(By.xpath("//span[text()='No items to display.']")).getText();

		String Expected = "No items to display.";

		if (successMessage.contains(Expected)) {
			System.out.println("Case is deleted");
		} else {
			System.out.println("Case is not deleted");
		}
		return this;
	}
	
	public ThreadLocalCasesHomePage verifyEditedStatus() {
		remoteWebDriver.get().findElement(By.xpath("//button[@data-element-id='searchClear']//lightning-primitive-icon[1]")).click();
		//remoteWebDriver.get().findElement(By.xpath("//input[@name='Case-search-input']")).click();
		WebElement search = remoteWebDriver.get().findElement(By.xpath("//input[@name='Case-search-input']"));
		search.sendKeys("00001301");
		search.sendKeys(Keys.ENTER);
		return this;		
    }
	
	public ThreadLocalCasesDetailsPage clickSearchedCaseName() {
		remoteWebDriver.get().findElement(By.xpath("//a[@title='00001301']")).click();
		return new ThreadLocalCasesDetailsPage();
	}
}