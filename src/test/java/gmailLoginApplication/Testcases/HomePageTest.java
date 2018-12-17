package gmailLoginApplication.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gmailLoginApplication.Base.BaseClass;
import gmailLoginApplication.pages.ContactsPage;
import gmailLoginApplication.pages.HomePage;
import gmailLoginApplication.pages.LoginPage;
import gmailLoginApplication.util.TestUtil;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//testcase should be seperated - Independent eachother
	//before each testcase - lauch the browser and login
	//@test - execute testcase
	//After - close the browser
	
	
	@BeforeMethod
	public void setUp() {
initialization();
testUtil =new TestUtil();
loginPage = new LoginPage();
contactsPage = new ContactsPage();
homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homePageTitle = homePage.verifyHomepageTitle();
	Assert.assertEquals(homePageTitle,"CRMPRO","Home title not matched");
	}
	
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage =  homePage.clickOnContactLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
