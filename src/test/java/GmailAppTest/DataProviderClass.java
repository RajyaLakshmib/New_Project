package GmailAppTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
  @Test(dataProvider="getData")
  public void f(String x,String y) {
	  System.out.println(x+" "+y);
  }
  @DataProvider(name="getData")
  public Object[][] getData()
  {
	  Object[][] a =new Object[2][2];
	  a[0][0]="Raji";
	  a[0][1]="suneel";
	  a[1][0]="basuvula";
	  a[1][1]="samrajyam";
	  return a;
  }
  
}
