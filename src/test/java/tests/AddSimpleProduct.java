package tests;

import org.testng.annotations.Test;

import pages.MainPage;
import pages.MenuPage;
import pages.ProjectsPage;

public class AddSimpleProduct extends BaseTest {
	
	@Test
	public void tc01_addNewProdject () {
		mainPage.ChoiceFromLeftSideMenu("Products");
		menuPage.create();
		projectsPage.addSimpleProduct();
		newproductpage.createNewProduct("Just an ugly shirt", "55", "60", "50", "Just an ugly shirt", "bla",
									"bla bla bla", "Bc", "bla", "bla", "clothing", "40", "30", "20", "10");
	}
	@Test
	public void tc02_getErrorMsg () {
		String error = newproductpage.getErrorMsg();
		System.out.println(error);
	}
	
	@Test
	public void tc03_getNumOfErrors () {
		int num = newproductpage.getNumOfErrors();
		System.out.println(num);
	}
	
	@Test
	public void tc04_addNewProdject () {
		newproductpage.addProductsInEnglish("Just_an_ugly_shirt", "Just an ugly shirt", "bla");
	}
	
	@Test
	public void tc05_getSuccessMsg () {
		String s = newproductpage.getSuccessMsg();
		System.out.println(s);
	}
}
