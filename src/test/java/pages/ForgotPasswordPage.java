package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
	
	@FindBy (css = "#sylius_admin_request_password_reset_email")
	private WebElement emailFild;
	@FindBy (css = "[type='submit']")
	private WebElement resetPassBtn;
	@FindBy (css = ".ui.red.pointing.label.sylius-validation-error")
	private WebElement emailNotValid;
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmail (String email) {
		refresh();
		fillText(emailFild, email);
		click(resetPassBtn);
	}
	
	public String eroorMsg () {
		String eroor = getText(emailNotValid);
		return eroor;
	}

}
