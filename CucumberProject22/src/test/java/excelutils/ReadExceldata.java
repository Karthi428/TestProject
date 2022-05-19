package excelutils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExceldata
{
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public ReadExceldata(WebDriver driver)
	{	
		this.driver=driver;
	try {
		//Path of the excel file
FileInputStream file = new FileInputStream("./DataSource/sample.xlsx");
//Creating a workbook
	workbook =  new XSSFWorkbook(file);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public String getdata(int sheetNo,int row,int col)
{
	//get sheetNO
sheet = workbook.getSheetAt(0);
//get row and column respected with sheetNO
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;			
	}

}
