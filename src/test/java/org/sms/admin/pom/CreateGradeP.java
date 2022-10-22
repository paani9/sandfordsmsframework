package org.sms.admin.pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_Park_School.Constantpaths;
import org.tyss.SMS_Sandford_Park_School.ExcelUtility;
import org.tyss.SMS_Sandford_Park_School.FileUtility;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.CreateGradePage;
import org.tyss.objectRepository.Loginpage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateGradeP {
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
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		Loginpage loginpage = new Loginpage(driver);
		Commonpage commonpage = new Commonpage(driver);
		loginpage.loginAction(username, password);
		commonpage.clickRequiredTab(Tabnamesforhomepage.GRADETAB, wb);

		CreateGradePage cgp = new CreateGradePage(driver);
		cgp.createGrade(eb.getDataFromExcel("Grade", 2, 0), Integer.parseInt(eb.getDataFromExcel("Grade", 1, 1)),
				Integer.parseInt(eb.getDataFromExcel("Grade", 1, 2)));

		cgp.sendRangeAndGrade("75-100", "A");
		List<WebElement> headerlist = cgp.getHeaderList();

		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Grade")) {
				List<WebElement> gradelist = cgp.getGradeList();

				int count = 0;

				for (WebElement g : gradelist) {
					String gd = g.getText();

					if (gd.equals(eb.getDataFromExcel("Grade", 2, 0))) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				Thread.sleep(3000);
				cgp.clickNextButtonInAllGrade();

				gradelist = cgp.getGradeList();

				for (WebElement g : gradelist) {
					String gd = g.getText();

					if (gd.equals(eb.getDataFromExcel("Grade", 1, 0))) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				if (count == 0) {
					System.out.println("Tc fail");
				}

			}

		}

		eb.closeExcel();
		wb.closeBrowser(driver);
	}

}
