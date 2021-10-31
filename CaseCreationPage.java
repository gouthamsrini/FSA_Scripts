package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass_POM;

public class CaseCreationPage extends BaseClass_POM {
	
	public CaseCreationPage(ChromeDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void setData() {

		filename = "CreateNewCase";
	}

	@Test(dataProvider = "fetchData")
	public CaseCreationPage choseContactName() throws InterruptedException {
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("gout");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Goutham Srinivas']")).click();
		return this;
	}

	public CaseCreationPage choseCaseOrigin() {
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//a[@title='Email']")).click();
		return this;
	}

	public CaseCreationPage choseStatus() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		driver.findElement(By.xpath("//span[@title='Escalated']")).click();
		return this;
	}

	public CaseCreationPage enterSubject(String subjName) throws InterruptedException {
		WebElement subject = driver.findElement(By.xpath("(//input[@class=' input'])[6]"));
		Thread.sleep(3000);
		subject.sendKeys(subjName);
		return this;
	}

	public CaseCreationPage enterDescription(String description) {
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);
		return this;
	}

	public CasesDetailsPage clickSave() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		return new CasesDetailsPage(driver);
	}
}