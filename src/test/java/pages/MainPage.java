package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import groovy.transform.Final;

public class MainPage extends MenuPage{
	
	@FindBy (css = ".ui.floated.simple.dropdown.item > .dropdown.icon")
	WebElement johnBtn;
	@FindBy (css = ".menu.transition.visible .item")
	WebElement myAccountBtn;
	@FindBy (css = "#sylius-logout-button")
	private WebElement logOutBtn;
	
	public MainPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void changeMyAccount () {
		click(johnBtn);
		click(myAccountBtn);
	}
	
	public void logOut () {
		click(johnBtn);
		click(logOutBtn);
	}
	}

