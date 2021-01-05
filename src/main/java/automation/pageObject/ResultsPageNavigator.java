package automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPageNavigator {

	@FindBy(how = How.CSS, using = ".next-current")
	WebElement currentPage;
	
	@FindBy(how = How.CSS, using = ".next-btn.next-medium.next-btn-normal.next-pagination-item.next-next")
	WebElement nextButton;
	
	
	public String getSelectedPageNumber() {
		return currentPage.getText();
		
	}

	public void clickNextButton() {
		this.nextButton.click();
	}
	


	
}
