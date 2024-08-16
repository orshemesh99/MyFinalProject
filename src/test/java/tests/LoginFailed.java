package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFailed extends BaseTest{
	
	@Override
	@Test
	public void setuplogin() {
	}
	
	@Test (dataProvider = "getData")
	public void tc01_loginFailed (String user, String password) {
		loginPage.login(user , password);
		String actual = loginPage.EroorMsg();
		System.out.println(actual);
		Assert.assertEquals(actual, "Invalid credentials.");
	}
	
//	@Test
//	public void tc02_invalidPassword () {
//		loginPage.login("sylius", "123456");
//		String actual = loginPage.EroorMsg();
//		Assert.assertEquals(actual, "Invalid credentials.");
//	}
//	
//	@Test
//	public void tc03_invalidUserNameAndPassword () {
//		loginPage.login("blablabla", "123456");
//		String actual = loginPage.EroorMsg();
//		Assert.assertEquals(actual, "Invalid credentials.");
//	}

	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"or","sylius"},
				{"sylius","123"},
				{"blablabla","12345678"},
				{"123456878","blablabla"},
				{"123456878"," "},
				{" ","12345"},
		};
		return myData;
	}
}
