package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_44_EditIndividuals {

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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Enter 'Individuals'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
		Thread.sleep(2000);

		// select Individuals
		driver.findElement(By.xpath("//mark[text()='Individuals']")).click();

		// search with last name
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@class='slds-input']"));
		search.sendKeys("srinivasan");
		search.sendKeys(Keys.ENTER);

		// select 'Edit' option
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']"))
				.click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// select Salutation as "Mr"
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();

		// input first name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Goutham");

		// click save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);

		// verify the individual name is edited
		WebElement msgtxt = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		Thread.sleep(1000);
		String individualName = msgtxt.getText();
		System.out.println("Individual name is :" + individualName);

		// Verify first name
		String Expected = "Goutham";

		// check individual name is correct as per given input
		if (individualName.contains(Expected)) {
			System.out.println("Name is edited successfully");
		} else {
			System.out.println("Name is not edited");
		}
	}
}