package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy (css = ".ui.right.floated.buttons")
	private WebElement createBtn;
	@FindBy (css = ".sylius-admin-menu  a ")
	private List<WebElement> list;
	@FindBy (css = ".ui.icon.positive.message.sylius-flash-message p")
	private WebElement successMsg;
	@FindBy (css = ".ui.icon.negative.message p")
	private WebElement errorMsg;
	
	public MenuPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void create () {
		waiting(400);
		click(createBtn);
	}
	
	public void ChoiceFromLeftSideMenu (String num) {
//		List<WebElement> list = getDriver().findElements(By.cssSelector(".sylius-admin-menu  a "));
		for (WebElement el : list) {
			WebElement title = el.findElement(By.cssSelector(".sylius-admin-menu  a .sidebar-badge"));
			if (getText(title).equals(num)) {
			click(title);
			break;
			}
		}	
	}
	
	public String getSuccessMsg () {
		String s = getText(successMsg);
		return s;
	}
	
	public String getErrorMsg () {
		String s = getText(errorMsg);
		return s;
	}
}
