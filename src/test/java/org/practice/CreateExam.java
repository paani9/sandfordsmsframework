package org.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.JavaUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;

public class CreateExam {
	public static void main(String[] args) throws InterruptedException {
		FileUtility fb = new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		//ExcelUtility eb=new ExcelUtility();
		fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
		String url = fb.getDataFromPropertyFile("url");
		String browser = fb.getDataFromPropertyFile("browser");
		String timeout = fb.getDataFromPropertyFile("timeout");
		String username=fb.getDataFromPropertyFile("adminUn" );
		String password=fb.getDataFromPropertyFile("adminPassword");
		JavaUtility jb=new JavaUtility();
		int ran = jb.getRandomNumber(10000);
		String subject="subject"+""+ran;
		
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("//span[.='Exam']")).click();
		driver.findElement(By.xpath("//a[.='Create Exam']")).click();
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(subject);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(2000);
		List<WebElement> headerlist = driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> namelist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
		String headername = hl.getText();
			if (headername.equals("Name")) {
				namelist = driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
				
				
				int count = 0;

				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
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
				namelist = driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));

				for (WebElement n2 : namelist) {
					String nd = n2.getText();

					if (nd.equals(subject)) {
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
				/*int count = 0;
				for (WebElement hl : headerlist) {
					String headername = hl.getText();
					if (headername.equals("Name")) {
						List<WebElement> namelist1 = cd.getNameList();

						

						for (WebElement n : namelist) {
							String nd = n.getText();

							if (nd.equals("name1")) {
								System.out.println("TC Pass");
								count++;
								break;

							}

						}
						WebElement n=cd.numberOfTimesNextButtonClick();
						String n1 = n.getText();
						

						for (int i = 2; i <=Integer.parseInt(n1); i++) {

							//WebElement n = driver.findElement(By.xpath("//a[@data-dt-idx='" + (i) + "']"));
							//WebElement n3=driver.findElement(By.xpath("//div[@id='example1_paginate']/descendant::li[last()-1]/a"));
							//String n4 = n3.getText();
							//System.out.println(n4);
							//String n1 = n.getText();
							//if (n1.equals("Next")) {
								//break;
							//} 
							//else

							//{
								cd.nextButtonInAllStudent();
								List<WebElement> namelist2 = cd.getNameList();

								for (WebElement n2 : namelist2) {
									String nd = n2.getText();

									if (nd.equals(examname)) {
										System.out.println("TC Pass");
										count++;
										break;

									

								}
							}
					
						}
						
					}
					
					}
				if (count == 0) {
					System.out.println("Tc fail");
			}
				
				wb.closeBrowser(driver);
				eb.closeExcel();

			}


	}*/




