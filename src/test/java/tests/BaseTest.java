package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AdministratorPage;
import pages.CountriesPage;
import pages.CustomersPage;
import pages.EditPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MenuPage;
import pages.NewCountryPage;
import pages.NewProductPage;
import pages.OrderPage;
import pages.ProjectsPage;
import pages.ShipmentsPage;
import utils.Utils;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	ForgotPasswordPage forgetpassPage;
	MainPage mainPage;
	ProjectsPage projectsPage;
	EditPage editPage;
	MenuPage menuPage;
	NewProductPage newproductpage;
	ShipmentsPage shipmentsPage;
	OrderPage orderPage;
	CustomersPage customersPage;
	CountriesPage countriesPage;
	NewCountryPage newCountryPage;
	AdministratorPage administratorPage;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.sylius.com/admin/login");
		
		waiting(1000);
	}
	
	@BeforeClass
	public void setupAPages() {
		loginPage = new LoginPage(driver);
		forgetpassPage = new ForgotPasswordPage(driver);
		mainPage = new MainPage(driver);
		 projectsPage = new ProjectsPage(driver);
		 editPage = new EditPage(driver);
		 menuPage = new MenuPage(driver);
		 newproductpage = new NewProductPage(driver);
		 shipmentsPage = new ShipmentsPage(driver);
		 orderPage = new OrderPage(driver);
		 customersPage = new CustomersPage(driver);
		 countriesPage = new CountriesPage(driver);
		 newCountryPage = new NewCountryPage(driver);
		 administratorPage = new AdministratorPage(driver);
	}
	
	@BeforeClass
	public void setuplogin() {
		loginPage.login("sylius", "sylius");
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
	
	public void waiting(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
