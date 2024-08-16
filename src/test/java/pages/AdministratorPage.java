package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministratorPage extends MenuPage{
	@FindBy (css = "#sylius_admin_user_username")
	private WebElement userNameFiled;
	@FindBy (css = "#sylius_admin_user_plainPassword")
	private WebElement passwordFiled;
	@FindBy (css = "#sylius_admin_user_email")
	private WebElement emailFiled;
	@FindBy (css = "#sylius_admin_user_localeCode")
	private WebElement localeDD;
	@FindBy (css = "#sylius_save_changes_button")
	private WebElement saveBtn;
	@FindBy (css = ".ui.red.pointing.label.sylius-validation-error")
	private WebElement errorMsg;
	
	public AdministratorPage(WebDriver driver) {
		super(driver);
	}
	
	public void editMyAdminDetails (String name, String pass, String email, String locale ) {
		fillText(userNameFiled, name);
		fillText(passwordFiled, pass);
		fillText(emailFiled, email);
		selectByValue(localeDD, locale);
		click(saveBtn);
	}
	
	
	
	public String getErrorEmailMsg () {
	String s = getText(errorMsg);
	return s;
	}
}
