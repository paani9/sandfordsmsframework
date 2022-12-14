package org.sms.admin;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateStudentAccount {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://rmgtestingserver/domain/Student_Management_System/");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Student']")).click();
		driver.findElement(By.xpath("//a[.=' Add Student']")).click();
		driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys("2022126");
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("student126");
		driver.findElement(By.xpath("//input[@id='i_name']")).sendKeys("A.student12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("1/222,katteriguppe,Banshankari");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("student126@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("111-111-1111");
		driver.findElement(By.xpath("//input[@id='b_date']")).sendKeys("1-jan-2022");
		Thread.sleep(2000);
		WebElement s = driver.findElement(By.xpath("//select[@id='gender']"));
		Select s1 = new Select(s);
		s1.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\SIVA KUMAR\\Documents\\d1.jpg");
		driver.findElement(By.xpath("//input[@id='g_index']")).sendKeys("G-2022124");
		driver.findElement(By.xpath("//input[@name='g_full_name']")).sendKeys("parent124");
		driver.findElement(By.xpath("//input[@id='g_i_name']")).sendKeys("a");
		driver.findElement(By.xpath("//input[@name='g_address']")).sendKeys("1/111,katteriguppe,Banshankari");
		driver.findElement(By.xpath("//input[@name='g_email']")).sendKeys("parent124@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='g_phone']")).sendKeys("111-111-1111");
		driver.findElement(By.xpath("//input[@id='g_b_date']")).sendKeys("1-jan-2022");
		WebElement p = driver.findElement(By.xpath("//select[@name='g_gender']"));
		Select p1 = new Select(p);
		p1.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@id='g_fileToUpload']")).sendKeys("C:\\Users\\SIVA KUMAR\\Documents\\d1.jpg");
		driver.findElement(By.xpath("//button[.='Next']")).click();
		Thread.sleep(2000);
		WebElement grade = driver.findElement(By.xpath("//select[@id='grade']"));
		Select grade1 = new Select(grade);
		grade1.selectByVisibleText("Grade 1");
		List<WebElement> headerlist = driver.findElements(By.xpath("//table/thead/tr/th"));
		List<WebElement> subjectlist = new ArrayList<WebElement>();
		Thread.sleep(2000);
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Subject")) {
				subjectlist = driver.findElements(By.xpath("//table[@class='table ']/tbody/tr/td[2]"));
				for (WebElement g : subjectlist) {
					String gd = g.getText();
					Thread.sleep(2000);
					 if(gd.equals("Subject 3")) {
						 driver.findElement(By.xpath("//tbody/descendant::td[.='Subject 6']/parent::tr/td/input[@type='checkbox']")).click();
					 break;

				}
			}
				
		}
		}
			driver.findElement(By.xpath("//button[.='Submit']")).click();
			Thread.sleep(2000);
			  // WebElement close = driver.findElement(By.xpath("//button[@class='close  ']"));
			//WebElement close1= driver.findElement(By.xpath("//button[text()='Paid']"));

		    //Actions act = new Actions(driver);
		  //  act.moveToElement(close1).perform();
		    
		   // close1.click();
		   // Thread.sleep(1000);

		///	Set<String> windowHandles = driver.getWindowHandles();
			//for (String string : windowHandles) {
			//	System.out.println(string);
			//}
			WebElement close = driver.findElement(By.xpath("//button[@class='close  ']"));
			Thread.sleep(2000);
			
	
		    Actions act = new Actions(driver);
			    act.moveToElement(close).perform();			  
			    close.click();
			    Thread.sleep(7000);
			// Robot r=new Robot();
			//	r.keyPress(KeyEvent.VK_ESCAPE);
				//   r.keyRelease(KeyEvent.VK_ESCAPE);
				   Thread.sleep(2000);
		     
			  driver.findElement(By.xpath("//span[.='Student']")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//a[.=' All Student']")).click();
			  Thread.sleep(2000);
			    WebElement selectgrade= driver.findElement(By.xpath("//select[@id='grade']"));
			    Select agrade=new Select(selectgrade);
			   agrade.selectByVisibleText("Grade 1");
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   
			   Thread.sleep(2000);
			   
			   List<WebElement> headerlist1=driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
				List<WebElement> namelist=new ArrayList<WebElement>();
				 for(WebElement hl:headerlist1)
				 {String headername=hl.getText();
				 if(headername.equals("Name"))
				 {
					 namelist=driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
					 
		 int count=0;
					 
					 
					 for(WebElement n:namelist) 
						{String nd=n.getText();
					
						
						if(nd.equals("A.student124"))
						{
							System.out.println("TC Pass");
							count++;
							break;
							
						}
						
						
				}
					 Thread.sleep(3000);
					 
					 driver.findElement(By.xpath("//a[.='Next']")).click();
					 namelist =driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
					
					 for(WebElement n:namelist) 
						{String nd=n.getText();
					
						
						if(nd.equals("A.student124"))
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
			
			   
				 Thread.sleep(2000);
			    driver.close();
			    
			    }


}



