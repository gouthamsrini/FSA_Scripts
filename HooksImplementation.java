package stepsDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImplementation extends BaseClass {

	//@Before
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	//@After
	public void postCondition() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='uiImage']")).click();
    	driver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")).click();
    	Thread.sleep(2000);
    	driver.close();

	}

}
