import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Practice1 {

	public String getDataFromExcel(String excelpath,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(excelpath);
	Workbook book=WorkbookFactory.create(fis);
	
	 Sheet sheet=book.getSheet(sheetname);
	DataFormatter df=new DataFormatter();
	String value=df.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	book.close();
	
	return value;
	}
	public String getDataFromPropertyFile(String propertyfilepath,String key) throws IOException
	{
	FileInputStream fis=new FileInputStream(propertyfilepath);
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;

	}
	public static void main(String[] args)
	{
		Practice1 p1 = new Practice1();
		p1.getDataFromExcel("./src/test/resources/practice1.xlsx", null, 0, 0)
	}






}
