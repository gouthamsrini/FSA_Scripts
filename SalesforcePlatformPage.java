package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass_POM;

public class SalesforcePlatformPage extends BaseClass_POM{
	
	public SalesforcePlatformPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public SalesforcePlatformPage switchSecondWindow() throws InterruptedException {
		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		for (String windows : windowHandle) {
			System.out.println(windows);
		}
		List<String> winList = new ArrayList<String>(windowHandle);
		winList.get(1);
		driver.switchTo().window(winList.get(1));
		Thread.sleep(12000);
		return this;	
	}
	
	public SalesforcePlatformPage chooseResourcesOption() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement resource = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		Actions builder = new Actions(driver);
		builder.moveToElement(resource).build().perform();
		return this;
	}
	
	public CertificationAdminPage clickSalesforceCertification() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement sfCertificate = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		jse.executeScript("arguments[0].click();", sfCertificate);
		return new CertificationAdminPage(driver);
	}	
}