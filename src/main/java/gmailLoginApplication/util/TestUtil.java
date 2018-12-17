package gmailLoginApplication.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import gmailLoginApplication.Base.BaseClass;

public class TestUtil extends BaseClass {
	
	
	private static final String TEST_DATA_SHEET_PATH = null;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
    public static Workbook book;
    public static Sheet sheet;

	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
		
	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			book= WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet= book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<sheet.getLastRowNum();i++) {
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			data[i][j] = sheet.getRow(i).getCell(j).toString();
		}
		
		}
		return data;
		
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
}
