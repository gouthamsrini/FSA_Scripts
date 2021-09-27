package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_61_CreateNewWorkType {

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

		// Enter 'Work Types'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Work Types");
		Thread.sleep(2000);

		// select work types
		driver.findElement(By.xpath("//mark[text()='Work Types']")).click();

		// Click New
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='New']"))).click();

		// Enter Text as 'Salesforce Project'
		String worktype = "Salesforce Project";
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(worktype);
		System.out.println("Input Text given is :" + worktype);

		// Enter Description as 'Specimen'
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Specimen");

		// Enter New Operation hours
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("UK Shift");
		driver.findElement(By.xpath("(//a[@aria-required='true'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='(GMT+02:00) Central European Summer Time (Europe/Paris)']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();

		// Enter Duration
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("7");

		// click save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		// verify the created message
		WebElement msgtxt = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		Thread.sleep(1000);
		String actualMsg = msgtxt.getText();
		System.out.println("Message created is :" + actualMsg);

		// Verify work type is created
		String Expected = "Salesforce Project";

		if (actualMsg.contains(Expected)) {
			System.out.println("Worktype is created successfully");
		} else {
			System.out.println("Worktype is not created");
		}

		// close browser
		Thread.sleep(3000);
		driver.close();
	}
}