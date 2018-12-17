package GmailAppTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

/*
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestApacheExcel {
@Test
public void TestExcel(){
		// TODO Auto-generated method stub
	try
	{
FileInputStream fins = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Raj_Test1\\excelfile.xls");
System.out.println("File open");
Workbook workbook = new Workbook(fins);
Sheet  sheet = workbook.getSheetAt(0);
Row row = sheet.getRow(0);
Cell cell = row.getCell(0);
System.out.println(cell);
	}
	catch(Exception e)
	{
		System.out.println("Error");
	}
	}

}*/

public class TestApacheExcel {
	 public static void main (String [] args) throws IOException{
	                        //I have placed an excel file 'Test.xlsx' in my D Driver 
	 FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Raj_Test1\\excelfile.xlsx");
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 XSSFSheet sheet = workbook.getSheetAt(0);
	                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
	 Row row = sheet.getRow(0);
	 Cell cell =  (Cell) row.getCell(0);
	                       System.out.println(cell);
	 System.out.println(sheet.getRow(0).getCell(0));
	 //String cellval = cell.getStringCellValue();
	 //System.out.println(cellval);
	 
	 } 
	}
