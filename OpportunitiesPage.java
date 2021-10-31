package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass_POM;

public class OpportunitiesPage extends BaseClass_POM {
	
	public OpportunitiesPage(ChromeDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void setData() {

		filename = "CreateAccount";
	}

	@Test(dataProvider = "fetchData")
	public OpportunitiesPage clickNewButton() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(2000);
		return this;
	}

	public OpportunitiesPage enterAccountName(String name) {
		WebElement assignedName = driver.findElement(By.xpath("//input[@name='Name']"));
		assignedName.sendKeys(name);
		assignedName.getText();
		System.out.println("The given opportunity name is" + assignedName);
		return this;
	}

	public OpportunitiesPage enterCloseDate(String closeDate) {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(closeDate);
		return this;
	}

	public OpportunitiesPage chooseStage() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		return this;
	}

	public AccountsHomePage clickSaveButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		return new AccountsHomePage(driver);
		
	}
}