package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipmentsTest extends BaseTest{
	
	@Test
	public void tc01_SortShipmentsBy () {
	
		shipmentsPage.SearchAndSelectShipmentsInMenu("Shipments");
		String actual = projectsPage.isThisTheRightPage();
		Assert.assertEquals(actual, "Shipments");
		shipmentsPage.FilterShipmentsBy("shipped", "3230", "4839");
		String info = shipmentsPage.getInfoMsg();
		System.out.println(info);
	}
	
	@Test
	public void tc02_SortShipmentsBy () {
	shipmentsPage.clearFilters();
	shipmentsPage.FilterShipmentsBy("ready", "", "4840");
	shipmentsPage.SelectShipmentBySerialOrder("#000000004");
	String actual = projectsPage.isThisTheRightPage();
	Assert.assertEquals(actual, "#000000004");
	}
	
	@Test
	public void tc03_getOrderPrice () {
	String price = orderPage.getPriceOfOrder();
	System.out.println("The price of the order is:" + price);
	}
	
	@Test
	public void tc04_editShippingAddress () {
	orderPage.editShippingAddress("Or", "Shemesh", "EL EL Israel", "bla bla bla", "DE", "Berlin", "10203040");
	String success = orderPage.getSuccessMsg();
	System.out.println(success);
	Assert.assertEquals(success, "Order has been successfully updated.");
	}
	
	@Test
	public void tc05_lookAtTheOrderHistory () {
	orderPage.historyOfTheOrder();
	orderPage.back();
	}
	
	@Test
	public void tc06_completeTheOrder () {
	orderPage.completeOrder();
	String success = orderPage.getSuccessMsg();
	System.out.println(success);
	Assert.assertEquals(success, "Payment has been successfully updated.");
	
	}
}
