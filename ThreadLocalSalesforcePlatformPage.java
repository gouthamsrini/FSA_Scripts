package threadLocalPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseTest;

public class ThreadLocalSalesforcePlatformPage extends BaseTest{
	

	
	public ThreadLocalSalesforcePlatformPage switchSecondWindow() throws InterruptedException {
		Set<String> windowHandle = remoteWebDriver.get().getWindowHandles();
		System.out.println(windowHandle.size());
		for (String windows : windowHandle) {
			System.out.println(windows);
		}
		List<String> winList = new ArrayList<String>(windowHandle);
		winList.get(1);
		remoteWebDriver.get().switchTo().window(winList.get(1));
		Thread.sleep(12000);
		return this;	
	}
	
	public ThreadLocalSalesforcePlatformPage chooseResourcesOption() {
		JavascriptExecutor jse = (JavascriptExecutor) remoteWebDriver.get();
		WebElement resource = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		Actions builder = new Actions(remoteWebDriver.get());
		builder.moveToElement(resource).build().perform();
		return this;
	}
	
	public ThreadLocalCertificationAdminPage clickSalesforceCertification() {
		JavascriptExecutor jse = (JavascriptExecutor) remoteWebDriver.get();
		WebElement sfCertificate = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		jse.executeScript("arguments[0].click();", sfCertificate);
		return new ThreadLocalCertificationAdminPage();
	}	
}