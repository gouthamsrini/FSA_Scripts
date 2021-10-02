package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_49_EditWorkTypeGroup {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;

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

		// select work type groups
		WebElement workTypeGroup = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		js.executeScript("arguments[0].scrollIntoView();", workTypeGroup);
		Thread.sleep(3000);
		workTypeGroup.click();

		// Click on the Work Type Group tab
		//Thread.sleep(3000);
		//.findElement(By.xpath("//span[text()='Work Type Groups']")).click();

		// click search and type Sales force Automation by your name
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		search.sendKeys("Salesforce Automation by Goutham");
		search.sendKeys(Keys.ENTER);

		// click dropdown and select edit
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']"))
				.click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// enter description as "Automation"
		String expDescription = "Automation";
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("Automation");

		// select drop down as "Capacity"
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Default']")).click();
		driver.findElement(By.xpath("//a[@title='Capacity']")).click();

		// click save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		// Click on 'Sales force Automation by Your Name'and Verify Description as 'Automation'
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@title='Salesforce Automation by Goutham']")).click();
		WebElement actualDescText = driver.findElement(By.xpath("//span[@class='uiOutputTextArea']"));
		String descPresent = actualDescText.getText();
		System.out.println("Description is :" + descPresent);

		if (descPresent.contains(expDescription)) {
			System.out.println("Work Type Group is edited Successfully");
		} else {
			System.out.println("Work Type Group is not edited");
		}
	}
}