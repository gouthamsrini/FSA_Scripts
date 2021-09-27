package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_29_CreateAccount {

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

		// Enter 'Sales'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);

		// Click Sales
		driver.findElement(
				By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();
		// driver.findElement(By.xpath("(//mark[text()='Sales'])[3]"));

		// Click Opportunity
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		// click New
		driver.findElement(By.xpath("//div[text()='New']")).click();

		// Enter Opportunity name as 'Sales force Automation by Your Name,Get the text
		// and Store it
		WebElement assignedName = driver.findElement(By.xpath("//input[@name='Name']"));
		assignedName.sendKeys("Salesforce Automation by Goutham");
		assignedName.getText();
		System.out.println("The given opportunity name is" + assignedName);

		// chose close date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("9/24/2021");

		// select Stage
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input")).click();
		Thread.sleep(1000);

		// select Needs Analysis
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();

		// select save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);

		// Get Message Text

		WebElement message = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String actualText = message.getText();
		System.out.println(actualText);

		// verify account is created 
		String Expected = "Salesforce Automation by Goutham";

		if (actualText.contains(Expected)) {
			System.out.println("Account is created successfully");
		} else {
			System.out.println("Account is not created");
		}
	}
}