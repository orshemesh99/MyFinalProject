package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCountryPage  extends MenuPage{
	
	@FindBy (css = "#sylius_country_code")
	private WebElement countryNameDD;
	@FindBy (css = ".ui.labeled.icon.button .plus.square.outline.icon")
	private WebElement addProvincesBtn;
	@FindBy (css = "#sylius_country_provinces_0_code")
	private WebElement provincesCodeFiled;
	@FindBy (css = "#sylius_country_provinces_0_name")
	private WebElement provincesnNameFiled;
	@FindBy (css = "#sylius_country_provinces_0_abbreviation")
	private WebElement provincesAbbreviationFiled;
	@FindBy (css = "[type='submit']")
	private WebElement createBtn;
	@FindBy (css = "div.ui.stackable.two.column.grid a:nth-child(3)")
	private WebElement CountriesBtn;
	@FindBy (css = ".ui.red.labeled.icon.button i")
	private WebElement deleteBtn;
	@FindBy (css = "#sylius_save_changes_button")
	private WebElement saveBtn;

	public NewCountryPage(WebDriver driver) {
		super(driver);
	}
	
public void createNewCountry (String countryName, String provincesCode, String provincesName, String provincesAbbreviation ) {
		
		selectByValue(countryNameDD, countryName);
		click(addProvincesBtn);
		fillText(provincesCodeFiled, provincesCode);
		fillText(provincesnNameFiled, provincesName);
		fillText(provincesAbbreviationFiled, provincesAbbreviation);
		click(createBtn);	
	}

	public void returnToCountryList () {
		click(CountriesBtn);
	}
	
	public void deleteProvinces () {
		click(deleteBtn);
		click(saveBtn);
	}

}
