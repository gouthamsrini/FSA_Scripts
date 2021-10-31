package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalSalesHomePage extends BaseTest{
	
	
	public ThreadLocalOpportunitiesPage clickOpportunitiy() throws InterruptedException  {
		Thread.sleep(3000);
		WebElement element = remoteWebDriver.get().findElement(By.xpath("//a[@title='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor) remoteWebDriver.get();
		executor.executeScript("arguments[0].click();", element);
        return new ThreadLocalOpportunitiesPage();
	}
	
	public ThreadLocalSalesHomePage clickMoreOption() throws InterruptedException {
		Thread.sleep(3000);;
		remoteWebDriver.get().findElement(By.xpath("//span[text()='More']")).click();
		return this;	
	}
	
	public ThreadLocalCasesHomePage clickCasesOption() throws InterruptedException {
		WebElement element = remoteWebDriver.get().findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) remoteWebDriver.get();
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		return new ThreadLocalCasesHomePage();
	}
}