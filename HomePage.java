package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class HomePage extends BaseClass_POM {
	
	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public AppLauncherPage clickToggleMenu() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		return new AppLauncherPage(driver);
	}

	public SalesforcePlatformPage clickLearnMore() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		return new SalesforcePlatformPage(driver);
	}
}