package org.sms.admin.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;
import org.tyss.objectRepository.Allexampage;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.Loginpage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateexamP {
	public static void main(String[] args) throws InterruptedException {
		FileUtility fb = new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		ExcelUtility eb = new ExcelUtility();
		fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
		eb.openExcel(Constantpaths.EXCEL_PATH_TESTDATA);
		String url = fb.getDataFromPropertyFile("url");
		String browser = fb.getDataFromPropertyFile("browser");
		String timeout = fb.getDataFromPropertyFile("timeout");
		 String username = fb.getDataFromPropertyFile("adminUn");
		 String password = fb.getDataFromPropertyFile("adminPassword");
		String subject = eb.getDataFromExcel("SC", 4, 0);
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		
		Loginpage loginpage = new Loginpage(driver);
		Commonpage commonpage = new Commonpage(driver);
		Allexampage ad = new Allexampage(driver);
		loginpage.loginAction(username, password);
		commonpage.clickRequiredTab(Tabnamesforhomepage.EXAMTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.CREATEEXAMTAB, wb);
		ad.addButtonClick();
		ad.addExam(subject);
		Thread.sleep(2000);
		List<WebElement> headerlist = ad.getHeaderList();
		List<WebElement> namelist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				namelist = ad.getNameList();

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
				WebElement n3 = ad.nextbutton();
				wb.scrollTillElementViewUsingJS(n3);
				
				WebElement n=ad.numberOfTimesNextButtonClick();
				String n1 = n.getText();
				
				for(int i=2;i<=Integer.parseInt(n1);i++)
				{               Thread.sleep(1000);
					wb.scrollTillElementViewUsingJS(n3);

				ad.nextbuttonClick();
				namelist = ad.getNameList();
				for (WebElement n2 : namelist) {
					String nd = n2.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}
				}
				}
				if (count == 0) {
					System.out.println("Tc fail");
				}

			}

		}

		wb.closeBrowser(driver);

	}

}
