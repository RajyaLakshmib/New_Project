package gmailLoginApplication.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import gmailLoginApplication.util.TestUtil;
import gmailLoginApplication.util.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties  prop;
	public static EventFiringWebDriver eventFiring;
	public static WebEventListener  eventListener;
	public BaseClass()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Raj_Test1\\src\\main\\java\\gmailLoginApplication\\config\\congig.properties");
			prop.load(fis);
		}
			catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Raj_Test1\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\eclipse-workspace\\Raj_Test1\\driver\\gekodriver.exe");
			driver = new FirefoxDriver();
		}
		
		eventFiring= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();// to generate logs
		eventFiring.register(eventListener);
		driver=eventFiring;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	

}
