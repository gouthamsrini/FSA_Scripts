package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class ThreadLocalCaseCreationPage extends BaseTest {
	

	@BeforeClass
	public void setData() {

		filename = "CreateNewCase";
	}

	@Test(dataProvider = "fetchData")
	public ThreadLocalCaseCreationPage choseContactName() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("gout");
		Thread.sleep(1000);
		remoteWebDriver.get().findElement(By.xpath("//div[@title='Goutham Srinivas']")).click();
		return this;
	}

	public ThreadLocalCaseCreationPage choseCaseOrigin() {
		remoteWebDriver.get().findElement(By.xpath("(//a[@class='select'])[2]")).click();
		remoteWebDriver.get().findElement(By.xpath("//a[@title='Email']")).click();
		return this;
	}

	public ThreadLocalCaseCreationPage choseStatus() throws InterruptedException {
		Thread.sleep(1000);
		remoteWebDriver.get().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		remoteWebDriver.get().findElement(By.xpath("//span[@title='Escalated']")).click();
		return this;
	}

	public ThreadLocalCaseCreationPage enterSubject(String subjName) throws InterruptedException {
		WebElement subject = remoteWebDriver.get().findElement(By.xpath("(//input[@class=' input'])[6]"));
		Thread.sleep(3000);
		subject.sendKeys(subjName);
		return this;
	}

	public ThreadLocalCaseCreationPage enterDescription(String description) {
		remoteWebDriver.get().findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);
		return this;
	}

	public ThreadLocalCasesDetailsPage clickSave() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		return new ThreadLocalCasesDetailsPage();
	}
}
	
	
	
	