package automation.find2ndProduct;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import automation.pageObject.Browser;
import automation.pageObject.HomePage;
import automation.pageObject.Pages;

public class FindProductsTest {
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver","../chromedriver");
	}
	
	@Before
	public void setup() {
		Browser.create();
	}
	
	@Test
	public void canGoToHomePage() {
		HomePage aliexpressHome = Pages.homePage();
		aliexpressHome.goTo();
		aliexpressHome.waitUntilLoadComplete();
		aliexpressHome.tryClosePopup();
		Assert.assertTrue(Pages.homePage().isAt());
	}
	
	@Test
	public void canSearchProduct() {
		this.canGoToHomePage();
		Pages.homePage().doSearch("iphone");
		Pages.resultsPage().tryClosePopup();
		Assert.assertTrue(Pages.resultsPage().isListTypeButtonPresent());
	}
	
	@Test
	public void canGoTo2ndResultsPage() {
		this.canSearchProduct();
		Pages.resultsPage().navigateBottom();
		Pages.resultsPage().navigateToNextPage();
		String pageNumber = Pages.resultsPage().getPageNavigator().getSelectedPageNumber();
		Assert.assertEquals("2", pageNumber);
	}
	
	@Test
	public void SecondProductShouldHaveAtLeastOneItem() throws InterruptedException {
		this.canGoTo2ndResultsPage();
		Pages.resultsPage().clickNthResult(2);
		Browser.switchToTab(1);
		Integer available = Pages.productPage().getAvaliableItems();
		Assert.assertTrue(available > 1);
	}
	
	@After
	public void tearDown() {
		Browser.close();
	}

//	@AfterClass
//	public static void cleanUp() {
//		Browser.close();
//	}
}
