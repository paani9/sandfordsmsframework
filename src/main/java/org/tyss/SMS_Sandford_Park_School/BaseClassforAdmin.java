package org.tyss.SMS_Sandford_Park_School;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.Loginpage;

public class BaseClassforAdmin {
	
	public static JavaUtility sjavaUtility;
	public static WebDriver sdriver;
	private String url;
	private String browser;
	private String timeout;
	private String username;
	private String password;
	//protected String subject;
	private Long timeouts;
	protected WebDriver driver;
	protected Loginpage loginpage;
	protected Commonpage commonpage;
	protected WebDriverUtility wb;
	protected ExcelUtility eb;
	protected FileUtility fb;
	protected JavaUtility jb;

	
	@BeforeClass
	public void classSetUp()
	{
      fb = new FileUtility();
	  wb = new WebDriverUtility();
	  eb = new ExcelUtility();
	  jb=new JavaUtility();
	  sjavaUtility = jb;
	fb.intializePropertyFile(Constantpaths.PROPERTY_FILE_PATH);
	eb.openExcel(Constantpaths.EXCEL_PATH_TESTDATA);                                                                                                                                                                                                                          
	String url = fb.getDataFromPropertyFile("url");
	String browser = fb.getDataFromPropertyFile("browser");
	String timeout = fb.getDataFromPropertyFile("timeout");
	 username = fb.getDataFromPropertyFile("adminUn");
	 password = fb.getDataFromPropertyFile("adminPassword");
	
	Long timeouts = Long.parseLong(timeout);
	 driver = wb.openBrowserWithApplication(browser, timeouts, url);
	 sdriver=driver;
	 
	loginpage = new Loginpage(driver);
	 commonpage = new Commonpage(driver);
	}
	
	@BeforeMethod
	
	public void methodSetUp()
	{
	loginpage.loginAction(username, password);
	}
	
	@AfterClass
	public void methodTearDown()
	{eb.closeExcel();
		wb.closeBrowser(driver);
		
	}
	
}

	
	
	
	
	
