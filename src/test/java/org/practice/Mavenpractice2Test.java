package org.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;

public class Mavenpractice2Test {
	@Test
	public void s2Test() {
		String browser = System.getProperty("b1");
		String url = System.getProperty("u1");
		WebDriverUtility wb=new WebDriverUtility();
	     WebDriver driver = wb.openBrowserWithApplication(browser,10l, url);
	driver.close();
		
		
	}

}
