package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass_POM {
	 public ChromeDriver driver;
		public String filename;
		public WebDriverWait wait;
				
		@Parameters({"url","username","password"})
		@BeforeMethod(alwaysRun = true)
		public void preCondition() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		}

	    @AfterMethod(alwaysRun = true)
	    public void postCondition() throws InterruptedException {
	    	driver.findElement(By.xpath("//span[@class='uiImage']")).click();
	    	driver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")).click();
	    	Thread.sleep(2000);
	    	driver.close();
	    }
	    
	    @DataProvider(name = "fetchData")
		public String[][] sendData() throws IOException {

			ReadExcel re = new ReadExcel();
			return re.readData(filename);
		}	    
	}