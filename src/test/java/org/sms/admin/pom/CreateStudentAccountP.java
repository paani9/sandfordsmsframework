package org.sms.admin.pom;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.JavaUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.CreateStudentPage;
import org.tyss.objectRepository.Loginpage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateStudentAccountP {
	public static void main(String[] args)
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		WebDriverUtility wb = new WebDriverUtility();
		FileUtility fb = new FileUtility();
		ExcelUtility eb = new ExcelUtility();
		JavaUtility jb = new JavaUtility();
		fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
		eb.openExcel(Constantpaths.EXCEL_PATH_TESTDATA);
		String url = fb.getDataFromPropertyFile("url");
		String browser = fb.getDataFromPropertyFile("browser");
		String timeout = fb.getDataFromPropertyFile("timeout");
		String username = fb.getDataFromPropertyFile("adminUn");
		String password = fb.getDataFromPropertyFile("adminPassword");
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		CreateStudentPage cd = new CreateStudentPage(driver);
		Loginpage loginpage = new Loginpage(driver);
		Commonpage commonpage = new Commonpage(driver);
		loginpage.loginAction(username, password);
		commonpage.clickRequiredTab(Tabnamesforhomepage.STUDENTTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.ADDSTUDENTTAB, wb);
		int randomNum = jb.getRandomNumber(10000);
		String name = "A"+""+randomNum;
		cd.enterStudentDetails(Integer.parseInt(eb.getDataFromExcel("Student", 1, 0)) + randomNum,
				eb.getDataFromExcel("Student", 1, 1),name,
				eb.getDataFromExcel("Student", 1, 3), "sa" + randomNum + "@gmail.com",
				eb.getDataFromExcel("Student", 1, 5), eb.getDataFromExcel("Student", 1, 6),
				eb.getDataFromExcel("Student", 1, 7), eb.getDataFromExcel("Student", 1, 8));

		cd.enterGurdianDetails(Integer.parseInt(eb.getDataFromExcel("Student", 1, 9)),
				eb.getDataFromExcel("Student", 1, 10), eb.getDataFromExcel("Student", 1, 11),
				eb.getDataFromExcel("Student", 1, 12), eb.getDataFromExcel("Student", 1, 13),
				eb.getDataFromExcel("Student", 1, 14), eb.getDataFromExcel("Student", 1, 15),
				eb.getDataFromExcel("Student", 1, 16), eb.getDataFromExcel("Student", 1, 17));

		cd.nextButton();

		cd.selectGrade("Grade 1");

		List<WebElement> headerlist = cd.getHeaderList();

		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Subject")) {
				List<WebElement> subjectlist = cd.getSubjectList();
				for (WebElement g : subjectlist) {
					String gd = g.getText();
					Thread.sleep(2000);
					if (gd.equals(eb.getDataFromExcel("Student", 1, 19))) {
						cd.selectSubject();
						break;

					}
				}

			}
		}
		cd.clickSubmitButton();

		cd.clickCloseIcon(driver);

		commonpage.clickRequiredTab(Tabnamesforhomepage.STUDENTTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.ALLSTUDENTTAB, wb);

		cd.selectGrade(eb.getDataFromExcel("Student", 1, 18));

		cd.clickSubmitButton();

		List<WebElement> headerlist1 = cd.getHeaderList();
		

		int count = 0;
		for (WebElement hl : headerlist1) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				List<WebElement> namelist = cd.getNameList();

				

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

					
						cd.nextButtonInAllStudent();
						List<WebElement> namelist1 = cd.getNameList();

						for (WebElement n2 : namelist1) {
							String nd = n2.getText();

							if (nd.equals(name)) {
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

	}


