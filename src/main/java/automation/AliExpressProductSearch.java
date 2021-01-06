package automation;

import automation.pageObject.HomePage;
import automation.pageObject.Pages;

public class AliExpressProductSearch {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","../chromedriver");
		
		HomePage aliexpressHome = Pages.homePage();
		aliexpressHome.goTo();
		aliexpressHome.waitUntilLoadComplete();
		aliexpressHome.tryClosePopup();
	
	}

}
