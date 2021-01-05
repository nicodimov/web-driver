package automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	@FindBy(how = How.CLASS_NAME, using = "next-dialog-close")
	WebElement advDialogButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/iframe[1]")
	WebElement advIframe;
	
	@FindBy(how = How.CLASS_NAME, using = "search-button")
	WebElement searchButton;
	
	@FindBy(how = How.CLASS_NAME, using = "teletext-subject")
	WebElement bottomText;
	
	@FindBy(how = How.CLASS_NAME, using = "price-text")
	WebElement priceText; 
	
	@FindBy(how = How.CSS, using = ".list-items > div:nth-child(1) > li:nth-child(2)")
	
	ResultsPageNavigator pageNavigator;
	
	
	public void tryClosePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(this.advDialogButton)).click();
		} catch (Exception e) {
			System.out.println("Cannot close dialog: " + e.getMessage());
		}
	}
	
	public void navigateToNextPage() {
		this.getPageNavigator().clickNextButton();
	}

	public ResultsPageNavigator getPageNavigator() {
		ResultsPageNavigator rpn = new ResultsPageNavigator();
		PageFactory.initElements(Browser.driver, rpn);
		return rpn;
	}
	
	public boolean isListTypeButtonPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(this.priceText, "Price"));
			return true;
		} catch (Exception e) {
			System.out.println("Cannot close dialog: " + e.getMessage());
		}
		return false;
	}

	public void navigateBottom() {
		Browser.scrollElement(bottomText);
	}

	public void clickNthResult(int order) throws InterruptedException {
		String cssSelector = String.format(".list-items > div:nth-child(1) > li:nth-child(%d)", order);
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();;
	}

	public boolean isResultClickeable() {
		String cssSelector = String.format(".list-items > div:nth-child(1) > li:nth-child(%d)", 1);
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
			wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(cssSelector)));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
			return true;
		} catch (Exception e) {
			System.out.println("Cannot close dialog: " + e.getMessage());
		}
		return false;
	}

	

}
