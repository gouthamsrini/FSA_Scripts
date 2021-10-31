package threadLocalPages;

import org.openqa.selenium.By;

import base.BaseTest;

public class ThreadLocalEditCasePage extends BaseTest{
	
	public ThreadLocalEditCasePage updateStatus() throws InterruptedException {
		Thread.sleep(4000);
		remoteWebDriver.get().findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		Thread.sleep(3000);
		remoteWebDriver.get().findElement(By.xpath("//span[@title='Working']")).click();
		return this;
	}
	
	public ThreadLocalEditCasePage updatePriority() throws InterruptedException {
		Thread.sleep(4000);
		remoteWebDriver.get().findElement(By.xpath("//a[@class='select']")).click();
		Thread.sleep(2000);
		remoteWebDriver.get().findElement(By.xpath("//a[@title='Low']")).click();
		return this;
	}
	
	public ThreadLocalEditCasePage updateCaseOrigin() throws InterruptedException {
		Thread.sleep(4000);
		remoteWebDriver.get().findElement(By.xpath("(//a[@class='select'])[3]")).click();
		Thread.sleep(3000);
		remoteWebDriver.get().findElement(By.xpath("//a[@title='Phone']")).click();
		return this;
    }
	
	public ThreadLocalEditCasePage updateSLA() throws InterruptedException {
		Thread.sleep(4000);
		remoteWebDriver.get().findElement(By.xpath("(//a[@class='select'])[7]")).click();
		Thread.sleep(3000);
		remoteWebDriver.get().findElement(By.xpath("//a[@title='No']")).click();
		return this;
    }

	public ThreadLocalCasesHomePage clickSave() throws InterruptedException {
		Thread.sleep(4000);
		remoteWebDriver.get().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		return new ThreadLocalCasesHomePage();
    }
}	