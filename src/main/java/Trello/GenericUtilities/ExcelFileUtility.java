package Trello.GenericUtilities;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {

	public String readDataFromExcelSheet(String SheetName,int row, int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilePath);
		return WorkbookFactory.create(fis).getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	public double readIntegerDataFromExcelSheet(String SheetName,int row, int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilePath);
		return WorkbookFactory.create(fis).getSheet(SheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
	public Object[][] readDataFromExcelToDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
