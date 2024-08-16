package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShipmentsPage extends MenuPage {
	@FindBy (css = ".sylius-admin-menu-search-input")
	private WebElement searchFiled;
	@FindBy (css = "div:nth-child(2) > div.menu > a:nth-child(3)")
	private WebElement shipmentsBtn;
	@FindBy (css = "#criteria_state")
	private WebElement StateDD;
	@FindBy (css = "#criteria_channel")
	private WebElement ChannelDD;
	@FindBy (css = "#criteria_method")
	private WebElement ShippingMethodDD;
	@FindBy (css = ".ui.blue.labeled.icon.button")
	private WebElement filterBTN;
	@FindBy (css = ".ui.icon.info.message .content")
	private WebElement infoMsg;
	@FindBy (css = ".content.active a")
	private WebElement clearBtn;

	public ShipmentsPage(WebDriver driver) {
		super(driver);
	}
	
	public void SearchAndSelectShipmentsInMenu (String search) {
		fillText(searchFiled, search);
		waiting(300);
		click(shipmentsBtn);
	}
	
	public void FilterShipmentsBy (String state, String channel, String shipingMethod) {
		selectByValue(StateDD, state);
		selectByValue(ChannelDD, channel);
		selectByValue(ShippingMethodDD, shipingMethod);
		click(filterBTN);
	}
	
	public String getInfoMsg () {
		String info = getText(infoMsg);
		return info;
	}
	
	public void clearFilters () {
		click(clearBtn);
	}
	
	public void SelectShipmentBySerialOrder (String num) {
		List<WebElement> area = getDriver().findElements(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table tbody .item"));
		for (WebElement el : area) {
			WebElement order = el.findElement(By.cssSelector("tbody > tr > td > a"));
			if (getText(order).equals(num)) {
			click(order);	
			break;
			}
		}	
	}
}
