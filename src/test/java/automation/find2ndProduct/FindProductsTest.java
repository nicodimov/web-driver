package automation.find2ndProduct;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.BrowserType;

import automation.pageObject.Browser;
import automation.pageObject.Pages;

public class FindProductsTest {
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
	}
	
	@Before
	public void setup() {
		Browser.create(BrowserType.FIREFOX);
	}
	
	@Test
	public void canGoToHomePage() {
		try {
			Pages.homePage().goTo();
			Pages.homePage().waitUntilLoadComplete();
			Pages.homePage().tryClosePopup();
			Assert.assertTrue(Pages.homePage().isAt());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void canSearchProduct() {
		try {
			this.canGoToHomePage();
			Browser.switchToDefaultContet();
			Pages.homePage().doSearch("iphone");
			Pages.resultsPage().tryClosePopup();
			Assert.assertTrue(Pages.resultsPage().isListTypeButtonPresent());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void canGoTo2ndResultsPage() {
		try {
			this.canSearchProduct();
			Browser.navigateBottom();
			Pages.resultsPage().navigateToNextPage();
			String pageNumber = Pages.resultsPage().getPageNavigator().getSelectedPageNumber();
			Assert.assertEquals("2", pageNumber);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void SecondProductShouldHaveAtLeastOneItem() {
		try {
			this.canGoTo2ndResultsPage();
			Pages.resultsPage().clickNthResult(2);
//			if(Browser.selectedBrowser == BrowserType.FIREFOX) Browser.close();
			Browser.switchToDefaultContet();
			Browser.switchToActiveElement();
			Browser.switchToTab(1);
			Integer available = Pages.productPage().getAvaliableItems();
			Assert.assertTrue(available > 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@After
	public void tearDown() {
		Browser.close();
	}

	@AfterClass
	public static void cleanUp() {
		try {
			Browser.quit();
		} catch (Exception e) {
			// do nothing
		}
	}
}
