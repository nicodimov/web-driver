package automation.pageObject;

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

	

}
