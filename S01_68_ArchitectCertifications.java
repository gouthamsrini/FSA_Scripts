package Sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_68_ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Load URL: https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();

		// click Learn More option
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		// switch to second window
		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		for (String windows : windowHandle) {
			System.out.println(windows);
		}
		List<String> winList = new ArrayList<String>(windowHandle);
		winList.get(1);
		driver.switchTo().window(winList.get(1));
		Thread.sleep(12000);

		// choose Resource
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement resource = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
		Actions builder = new Actions(driver);
		builder.moveToElement(resource).build().perform();

		// click Salesforce Certification
		WebElement sfCertificate = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		jse.executeScript("arguments[0].click();", sfCertificate);
		
		// switch to third window
		Set<String> windowHandle1 = driver.getWindowHandles();
		System.out.println(windowHandle1.size());
		for (String windows1 : windowHandle1) {
			System.out.println(windows1);
		}
		List<String> winList1 = new ArrayList<String>(windowHandle1);
		winList1.get(2);
		driver.switchTo().window(winList1.get(2));
		Thread.sleep(12000);
		
		//click Salesforce Architect
		driver.findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
		Thread.sleep(5000);
		
		//Get Certificate Names
		WebElement certNme = driver.findElement(By.xpath("//div[contains(@class,'cs-card tile')]//a[not(contains(@class,'btn-gray'))]"));
		String certificateNames = certNme.getText();
		System.out.println(certificateNames);		
	}
}