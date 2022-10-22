package org.sms.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;

public class CreateSubject {
public static void main(String[] args)
{

	FileUtility fb = new FileUtility();
	WebDriverUtility wb = new WebDriverUtility();
	ExcelUtility eb=new ExcelUtility();
	fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
	String url = fb.getDataFromPropertyFile("url");
	String browser = fb.getDataFromPropertyFile("browser");
	String timeout = fb.getDataFromPropertyFile("timeout");
	String username=fb.getDataFromPropertyFile("adminUn" );
	String password=fb.getDataFromPropertyFile("adminPassword");
	//String subject=eb.getDataFromExcel("SC",5,0);
	
	Long timeouts = Long.parseLong(timeout);
	WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
	
    driver.get("http://rmgtestingserver/domain/Student_Management_System/");
    driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.xpath("//span[.='Subject']")).click();
    driver.findElement(By.xpath("//input[@placeholder='Enter Subject name']")).sendKeys("p0");
    driver.findElement(By.xpath("//button[.='Submit']")).click();
    WebElement d1=driver.findElement(By.xpath("//select[@name='example1_length']"));
	Select s1=new Select(d1);
	s1.selectByVisibleText("10");
	 List<WebElement> headerlist = driver.findElements(By.xpath("//div[@class='col-sm-12']/table/thead/tr/th"));
	 List<WebElement> subjectlist = new ArrayList<WebElement>();
	 for(WebElement hl:headerlist)
	 {String headername=hl.getText();
	 if(headername.equals("Subject"))
	 {
		 subjectlist=driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[2]"));
		 //JavascriptExecutor js=(JavascriptExecutor) driver;
		 //js.executeScript("window.scrollBy(0,500)");
		 WebElement n = driver.findElement(By.xpath("//a[.='Next']"));
		 wb.jsIntialization(driver);
		 wb.scrollTillElementViewUsingJS(n);
		 int count=0;
		 
		 
		 for(WebElement s:subjectlist) 
			{String sd=s.getText();
		
			
			if(sd.equals("p8818"))
			{
				System.out.println("TC Pass");
				count++;
				break;
				
			}
			
			
	}
		
		 
		// WebElement n = driver.findElement(By.xpath("//a[.='Next']"));
		 n.click();
		 subjectlist =driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[2]"));
		 for(WebElement s:subjectlist) 
			{String sd=s.getText();
		
			
			if(sd.equals("p0"))
			{
				System.out.println("TC Pass");
				count++;
				break;
				
			}
			
	 }
		 if(count==0)
		 {
			 System.out.println("Tc fail");
		 }
		
		 
	 }
	 
	 }
	 

driver.close();
}

}


