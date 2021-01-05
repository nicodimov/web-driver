package automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	static String url = "http://www.aliexpress.com";
	static String title = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products  - AliExpress";
	
	@FindBy(how = How.XPATH, using = "/html/body/section/div/div/div/div/div[2]/div/div/img")
	WebElement advDialogButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/iframe[2]")
	WebElement advIframe;
	
	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}
	
	public void tryClosePopup() {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(this.advIframe));
		wait.until(ExpectedConditions.elementToBeClickable(this.advDialogButton)).click();
	}

	public void waitUntilLoadComplete() {
		Browser.waitForPageLoad();
	}

}
