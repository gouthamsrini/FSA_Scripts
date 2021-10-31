package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class ClickMoreOption extends BaseClass_POM {
	
	public ClickMoreOption(ChromeDriver driver) {
		this.driver = driver;
	}

	public CasesHomePage clickCaseOption() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='More']")).click();

		WebElement element = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(2000);
		return new CasesHomePage(driver);
	}
}
