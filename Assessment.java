package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// click viewAll
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Select Service Console
		driver.findElement(By.xpath(
				"//p[@title='(Lightning Experience) Lets support agents work with multiple records across customer service channels on one screen']"))
				.click();
		Thread.sleep(4000);

		// click Home
		driver.findElement(By.xpath("(//*[@class='slds-button__icon'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		Thread.sleep(3000);

		// get the amounts
		String closedAmt = driver.findElement(By.xpath("(//span[@class='metricAmount uiOutputText'])[1]")).getText();
		System.out.println(closedAmt);
		String openAmt = driver.findElement(By.xpath("(//span[@class='metricAmount uiOutputText'])[2]")).getText();
		System.out.println(openAmt);

		String replaceAll1 = closedAmt.replaceAll("\\D", "");
		String replaceAll2 = openAmt.replaceAll("\\D", "");

		int clsAmt = Integer.parseInt(replaceAll1);
		int opnAmt = Integer.parseInt(replaceAll2);
		int Total = clsAmt + opnAmt;
		System.out.println("Total Category Count is : " + Total);

		if (Total < 10000) {
			driver.findElement(By.xpath("//*[@data-key='edit']")).click();
			WebElement curCode = driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']"));
			curCode.click();
			curCode.sendKeys("10000");
			driver.findElement(By.xpath("//span[text()='Save']")).click();
		}

		// Select Dashboards from DropDown
		driver.findElement(By.xpath("(//*[@class='slds-button__icon'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Dashboards']")).click();

		// click new dashboard
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		Thread.sleep(5000);

		// ENter Details
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Goutham_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(3000);

		// click done 
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		// Verify the Dash board is Created
		String actualText = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		String expectedTxt = "Goutham_Workout";
		if (actualText.contains(expectedTxt)) {
			System.out.println("Dashboard is created successfully");
		} else {
			System.out.println("Dashboard is not created");
		}

		// click subscribe
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();

		// Select Frequency as "Daily"
		driver.findElement(By.xpath("//span[text()='Daily']")).click();

		// Time as 10:00 AM
		WebElement dd = driver.findElement(By.id("//*[@id='time']"));
		Select dropdown = new Select(dd);
		dropdown.selectByVisibleText("10:00 AM");

		// click save
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		// Verify Toast Message
		WebElement msgtxt = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		Thread.sleep(1000);
		String subscriptionMessage = msgtxt.getText();
		System.out.println(subscriptionMessage);
		Thread.sleep(7000);

		driver.findElement(By.xpath("(//*[@class='slds-button__icon'])[4]")).click();
		
		//select private dashboards
		driver.findElement(By.xpath("//a[@title='Private Dashboards']")).click();

	}

}