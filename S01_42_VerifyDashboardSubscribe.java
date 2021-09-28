package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_42_VerifyDashboardSubscribe {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter user name
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");

		// Enter Password
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");

		// Click Login
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Enter 'Dashboards'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Dashboards");
		Thread.sleep(2000);

		// click Dashboards
		driver.findElement(By.xpath("//mark[text()='Dashboards']")).click();

		// select Dashboard tab
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[text()='Dashboards']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// search dashboard with your name
		WebElement search = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		search.sendKeys("Goutham");
		search.sendKeys(Keys.ENTER);

		// select Subscribe option
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Subscribe']")).click();

		// Select frequency as daily
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		// click save
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		//verify success message is displayed
		WebElement msgtxt = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		Thread.sleep(1000);
		String subscriptionMessage = msgtxt.getText();
		System.out.println(subscriptionMessage);

		// verify dashboard is subscribed successfully
		Thread.sleep(2000);
		WebElement search1 = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement subscribeCheck = driver.findElement(By.xpath("//span[text()='True']"));
		String txt = subscribeCheck.getText();

		String Expected = "True";

		if (txt.contains(Expected)) {
			System.out.println("Subscribed successfully");
		} else {
			System.out.println("Not Subscribed");
		}
	}
}