package automation.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
//	static WebDriver driver = new FirefoxDriver();
	static WebDriver driver = new ChromeDriver();
	
	public static void goTo(String url) {
		driver.get(url);
	}

	public static String title() {
		return driver.getTitle();
	}

	public static void close() {
		driver.close();
	}

	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
	}
}
