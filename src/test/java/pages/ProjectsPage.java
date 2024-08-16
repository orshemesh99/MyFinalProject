package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends MenuPage{
	
	@FindBy (css = "#criteria_search_type")
	private WebElement searchDD;
	@FindBy (css = "#criteria_search_value")
	private WebElement valueField;
	@FindBy (css = "#criteria_enabled")
	private WebElement enabledDD;
	@FindBy (css = "#criteria_channel")
	private WebElement channelDD;
	@FindBy (css = ".ui.blue.labeled.icon.button")
	private WebElement filterBtn;
	@FindBy (css = ".ui.icon.info.message p")
	private WebElement eroorMsg;
	@FindBy (css = ".ui.labeled.icon.button > .icon.remove")
	private WebElement clearFiltersBtn;
	@FindBy (css = ".ui.sortable.stackable.very.basic.celled.table > tbody > .item")
	private List<WebElement> itemList;
	@FindBy (css = "div.middle.aligned.column > div > div > div > a:nth-child(3)")
	private WebElement simpleProductBtn;

	
	public ProjectsPage(WebDriver driver) {
		super(driver);
	}
	
	public void FilteraBy (String search, String value, String enabled, String channel) {
		selectByValue(searchDD	, search);
		fillText(valueField, value);
		selectByValue(enabledDD, enabled);
		selectByValue(channelDD, channel);
		click(filterBtn);
	}
	
	public String eroorMsg () {
		String eroor = getText(eroorMsg);
		return eroor;
	}
	
	public void clearFilters () {
		click(clearFiltersBtn);
	}
	
	public void clickOnCheckBox (String name) {
//		List<WebElement> itemList = getDriver().findElements(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table > tbody > .item"));
		for (WebElement el : itemList) {
			waitForElementToBevisibility(el);
			WebElement title = el.findElement(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table > tbody > tr > td:nth-child(3)"));
			if (getText(title).equalsIgnoreCase(name)) {
				WebElement checkbox = el.findElement(By.cssSelector("table > tbody >tr [type='checkbox']"));
				click(checkbox);
				break;
			}
		}
	}
	
	public void editItem (String name) {
//		List<WebElement> itemList = getDriver().findElements(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table > tbody > .item"));
		for (WebElement el : itemList) {
			waitForElementToBevisibility(el);
			WebElement list = el.findElement(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table > tbody > tr > td:nth-child(3)"));
			if (getText(list).equalsIgnoreCase(name)) {
				WebElement edit = el.findElement(By.cssSelector("div:nth-child(1) > a:nth-child(2)"));
				click(edit);
				break;
			}
		}
	}
	
	public void addSimpleProduct () {
		click(simpleProductBtn);
	}
}
