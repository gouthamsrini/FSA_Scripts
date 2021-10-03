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

public class S01_66_CustomerServiceOptions {

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

		//switch to second window
		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		for (String windows : windowHandle) {
			System.out.println(windows);
		}
		List<String> winList = new ArrayList<String>(windowHandle);
		winList.get(1);
		driver.switchTo().window(winList.get(1));
		Thread.sleep(12000);

		// choose Products
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement products = (WebElement) jse.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
		Actions builder = new Actions(driver);
		builder.moveToElement(products).build().perform();

		// click Service
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		WebElement service = (WebElement) jse1.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > div > div > div > div:nth-child(1) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span\")");
		jse1.executeScript("arguments[0].click();", service);

		// Verify the tabs displayed in the page
		Thread.sleep(3000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jse2.executeScript(
				"return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul\")");
		String actualtabNames = element.getText();
		System.out.println("\r\n" + "Actual Tabs are : "+ actualtabNames);

		String String1 = "Resources";
		String String2 = "Support";
		String String3 = "Company";
		String String4 = "COVID-19";
		String String5 = "Salesforce+";
		String expectedTabs = String1 + "\r\n" + String2 + "\r\n" + String3 + "\r\n" + String4 + "\r\n" + String5;
		System.out.println("Expected Tabs are : " +expectedTabs);

		if (actualtabNames.contains(expectedTabs)) {
			System.out.println("Tabs are matching");
		} else {
			System.out.println("Tabs are not matching");
		}
	}
}