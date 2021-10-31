package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class SalesHomePage extends BaseClass_POM{
	
	public SalesHomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public OpportunitiesPage  clickOpportunitiy() throws InterruptedException  {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
        return new OpportunitiesPage(driver);
	}
	
	public SalesHomePage clickMoreOption() throws InterruptedException {
		Thread.sleep(3000);;
		driver.findElement(By.xpath("//span[text()='More']")).click();
		return this;	
	}
	
	public CasesHomePage clickCasesOption() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		return new CasesHomePage(driver);
	}
}