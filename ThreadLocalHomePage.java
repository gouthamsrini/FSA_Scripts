package threadLocalPages;

import org.openqa.selenium.By;

import base.BaseTest;

public class ThreadLocalHomePage extends BaseTest {
	
	public ThreadLocalAppLauncherPage clickToggleMenu() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		remoteWebDriver.get().findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		return new ThreadLocalAppLauncherPage();
	}

	public ThreadLocalSalesforcePlatformPage clickLearnMore() throws InterruptedException {
		Thread.sleep(5000);
		remoteWebDriver.get().findElement(By.xpath("//span[text()='Learn More']")).click();
		return new ThreadLocalSalesforcePlatformPage();
	}
}