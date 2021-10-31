package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class CasesHomePage extends BaseClass_POM {
	
	public CasesHomePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CaseCreationPage clickCasesDropdown() throws InterruptedException {
		driver.findElement(
				By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[13]")).click();

		WebElement newCase = driver.findElement(By.xpath("//span[text()='New Case']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", newCase);
		Thread.sleep(2000);
		return new CaseCreationPage(driver);		
	}
}