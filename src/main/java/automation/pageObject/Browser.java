package automation.pageObject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	static WebDriver driver;
	public static String selectedBrowser;

	public static void create(String browser) {
		switch (browser) {
		case BrowserType.GOOGLECHROME:
			selectedBrowser = BrowserType.GOOGLECHROME;
			driver = new ChromeDriver();
			break;
		case BrowserType.FIREFOX:
			selectedBrowser = BrowserType.FIREFOX;
			driver = new FirefoxDriver();
			break;
		case BrowserType.SAFARI:
			selectedBrowser = BrowserType.FIREFOX;
			driver = new SafariDriver();
			break;
		}
		driver.manage().window().maximize();
	}

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
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
				.equals("complete"));
	}

	public static void scrollElement(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target);
		action.perform();
	}

	public static void navigateBottom() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, (document.body.scrollHeight - 2000));");
	}

	public static void switchToTab(int tabNumber) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabNumber));
		} catch (Exception e) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		}
	}
	
	public static void switchToActiveTab() {
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }
		}
	}
	
	public static void switchToActiveElement() {
		driver.switchTo().activeElement();
	}

	public static void switchToDefaultContet() {
		driver.switchTo().defaultContent();
	}
}
