package automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	static String url = "http://www.aliexpress.com";
	static String title = "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products - AliExpress";

	@FindBy(how = How.XPATH, using = "/html/body/section/div/div/div/div/div[2]/div/div/img")
	WebElement advDialogButton;

	@FindBy(how = How.XPATH, using = "/html/body/iframe[2]")
	WebElement advIframe;

	@FindBy(how = How.ID, using = "search-key")
	WebElement searchBox;

	@FindBy(how = How.CLASS_NAME, using = "search-button")
	WebElement searchButton;

	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}

	public void tryClosePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(this.advIframe));
			wait.until(ExpectedConditions.elementToBeClickable(this.advDialogButton)).click();
		} catch (Exception e) {
			System.out.println("Cannot close dialog: " + e.getMessage());
		}
	}

	public void waitUntilLoadComplete() throws InterruptedException {
		Browser.waitForPageLoad();
		Thread.sleep(1000);
	}

	public void doSearch(String searchText) {
		Browser.driver.switchTo().parentFrame();
		this.searchBox.sendKeys(searchText);
		this.searchButton.click();
	}

}
