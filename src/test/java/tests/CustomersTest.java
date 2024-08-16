package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.semconv.SemanticAttributes.DbCosmosdbConnectionModeValues;

public class CustomersTest extends BaseTest {
	
	@Test
	public void tc01_SelectCustomersFromTheMenu () {
		mainPage.ChoiceFromLeftSideMenu("Customers");
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Customers");
	}
	
	@Test
	public void tc02_createNewCustomers () {
		customersPage.create();
		customersPage.createNewCustomers("si", "di", "aa@aa,com", "retail", "u", "05/09/2000", "0501234567");
		String error = customersPage.getErrorMsg();
		System.out.println(error);
		Assert.assertEquals(error, "Error");
	}
	
	@Test
	public void tc03_createNewCustomers () {
		customersPage.createNewCustomers("hey", "bye", "or1230@aa.com", "retail", "m", "05/09/2000", "0501234567");
		String Success = customersPage.getSuccessMsg();
		System.out.println(Success);
		Assert.assertEquals(Success, "Customer has been successfully created.");
	}
	
	@Test
	public void tc04_chooseCustomerFromList () {
		customersPage.ChoiceFromLeftSideMenu("Customers");
		customersPage.CustomerList("Orn");
		String rightCustomer = customersPage.thisIsTheRightCustomer();
		Assert.assertEquals(rightCustomer, "Izaiah Orn");
		
	}
	
	@Test
	public void tc05_deleteCustomer () {
		customersPage.deleteCustomer();
		customersPage.getSuccessMsg();
	}

}
