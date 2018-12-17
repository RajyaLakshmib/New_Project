package gmailLoginApplication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import gmailLoginApplication.Base.BaseClass;

public class ContactsPage extends BaseClass {

	@FindBy(xpath="//td[contains(tesxt(),'Contacts')]")
	@CacheLookup //- It won't interact with web page and take data from cache memory.
	WebElement contactsLable;
	
	@FindBy(id="First name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client-lookup")
	WebElement companyElement;
	
	@FindBy(xpath="//input[@type='submit' and @value='save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public Boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	}
	
	
	public void createNewContact(String title,String ftname,String ltName,String comName)
	{
		Select sel=new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltName);
		companyElement.sendKeys(comName);
		saveBtn.click();
	}
	
	
}
