package org.tyss.SMS_Sandford_Park_School;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is consists all common action on excel
 * @author PAAVANI
 *
 */

public class ExcelUtility {
	Workbook wb=null;
	
	public void openExcel(String excelPath)
	{FileInputStream fis=null;
	try {
		fis = new FileInputStream(excelPath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		wb = WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	/**
	 * This method is used to fetch the data from excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 *  @author PAAVANI
	 */
	
	public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber) 
	{  
		Sheet sheet = wb.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		
		return data;
	}
		public void closeExcel()
		{
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * This method is used for fetching multiple data
		 * @param sheetName
		 * @return
		 * @author PAAVANI
		 */
		
		public String[][] getMultipleData(String sheetName)
		{
			Sheet sheet=wb.getSheet(sheetName);
			DataFormatter df=new DataFormatter();
			String[][] arr=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=1;i<=sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			return arr;
			
				}
}
			
		
