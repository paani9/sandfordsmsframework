package org.tyss.SMS_Sandford_Park_School;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists reusable method to handle property file
 * @author PAAVANI
 *
 */

public class FileUtility {
	Properties  property;
	/**
	 * This method is used for intialize propertyfile
	 * @param propertyFilePath
	 * @author PAAVANI
	 */
	public void intializePropertyFile(String propertyFilePath)
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  property=new Properties();
		 try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to get data from propertyfile
	 * @param key
	 * @return
	 * @author PAAVANI
	 */
	public String getDataFromPropertyFile(String key)
	{
		/*FileInputStream fis=null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Properties  property=new Properties();
		 try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 String value=property.getProperty(key).trim();
		 return value;

}
}
