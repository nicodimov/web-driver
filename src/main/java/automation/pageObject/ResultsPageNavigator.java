package automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPageNavigator {

	@FindBy(how = How.CSS, using = "button.next-pagination-item:nth-child(2)")
	WebElement currentPage;
	
	public String getSelectedPageNumber() {
		return currentPage.getText();
		
	}

	
}
