package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_59_DeleteTask {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Load URL
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Enter 'Sales'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);

		// Click Sales
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();

		// click Tasks
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Tasks']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// Click on Dropdown icon available under tasks and select value as Recently
		// viewed
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();

		WebElement search = driver.findElement(By.xpath("//input[@name='Task-search-input']"));
		search.sendKeys("Bootcamp");
		search.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-grid slds-grid--vertical-align-center')]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();

		// click delete
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		// Get Message Text
        Thread.sleep(2000);
		WebElement message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		System.out.println(actualText);

		// verify task is deleted
		String Expected = "Task was deleted";

		if (actualText.contains(Expected)) {
			System.out.println("Task is deleted successfully");
		} else {
			System.out.println("Task is not deleted");
		}
	}
}