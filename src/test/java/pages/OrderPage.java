package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends MenuPage{
	// edit address
	@FindBy (css = ".ui.attached.segment a")
	private WebElement editAddressBtn;
	@FindBy (css = "#sylius_order_shippingAddress_firstName")
	private WebElement firstNameFiled;
	@FindBy (css = "#sylius_order_shippingAddress_lastName")
	private WebElement lastNameFiled;
	@FindBy (css = "#sylius_order_shippingAddress_company")
	private WebElement companyFiled;
	@FindBy (css = "#sylius_order_shippingAddress_street")
	private WebElement addressFiled;
	@FindBy (css = "#sylius_order_shippingAddress_countryCode")
	private WebElement countryFiled;
	@FindBy (css = "#sylius_order_shippingAddress_city")
	private WebElement cityFiled;
	@FindBy (css = "#sylius_order_shippingAddress_postcode")
	private WebElement postcodeFiled;
	@FindBy (css = "#sylius_save_changes_button")
	private WebElement saveBtn;
	// SuccessMsg

	// complete order
	@FindBy (css = ".ui.icon.labeled.tiny.blue.fluid.loadable.button")
	private WebElement completeBtn;
	// order price
	@FindBy (css = "#total")
	private WebElement OrderPrice;
	// history of the order
	@FindBy (css = ".six.wide.right.aligned.column a ")
	private WebElement historyBtn;
	// return 
	@FindBy (css = ".four.wide.right.aligned.column a")
	private WebElement returnBtn;

	public OrderPage(WebDriver driver) {
		super(driver);

	}
	public void editShippingAddress (String firstName, String lastName, String company, String address, String country, String city, String postcode) {
		click(editAddressBtn);
		fillText(firstNameFiled, firstName);
		fillText(lastNameFiled, lastName);
		fillText(companyFiled, company);
		fillText(addressFiled, address);
		selectByValue(countryFiled, country);
		fillText(cityFiled, city);
		fillText(postcodeFiled, postcode);
		click(saveBtn);
	}

	public void completeOrder () {
		click(completeBtn);
	}

	public String getPriceOfOrder () {
		String price = getText(OrderPrice);
		price.replace("€", "");
		return price;
	}

	public void historyOfTheOrder () {
		click(historyBtn);
	}

	public void back () {
		waiting(1500);
		click(returnBtn);
	}
}
