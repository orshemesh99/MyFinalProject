package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends MenuPage{
	@FindBy (css = ".three.wide.column a:nth-child(5)")
	private WebElement mediaBtn;
	@FindBy (css = "#sylius_product_images  > div > div > a")
	private WebElement deleteBtn;
	@FindBy (css = "#sylius_save_changes_button")
	private WebElement saveBtn;

	public EditPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectMedia () {
		waiting(1000);
		click(mediaBtn);
		}
	
	public void deletePhotoOfProduct () {
		click(deleteBtn);
	}
	
	public void saveChanges () {
		click(saveBtn);
	}
	}
