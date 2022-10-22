package org.practice;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;

public class Mavenpractice1Test {
@Test
public void s1Test() {
	String browser = System.getProperty("b");
	String url = System.getProperty("u");
	WebDriverUtility wb=new WebDriverUtility();
     WebDriver driver = wb.openBrowserWithApplication(browser,10l, url);
     
     
driver.close();
	
	
}
}
