package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class ThreadLocalOpportunitiesPage extends BaseTest {
	
	@BeforeClass
	public void setData() {

		filename = "CreateAccount";
	}

	@Test(dataProvider = "fetchData")
	public ThreadLocalOpportunitiesPage clickNewButton() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(2000);
		return this;
	}

	public ThreadLocalOpportunitiesPage enterAccountName(String name) {
		WebElement assignedName = remoteWebDriver.get().findElement(By.xpath("//input[@name='Name']"));
		assignedName.sendKeys(name);
		assignedName.getText();
		System.out.println("The given opportunity name is" + assignedName);
		return this;
	}

	public ThreadLocalOpportunitiesPage enterCloseDate(String closeDate) {
		remoteWebDriver.get().findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(closeDate);
		return this;
	}

	public ThreadLocalOpportunitiesPage chooseStage() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input")).click();
		Thread.sleep(1000);
		remoteWebDriver.get().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		return this;
	}

	public ThreadLocalAccountsHomePage clickSaveButton() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		return new ThreadLocalAccountsHomePage();
		
	}
}