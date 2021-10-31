package threadLocalPages;

import org.openqa.selenium.By;
import base.BaseTest;

public class ThreadLocalAppLauncherPage extends BaseTest {
	
	public ThreadLocalSalesHomePage enterTextSales() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);
		remoteWebDriver.get().findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();
		Thread.sleep(3000);
		return new ThreadLocalSalesHomePage();
	}	
}