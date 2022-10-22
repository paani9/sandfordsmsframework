package org.sms.admin;

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

public class CreateGrade {
	public static void main(String[] args) throws InterruptedException
	{
		FileUtility fb=new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		ExcelUtility eb=new ExcelUtility();
		fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
		eb.openExcel(Constantpaths.EXCEL_PATH_TESTDATA);
		String url = fb.getDataFromPropertyFile("url");
		String browser = fb.getDataFromPropertyFile("browser");
		String timeout = fb.getDataFromPropertyFile("timeout");
		 String username = fb.getDataFromPropertyFile("adminUn");
		 String password = fb.getDataFromPropertyFile("adminPassword");
       Long timeouts = Long.parseLong(timeout);
	   WebDriver driver = wb.openBrowserWithApplication(browser,timeouts,url);
		driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(2000);
		JavaUtility jb=new JavaUtility();
		String grade = "grade"+""+jb.getRandomNumber(10000);
		driver.findElement(By.linkText("Grade")).click();
		driver.findElement(By.id("name")).sendKeys(grade);
		driver.findElement(By.xpath("//input[@placeholder='Enter admission fee']")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@id='hall_charge']")).sendKeys("30");
		driver.findElement(By.xpath("//button[.='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mark_range_text_1")).sendKeys("90-100");
		Thread.sleep(2000);
		
		driver.findElement(By.name("mark_grade[]")).sendKeys(grade);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(1000);
		List<WebElement> headerlist=driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> gradelist=new ArrayList<WebElement>();
		 for(WebElement hl:headerlist)
		 {String headername=hl.getText();
		 if(headername.equals("Grade"))
		 {
			 gradelist=driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
			 
 int count=0;
			 
			 
			 for(WebElement g:gradelist) 
				{String gd=g.getText();
			
				
				if(gd.equals(grade))
				{
					System.out.println("TC Pass");
					count++;
					break;
					
				}
				
				
		}
			 /*Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//a[.='Next']")).click();
			 gradelist =driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
			
			 for(WebElement g:gradelist) 
				{String gd=g.getText();
			
				
				if(gd.equals("Grade a"))
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
	
		 


}*/
				wb.jsIntialization(driver);
				WebElement n3 = driver.findElement(By.xpath("//a[.='Next']"));
				wb.scrollTillElementViewUsingJS(n3);
				WebElement n=driver.findElement(By.xpath("//div[@id='example1_paginate']//ul//li[last()-1]//a"));
				
				String n1 = n.getText();
				System.out.println(n1);
				
				
for(int i=2;i<=Integer.parseInt(n1);i++)
{               Thread.sleep(1000);
	wb.scrollTillElementViewUsingJS(n3);
				driver.findElement(By.xpath("//a[.='Next']")).click();
				gradelist = driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));

				for (WebElement n2 : gradelist) {
					String nd = n2.getText();

					if (nd.equals(grade)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}}
				if (count == 0) {
					System.out.println("Tc fail");
				}

			}

		}

		driver.close();
	}
}
