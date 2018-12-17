package gmailLoginApplication.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gmailLoginApplication.Base.BaseClass;

public class LoginPage extends BaseClass {
	
	//PageFactory
	@FindBy(name="username")
	WebElement userN;
	
	
	@FindBy(name="password")
	WebElement passW;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contain(text(),'sign Up)]'")
	WebElement signUPBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;


	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}

	public String validateLoginPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		
		return crmLogo.isDisplayed();
	}


	public HomePage login(String user, String pass) {
		userN.sendKeys(user);
		passW.sendKeys(pass);
		
		loginBtn.click();
		
		return new HomePage();
	}




	

}
