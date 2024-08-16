package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountriesPage extends MenuPage {
	
	@FindBy (css = "#criteria_code_type" )
	private WebElement codeDD;
	@FindBy (css = "#criteria_code_value" )
	private WebElement valueFiled;
	@FindBy (css = "#criteria_enabled" )
	private WebElement enabledDD;
	@FindBy (css = "[type='submit']")
	private WebElement filterBtn;
	
	
	public CountriesPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void  FiltersCountryBy (String code, String value, String enable) {
		
		selectByValue(codeDD, code);
		fillText(valueFiled, value);
		selectByValue(enabledDD, enable);
		click(filterBtn);
	}
	
	public void chooseCountryFromList (String name) {
		List<WebElement> list = getDriver().findElements(By.cssSelector(".ui.sortable.stackable.very.basic.celled.table .item"));
		for (WebElement el : list) {
			WebElement title = el.findElement(By.cssSelector("tbody > tr > td:nth-child(2)"));
			WebElement edit = el.findElement(By.cssSelector("tbody > tr > td > div"));	
			if (getText(title).equalsIgnoreCase(name)) {
			click(edit);
			break;
			}
			
		}
		
		
	}

}
