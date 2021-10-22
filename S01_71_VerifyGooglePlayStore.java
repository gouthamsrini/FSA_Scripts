package Sprint1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S01_71_VerifyGooglePlayStore {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Load URL: https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);
		
		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='tileTitle']//span"));
		for (int i = 0; i < titles.size(); i++) {
			if (titles.get(i).getText().equals("Download SalesforceA")) {
				driver.findElement(By.xpath(
						"//span[text()='Download SalesforceA']/ancestor::div[@class='tileTitle']/following-sibling::div//span[text()='Google Play']"))
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
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		String text = driver.findElement(By.xpath("//h1[@class='AHFaub']")).getText();
		System.out.println("The Actual Text is:" +text);
		
		String text1="SalesforceA";
		
		//assert.assertEquals(text1, text);
		
		boolean enabled = driver.findElement(By.xpath("//button[@class=' LkLjZd ScJHi HPiPcc IfEcue  ']")).isEnabled();
		System.out.println(enabled);	
	}
}