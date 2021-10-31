package crossBrowsers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CB_BaseClass {
      public WebDriver driver;
		
    @Parameters({"url","username","password","browser"})
	@BeforeMethod
	public void preCondition(String url, String uName, String pWord, String browserName) {

	if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		driver= new FirefoxDriver(options);
	}
	
	else if(browserName.equalsIgnoreCase("chrome"))
			{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
			}
	
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