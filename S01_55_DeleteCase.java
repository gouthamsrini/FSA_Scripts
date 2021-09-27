package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_55_DeleteCase {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter username
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");

		// Enter Password
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");

		// Click Login
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);

		// Click Sales
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();

		// select cases
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		WebElement element = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// search test case created
		WebElement search = driver.findElement(By.xpath("//input[@name='Case-search-input']"));
		search.sendKeys("1027");
		search.sendKeys(Keys.ENTER);

		// select drop down
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();

		// click delete
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		// verify delete message is displayed
		Thread.sleep(1000);
		WebElement delMsg = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		System.out.println("Message displayed is :" + delMsg);

		// The case with your name/id should not be there in the application
		Thread.sleep(2000);
		WebElement check = driver.findElement(By.xpath("//input[@name='Case-search-input']"));
		check.clear();
		check.sendKeys("1027");
		check.sendKeys(Keys.ENTER);
		WebElement Message = driver.findElement(By.xpath("//span[text()='No items to display.']"));
		String msg = Message.getText();

		String Expected = "No items to display.";

		if (msg.contains(Expected)) {
			System.out.println("Case is deleted");
		} else {
			System.out.println("Case is not deleted");
		}
	}
}