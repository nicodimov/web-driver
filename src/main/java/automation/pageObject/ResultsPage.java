package automation.pageObject;

import java.io.Console;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[2]/div/a")
	WebElement advDialogButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/iframe[1]")
	WebElement advIframe;
	
	@FindBy(how = How.CSS, using = "next-btn next-medium next-btn-normal next-pagination-item next-next")
	WebElement nextButton;
	
	ResultsPageNavigator pageNavigator;
	
	
	public void tryClosePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(this.advIframe));
			wait.until(ExpectedConditions.elementToBeClickable(this.advDialogButton)).click();
		} catch (Exception e) {
			System.out.println("Cannot find element: " + e.getMessage());
		}
	}
	
	public void navigateToNextPage() {
		this.nextButton.click();
	}

	public ResultsPageNavigator getPageNavigator() {
		ResultsPageNavigator rpn = new ResultsPageNavigator();
		PageFactory.initElements(Browser.driver, rpn);
		return rpn;
	}

}
