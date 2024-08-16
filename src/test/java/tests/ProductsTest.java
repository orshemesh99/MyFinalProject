package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.MenuPage;

public class ProductsTest extends BaseTest{
	
	@Test
	public void tc01_filterProductsBy () {
		mainPage.ChoiceFromLeftSideMenu("Products");
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Products");
		projectsPage.FilteraBy("equal", "regular", "true", "3230");
		String e = projectsPage.eroorMsg();
		System.out.println(e);
	}
	
	
	@Test
	public void tc02_filterProductsBy () {
		projectsPage.clearFilters();
		projectsPage.FilteraBy("ends_with", "woman", "true", "");
	}
	
	@Test 
	public void tc03_selectCBItem () {
		projectsPage.clickOnCheckBox("Regular_Fit_V_neck_woman");
		projectsPage.clickOnCheckBox("Basic_regular_woman");
	}
	
	@Test 
	public void tc04_editItem () {
	projectsPage.editItem("Slim_fit_woman");
	String actual = projectsPage.isThisTheRightPage();
	Assert.assertEquals(actual, "Edit");
	editPage.selectMedia();
	editPage.deletePhotoOfProduct();
	editPage.saveChanges();
	String s = editPage.getSuccessMsg();
	System.out.println(s);
	}
}
