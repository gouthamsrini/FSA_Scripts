package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_65_AlertMessageforWorkType {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter Username
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
		String worktype = "Bootcamp";
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(worktype);

		// click save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		// check alert message is displayed
		Thread.sleep(2000);
		WebElement durationAlert = driver.findElement(By.xpath("//li[@class='form-element__help']"));
		String alertMsg = durationAlert.getText();
		System.out.println("Alert Message displayed for Estimated duration :" + alertMsg);
	}
}