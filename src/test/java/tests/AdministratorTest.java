package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdministratorTest extends BaseTest{
	
	@Test
	public void tc01_enterToMyAccount () {
		mainPage.changeMyAccount();
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Edit");
	}
	
	@Test
	public void tc02_changeMyDetails () {
		administratorPage.editMyAdminDetails("or123", "12345", "", "fr");
		String s = administratorPage.getErrorEmailMsg();
		System.out.println(s);
	}
	
	@Test
	public void tc03_changeMyDetails () {
		administratorPage.editMyAdminDetails("or12345", "12345687", "or12345@gmail.com", "he");
		String s = administratorPage.getSuccessMsg();
		System.out.println(s);
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Administrators");
	}
	
	@Test
	public void tc04_returnToTheOriginalUserInformation () {
		mainPage.changeMyAccount();
		administratorPage.editMyAdminDetails("sylius", "sylius", "sylius@example.com" , "en_US");
		String s = administratorPage.getSuccessMsg();
		System.out.println(s);
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Administrators");
	}
	
	@Test
	public void tc05_logOut () {
		mainPage.logOut();
	}

}
