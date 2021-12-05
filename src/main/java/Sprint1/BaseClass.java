package Tstng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
      public ChromeDriver driver;
		
    @Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pWord) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	driver = new ChromeDriver(options);
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("username")).sendKeys(uName);
	driver.findElement(By.id("password")).sendKeys(pWord);
	driver.findElement(By.id("Login")).click();
		
	}

    @AfterMethod
    public void postCondition() throws InterruptedException {
    	driver.findElement(By.xpath("//span[@class='uiImage']")).click();
    	driver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")).click();
    	Thread.sleep(2000);
    	driver.close();
    }
}