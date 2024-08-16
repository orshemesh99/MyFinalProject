package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends MenuPage{
	@FindBy (css = "#sylius_customer_firstName")
	private WebElement firstNameFiled;
	@FindBy (css = "#sylius_customer_lastName")
	private WebElement lastNameFiled;
	@FindBy (css = "#sylius_customer_email")
	private WebElement emailFiled;
	@FindBy (css = "#sylius_customer_group")
	private WebElement groupDD;
	@FindBy (css = "#sylius_customer_gender")
	private WebElement genderDD;
	@FindBy (css = "#sylius_customer_birthday")
	private WebElement birthdaylFiled;
	@FindBy (css = "#sylius_customer_phoneNumber")
	private WebElement phoneNumberFiled;
	@FindBy (css = "[type='submit']")
	private WebElement createBtn;
	// delete customer
	@FindBy (css = ".ui.red.labeled.icon.button")
	private WebElement deleteBtn;
	@FindBy (css = ".ui.green.ok.inverted.button")
	private WebElement yesBtn;
	// right customer
	@FindBy (css = ".ui.fluid.card .header")
	private WebElement rightCustomer;
	
	public CustomersPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewCustomers (String firstName, String lastName, String email, String group, String genderPool,String birthday, String phoneNumber) {
		refresh();
		fillText(firstNameFiled, firstName);
		fillText(lastNameFiled, lastName);
		fillText(emailFiled, email);
		selectByValue(groupDD, group);
		selectByValue(genderDD, genderPool);
		fillText(birthdaylFiled, birthday);
		fillText(phoneNumberFiled, phoneNumber);
		click(createBtn);
	}
	
	public void CustomerList (String name) {
			List<WebElement> list = getDriver().findElements(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table .item"));
			for (WebElement el : list) {
				WebElement lastName = el.findElement(By.cssSelector("table > tbody > tr > td:nth-child(2)"));
				if (getText(lastName).equals(name)) {
					WebElement show = el.findElement(By.cssSelector("tbody > tr > td:nth-child(8) > div > a:nth-child(2)"));
					click(show);
				break;
				}
			}	
		}
	public void deleteCustomer () {
		click(deleteBtn);
		click(yesBtn);
	}
	
	public String thisIsTheRightCustomer () {
		String rc = getText(rightCustomer);
		return rc;
	}
	}
