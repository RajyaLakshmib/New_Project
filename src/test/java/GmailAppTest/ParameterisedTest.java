package GmailAppTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisedTest {
  @Test
  @Parameters("browser")
  public void f(String browser) {
	  if(browser.equals("Firefox"))
	  {System.out.println("open firefox browser");}
	  else
		  System.out.println("Otherbrowser");
  }
}
