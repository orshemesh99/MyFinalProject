package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProductPage extends MenuPage{
	
	// create product
	@FindBy (css = "#sylius_product_code")
	private WebElement codeFiled;
	@FindBy (css = "#sylius_product_enabled")
	private WebElement enabledBtn;
	@FindBy (css = "#sylius_product_variant_shippingRequired")
	private WebElement shippingRequiredBtn;
	@FindBy (css = "#sylius_product_variant_channelPricings_HOME_WEB_price")
	private WebElement priceFiled;
	@FindBy (css = "#sylius_product_variant_channelPricings_HOME_WEB_originalPrice")
	private WebElement originalPriceFiled;
	@FindBy (css = "#sylius_product_variant_channelPricings_HOME_WEB_minimumPrice")
	private WebElement minimumPrice;
	@FindBy (css = ".ui.styled.fluid.accordion > [data-locale='en_US']")
	private WebElement usaBtn;
	@FindBy (css = ".ui.styled.fluid.accordion > [data-locale='es_ES']")
	private WebElement spainBtn;
	@FindBy (css = "#sylius_product_translations_es_ES_name")
	private WebElement nameField;
	@FindBy (css = "#sylius_product_translations_es_ES_slug")
	private WebElement slugFiled;
	@FindBy (css = "#sylius_product_translations_es_ES_description")
	private WebElement descriptionFiled;
	@FindBy (css = "#sylius_product_translations_es_ES_metaKeywords")
	private WebElement metaKeywordsFiled;
	@FindBy (css = "#sylius_product_translations_es_ES_metaDescription")
	private WebElement metaDescriptionFiled;
	@FindBy (css = "#sylius_product_translations_es_ES_shortDescription")
	private WebElement shortDescriptionFiled;
	@FindBy (css = "#sylius_product_variant_taxCategory")
	private WebElement taxCategoryDD;
	@FindBy (css = "#sylius_product_variant_width")
	private WebElement widthFiled;
	@FindBy (css = "#sylius_product_variant_height")
	private WebElement heightFiled;
	@FindBy (css = "#sylius_product_variant_depth")
	private WebElement depthFiled;
	@FindBy (css = "#sylius_product_variant_weight")
	private WebElement weightFiled;
	@FindBy (css = ".ui.labeled.icon.primary.button")
	private WebElement finishBtn;
	@FindBy (css = ".ui.icon.negative.message  p")
	private WebElement errorMsg;
	@FindBy (css = "div.ui.stackable.grid.sylius-tabular-form > div.three.wide.column  span")
	private WebElement numOfErrors;
	@FindBy (css = "#sylius_product_translations_en_US_name")
	private WebElement nameNewField;
	@FindBy (css = "#sylius_product_translations_en_US_slug")
	private WebElement slugNewFiled;
	@FindBy (css = ".ui.icon.positive.message.sylius-flash-message .content")
	private WebElement successMsg;
	
	public NewProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewProduct (String code, String price, String originalP, String miniP, String name, String slug, String description, String metaKeywords, String metaDescription, String shortDescription, String taxCategory, String width, String height, String depth, String weight) {
		fillText(codeFiled, code);
//		click(enabledBtn);
//		click(shippingRequiredBtn);
		fillText(priceFiled, price);
		fillText(originalPriceFiled, originalP);
		fillText(minimumPrice, miniP);
		click(usaBtn);
		click(spainBtn);
		fillText(nameField, name);
		fillText(slugFiled, slug);
		fillText(descriptionFiled, description);
		fillText(metaKeywordsFiled, metaKeywords);
		fillText(metaDescriptionFiled, metaDescription);
		fillText(shortDescriptionFiled, shortDescription);
		selectByValue(taxCategoryDD, taxCategory);
		fillText(widthFiled, width);
		fillText(heightFiled, height);
		fillText(depthFiled, depth);
		fillText(weightFiled, weight);
		click(finishBtn);
	}
	
	public void addProductsInEnglish (String code, String name, String slug) {
		fillText(codeFiled, code);
		fillText(nameNewField, name);
		fillText(slugNewFiled, slug);
		click(finishBtn);
	}
	
	public String getErrorMsg () {
		String error = getText(errorMsg);
		return error;
	}
	
	public String getSuccessMsg () {
		String success = getText(successMsg);
		return success;
	}
	
	public int getNumOfErrors () {
		String s = getText(numOfErrors);
		int i = Integer.parseInt(s);
		return i;
	}
}
