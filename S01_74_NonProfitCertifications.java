package Sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_74_NonProfitCertifications {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);

		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='tileTitle']//span"));
		for (int i = 0; i < titles.size(); i++) {
			if (titles.get(i).getText().equals("See System Status")) {
				driver.findElement(By.xpath(
						"//span[text()='See System Status']/ancestor::div[@class='tileTitle']/following-sibling::div//span[text()='Get Started']"))
						.click();
				break;
			}
			if ((i + 1) % 3 == 0) {
				driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]")).click();
				Thread.sleep(5000);
			}

		}

		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		for (String windows : windowHandle) {
			System.out.println(windows);
		}

		List<String> winList = new ArrayList<String>(windowHandle);
		// winList.get(1);

		driver.switchTo().window(winList.get(1));
		driver.findElement(By.xpath("//div[@id='dropdown-list']")).click();

		// Select Trust Compliance from the dropdown
		driver.findElement(By.xpath("//p[contains(text(),'  Compliance')]")).click();

		// click on show filters
		driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_neutral')])[2]")).click();

		// Select "Nonprofit" under INDUSTRIES
		driver.findElement(By.xpath("//label[@for='Nonprofit']")).click();

		// Verify the 20 Certificates that are Nonprofit only should be displayed
		Thread.sleep(2000);
		List<WebElement> certificateCount = driver
				.findElements(By.xpath("//a[contains(@class,'slds-box_link slds-media slds-card tile mb3')]"));
		int totalCount = certificateCount.size();
		System.out.println("Count of Non Profit Certificates are :" +totalCount);
		
		//Verify Clear Filter option is displayed
		WebElement clearFilter = driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral')]"));
		boolean clearFilterOption = clearFilter.isDisplayed();
		System.out.println("Clear Filter Option is displayed: "+clearFilterOption);

	}
}