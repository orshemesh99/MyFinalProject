package pages;

import java.io.WriteAbortedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy (css = "#_username")
	private WebElement userNameFild;
	@FindBy (css = "#_password")
	private WebElement passwordFild;
	@FindBy (css = "[type='submit']")
	private WebElement loginBtn;
	@FindBy (css = "div.ui.left.aligned.basic.segment  p")
	private WebElement errorMsg;
	@FindBy (css = "body a")
	private WebElement forgotPasswordBtn;
	@FindBy (css = "div.ui.icon.positive.message.sylius-flash-message p")
	private WebElement SuccessMsg;
	@FindBy (css = "[type='checkbox']")
	private WebElement rememberMeBtn;

	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login (String user , String password) {
		refresh();
		fillText(userNameFild, user);
		fillText(passwordFild, password);
		click(loginBtn);
	}
	
	public String EroorMsg () {
		String msg = getText(errorMsg);
		return msg;
	}
	
	public String SuccessResetMsg () {
		String msg = getText(SuccessMsg);
		return msg;
	}
	
	public void forgogPassword () {
		click(forgotPasswordBtn);
	}
	
	public void rememberMe () {
		click(rememberMeBtn);
	}

}
