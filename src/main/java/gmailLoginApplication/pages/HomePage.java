package gmailLoginApplication.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmailLoginApplication.Base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//td[contains(text(),'User: ')]")
	WebElement userNameLable;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'new contact')]")
	WebElement newContactLink; 
	
	@FindBy(xpath="//a[contains(text(),'deals')]")
	WebElement dealsLink;


	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean verifyUserName() {
		return userNameLable.isDisplayed();
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	

	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	
	
	public ContactsPage clickOnNewContactLInk() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		return new ContactsPage();
	}
	
	
}
