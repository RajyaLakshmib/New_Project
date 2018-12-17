package gmailLoginApplication.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gmailLoginApplication.Base.BaseClass;
import gmailLoginApplication.pages.HomePage;
import gmailLoginApplication.pages.LoginPage;


public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "%CRM%");	
		
	}
	
	@Test(priority=2)
	public void cRMLogoTest() {
		Boolean flag =loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	
	@AfterMethod
	public void teatDown(){
		driver.quit();
	}
	

}
