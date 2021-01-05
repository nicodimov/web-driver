package automation.pageObject;

import org.openqa.selenium.support.PageFactory;

/***
 * This class is a factory for the pages under test
 * @author nico
 *
 */
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

	public static ProductPage productPage() {
		ProductPage prodPage = new ProductPage();
		PageFactory.initElements(Browser.driver, prodPage);
		return prodPage;
	}
	
}