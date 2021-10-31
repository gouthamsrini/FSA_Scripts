package threadLocalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalClickMoreOption extends BaseTest {
	


	public ThreadLocalCasesHomePage clickCaseOption() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//span[text()='More']")).click();

		WebElement element = remoteWebDriver.get().findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) remoteWebDriver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(2000);
		return new ThreadLocalCasesHomePage();
	}
}
