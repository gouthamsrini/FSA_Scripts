package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class AppLauncherPage extends BaseClass_POM {
	
	public AppLauncherPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public SalesHomePage enterTextSales() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();
		Thread.sleep(3000);
		return new SalesHomePage(driver);
	}	
}