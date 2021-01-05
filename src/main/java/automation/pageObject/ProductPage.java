package automation.pageObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	@FindBy(how = How.CSS, using = ".product-quantity-tip > span")
	WebElement itemsAvailable;
	
	@FindBy(how = How.CLASS_NAME, using = ".next-btn.next-large.next-btn-primary.buynow")
	WebElement buyButton;
	
	public Integer getAvaliableItems() {
		String items = "";
		String innerHtml = itemsAvailable.getText();
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(innerHtml);
		while (m.find()) {
		    items += m.group();
		}
		return Integer.parseInt(items);
	}

	public void waitForBuyButtonClickeable() {
		try {
			WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(this.buyButton));
		} catch (Exception e) {
			System.out.println("Cannot close dialog: " + e.getMessage());
		}
	}

}
