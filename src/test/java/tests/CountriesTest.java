package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountriesTest extends BaseTest{

	@Test
	public void tc01_createNewCountry () {
		mainPage.ChoiceFromLeftSideMenu("Countries");
	}
	
	@Test
	public void tc02_createNewCountryFailAndThenSucceed() {
	countriesPage.create();
	 newCountryPage.createNewCountry("IT", "IT", "", "");;
	 String ErrorMsg = newCountryPage.getErrorMsg();
	 System.out.println(ErrorMsg);
	 Assert.assertEquals(ErrorMsg, "This form contains errors.");
	 newCountryPage.returnToCountryList();
	}
	
	@Test (dataProvider = "getData")
	public void tc03_createNewCountry (String countryName, String provincesCode, String provincesName, String provincesAbbreviation) {
		countriesPage.create();
	 newCountryPage.createNewCountry(countryName, provincesCode, provincesName, provincesAbbreviation);
	 String SuccessMsg = newCountryPage.getSuccessMsg();
	 System.out.println(SuccessMsg);
	 Assert.assertEquals(SuccessMsg, "Country has been successfully created.");
	 newCountryPage.returnToCountryList();

	}
	
	@Test
	public void tc04_filterAndChooseCountry () {
		countriesPage.FiltersCountryBy("starts_with", "I", "true");
		countriesPage.chooseCountryFromList("Iran");
	}
	
	@Test
	public void tc05_deleteProvincesFromCountry () {
		newCountryPage.deleteProvinces();
		String SuccessMsg = newCountryPage.getSuccessMsg();
		System.out.println(SuccessMsg);
		Assert.assertEquals(SuccessMsg, "Country has been successfully updated.");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"IT", "IT-MIL", "Milan", "mil"},
				{"IL","IL-TLV","Tal Aviv","TLV"},
				{"IR","IR-BG","Baghdad"," "}
				
		};
		return myData;
	}

}
