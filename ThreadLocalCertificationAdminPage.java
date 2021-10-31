package threadLocalPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ThreadLocalCertificationAdminPage extends BaseTest{
	
	
	public ThreadLocalCertificationAdminPage switchThirdWindow() throws InterruptedException {
		Set<String> windowHandle1 = remoteWebDriver.get().getWindowHandles();
		System.out.println(windowHandle1.size());
		for (String windows1 : windowHandle1) {
			System.out.println(windows1);
		}
		List<String> winList1 = new ArrayList<String>(windowHandle1);
		winList1.get(2);
		remoteWebDriver.get().switchTo().window(winList1.get(2));
		Thread.sleep(12000);
		return this;
	}
	
	public ThreadLocalCertificationAdminPage clickSalesforceArchitect() throws InterruptedException {
		remoteWebDriver.get().findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
		Thread.sleep(8000);
		return this;
	}
	
	public ThreadLocalCertificationAdminPage verifyCertificateNames() {
		List<String> certName = new ArrayList<String>();
		List<WebElement> names = remoteWebDriver.get().findElements(By.xpath("(//div[contains(@class,'cs-card tile')]//a[not(contains(@class,'btn-gray'))])"));
		names.size();
		for (int i = 0; i < names.size(); i++) {
			String text = names.get(i).getText();
			certName.add(text);
		}					
		System.out.println("Certificate Names are:" +certName);
		return this;
	}
	
	public ThreadLocalHomePage switchParentWindow() {
		Set<String> parentWindow = remoteWebDriver.get().getWindowHandles();
		System.out.println(parentWindow.size());
		for (String windows0 : parentWindow) {
			System.out.println(windows0);
		}
		List<String> pWindow = new ArrayList<String>(parentWindow);
		pWindow.get(0);
		remoteWebDriver.get().switchTo().window(pWindow.get(0));
		return new ThreadLocalHomePage();
	}
}