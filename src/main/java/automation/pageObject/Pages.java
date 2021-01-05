package automation.pageObject;

import org.openqa.selenium.support.PageFactory;

public class Pages {

	public static HomePage homePage() {
		HomePage homePage = new HomePage();
		PageFactory.initElements(Browser.driver, homePage);
		return homePage;
	}

	public static ResultsPage resultsPage() {
		ResultsPage resultPage = new ResultsPage();
		PageFactory.initElements(Browser.driver, resultPage);
		return resultPage;
	}
	
}