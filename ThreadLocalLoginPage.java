package threadLocalPages;

import org.openqa.selenium.By;
import base.BaseTest;

public class ThreadLocalLoginPage extends BaseTest {
	
	public ThreadLocalLoginPage enterUserName(String uName) {
		remoteWebDriver.get().findElement(By.id("username")).sendKeys(uName);
		return this;
	}
    
	public ThreadLocalLoginPage enterPassword(String pWord) {
		remoteWebDriver.get().findElement(By.id("password")).sendKeys(pWord);
		return this;
	}
	
	public ThreadLocalHomePage clickLoginButton() {
		remoteWebDriver.get().findElement(By.id("Login")).click();
		return new ThreadLocalHomePage();
	}
}