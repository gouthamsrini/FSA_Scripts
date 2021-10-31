package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass_POM;

public class CertificationAdminPage extends BaseClass_POM {
	
	public CertificationAdminPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CertificationAdminPage switchThirdWindow() throws InterruptedException {
		Set<String> windowHandle1 = driver.getWindowHandles();
		System.out.println(windowHandle1.size());
		for (String windows1 : windowHandle1) {
			System.out.println(windows1);
		}
		List<String> winList1 = new ArrayList<String>(windowHandle1);
		winList1.get(2);
		driver.switchTo().window(winList1.get(2));
		Thread.sleep(12000);
		return this;
	}
	
	public CertificationAdminPage clickSalesforceArchitect() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
		Thread.sleep(8000);
		return this;
	}
	
	public CertificationAdminPage verifyCertificateNames() {
		List<String> certName = new ArrayList<String>();
		List<WebElement> names = driver.findElements(By.xpath("(//div[contains(@class,'cs-card tile')]//a[not(contains(@class,'btn-gray'))])"));
		names.size();
		for (int i = 0; i < names.size(); i++) {
			String text = names.get(i).getText();
			certName.add(text);
		}					
		System.out.println("Certificate Names are:" +certName);
		return this;
	}
	
	public HomePage switchParentWindow() {
		Set<String> parentWindow = driver.getWindowHandles();
		System.out.println(parentWindow.size());
		for (String windows0 : parentWindow) {
			System.out.println(windows0);
		}
		List<String> pWindow = new ArrayList<String>(parentWindow);
		pWindow.get(0);
		driver.switchTo().window(pWindow.get(0));
		return new HomePage(driver);
	}
}