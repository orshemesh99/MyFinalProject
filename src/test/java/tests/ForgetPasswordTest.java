package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPasswordTest extends BaseTest{
	
	@Override
	@Test
	public void setuplogin () {
	}
	
	@Test
	public void tc01_invalidEmail () {
		loginPage.forgogPassword();
		forgetpassPage.enterEmail("blablabla");
		String error = forgetpassPage.eroorMsg();
		Assert.assertEquals(error, "This email is not valid.");
	}
	
	@Test
	public void tc02_resetPassword () {
		forgetpassPage.enterEmail("blablabla@gmail.com");
	}
	
	@Test
	public void tc03_SuccessMsg () {
		String success = loginPage.SuccessResetMsg();
		Assert.assertEquals(success, "If the email you have specified exists in our system, we have sent there an instruction on how to reset your password.");
	}

}
