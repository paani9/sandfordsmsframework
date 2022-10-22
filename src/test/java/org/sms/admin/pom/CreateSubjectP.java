package org.sms.admin.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.JavaUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.CreateSubjectPage;
import org.tyss.objectRepository.Loginpage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateSubjectP {
	public static void main(String[] args)
	{

		FileUtility fb = new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		ExcelUtility eb=new ExcelUtility();
		JavaUtility jb=new JavaUtility();
		fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
		String url = fb.getDataFromPropertyFile("url");
		String browser = fb.getDataFromPropertyFile("browser");
		String timeout = fb.getDataFromPropertyFile("timeout");
		String username=fb.getDataFromPropertyFile("adminUn" );
		String password=fb.getDataFromPropertyFile("adminPassword");
		
		
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		Loginpage loginpage = new Loginpage(driver);
		 Commonpage commonpage = new Commonpage(driver);
		 CreateSubjectPage createsubjectpage=new CreateSubjectPage(driver);
		 loginpage.loginAction(username, password);
		commonpage.clickRequiredTab(Tabnamesforhomepage.SUBJECTTAB, wb);
		 String subject = "subject"+jb.getRandomNumber(10000);
		createsubjectpage.sendSubject(subject);
	    createsubjectpage.clickOnSubmit();
		 List<WebElement> headerlist = createsubjectpage.getHeaderList();
	    
		 List<WebElement> subjectlist = new ArrayList<WebElement>();
		 for(WebElement hl:headerlist)
		 {String headername=hl.getText();
		 if(headername.equals("Subject"))
		 {   subjectlist=createsubjectpage.getSubjectList();
		 
			 //subjectlist=driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[2]"));
			 //JavascriptExecutor js=(JavascriptExecutor) driver;
			 //js.executeScript("window.scrollBy(0,500)");
		 WebElement n=createsubjectpage.getNextButton();
			 wb.jsIntialization(driver);
			 wb.scrollTillElementViewUsingJS(n);
			 int count=0;
			 
			 
			 for(WebElement s:subjectlist) 
				{String sd=s.getText();
			
				
				if(sd.equals(subject))
				{
					System.out.println("TC Pass");
					count++;
					break;
					
				}
				
				
		}
			
			 
			 n.click();
			 subjectlist=createsubjectpage.getSubjectList();
			 for(WebElement s:subjectlist) 
				{String sd=s.getText();
			
				
				if(sd.equals(subject))
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
		 

	wb.closeBrowser(driver);
	}

	}




