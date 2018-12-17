package gmailLoginApplication.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gmailLoginApplication.Base.BaseClass;
import gmailLoginApplication.pages.ContactsPage;
import gmailLoginApplication.pages.HomePage;
import gmailLoginApplication.pages.LoginPage;
import gmailLoginApplication.util.TestUtil;

public class ContactsPageTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName="contacts";
	
	
	public ContactsPageTest(){
super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsLableTest() {
		Assert.assertTrue(contactsPage.verifyContactsLable(),"contacts lable is missing");
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname,String lastname,String company) {
		homePage.clickOnNewContactLInk();
		contactsPage.createNewContact(title,firstname,lastname,company);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
