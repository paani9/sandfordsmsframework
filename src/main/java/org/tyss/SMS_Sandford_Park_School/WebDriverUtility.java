package org.tyss.SMS_Sandford_Park_School;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all WebDriver actions
 * @author PAAVANI
 *
 */

public class WebDriverUtility {
	/*
	 * This method is used to Launch the browser
	 * @author PAAVANI
	 */
	JavascriptExecutor jsExecutor;
	Select s;
	public WebDriver launchBrowser(String browser)
	
	{
		WebDriver driver=null;
		switch(browser)
		{case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
	 default:
		 System.out.println("you entered wrong browser key in the property file");
		 break;
		
		}
		return driver;
		
		
		}
	



	/**
	 * This method is used to maximize the browser	
	 * @param driver
     * @author PAAVANI
	 */
public void maximizeBrowser(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 *  This method is used to wait the controller implicitly till load
 * @param driver
 * @param longTimeout
 * @author PAAVANI
*/
	public void waitTillPageLoad(WebDriver driver,Long longTimeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	
}
	/**
	 *  This method is used to open the application
	 * @param driver
	 * @param url
	 * @author PAAVANI
	 */
	public void openApplication(WebDriver driver,String url)
	{
		driver.get(url);
		
	}
	/**
	 * This method is used to Launch browser,Maximize Browser,wait until page get load,navigate application
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 * @author PAAVANI
	 */
public WebDriver openBrowserWithApplication(String browser,Long longTimeout,String url)
{
	WebDriver driver = launchBrowser(browser);
	maximizeBrowser(driver);
	waitTillPageLoad(driver,longTimeout);
	openApplication(driver,url);
	return driver;
	
	
	
}
/**
 * This method is used to do mouse hover action 
 * @param driver
 * @param element
 * @author PAAVANI
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{ 
	new Actions(driver).moveToElement(element).perform();
	
}
/**
 * This method is used to double click on WebElement
 * @param driver
 * @param element
 */

public void doubleClick(WebDriver driver,WebElement element)
{
	new Actions(driver).doubleClick(element).perform();
}
/**
 * This method is used to double click on page
 * @param driver
 * @author PAAVANI
 */
public void doubleClick(WebDriver driver)
{
	new Actions(driver).doubleClick().perform();
}
/**
 * This method is used to close the application 
 * @param driver
 * @author PAAVANI
 */
public void closeBrowser(WebDriver driver)
{
	driver.quit();
}
/**
 * This method is used to convert dynamic xpath into WebElement
 * @param dynamicXpath
 * @param replaceData
 * @param driver
 * @return
 * @author PAAVANI
 */
public WebElement convertDynamicxpathIntoWebElement(String dynamicXpath,String replaceData,WebDriver driver)
{
	String requiredXpath=String.format(dynamicXpath,replaceData);
	WebElement element=driver.findElement(By.xpath(requiredXpath));
	return element;
}
/**
 * This method is used to initialize the java script executor
 * @param driver
 * @author PAAVANI
 */
public void jsIntialization(WebDriver driver)
{
	jsExecutor = (JavascriptExecutor) driver;
	
}
/**
 * This method is used to open the application by using java script executor
 * @param url
 * @author PAAVANI
 */
public void openApplicationUsingJS(String url)
{
	jsExecutor.executeScript("window.location=arguments[0]",url);
}
/**
 * This method is used to send data in textField by using java script executor
 * @param element
 * @param data
 * @author PAAVANI
 */

public void sendKeysUsingJS(WebElement element,String data)
{
	jsExecutor.executeScript("arguments[0].value=arguments[1]",element,data);

}
/**
 * This method is used to click the element by using java script executor
 * @param element
 * @author PAAVANI
 */
public void clickUsingJS(WebElement element)
{
	jsExecutor.executeScript("arguments[0].click()",element);
}
/**
 * This method is used to scroll till element is view by using java script executor
 * @param element
 * @author PAAVANI
 */
public void scrollTillElementViewUsingJS(WebElement element)
{
	jsExecutor.executeScript("arguments[0].scrollIntoView()",element);
	
}
/**
 * This method is used to Initialize the dropdown
 * @param element
 * @author PAAVANI
 */
public void dropdownIntialization(WebElement element)
{
	s=new Select(element);
}
/**
 * This method is used to select visible text in dropdown
 * @param element
 * @param text
 * @author PAAVANI
 */
public void dropdown(String text)
{

	s.selectByVisibleText(text);
	
}
/**
 * This method is used to select by index in dropdown
 * @param index
 * @author PAAVANI
 */
public void dropdown(int index)
{
	s.selectByIndex(index);
	
	
}

/**
 * This method is used to validation part by using assert based on string
 * @param actualdata
 * @param expecteddata
 * @author PAAVANI
 */
public void getValidationByAssertBasedOnString(String actualdata, String expecteddata)
{
	Assert.assertEquals(actualdata, expecteddata);
}
/**
 * This method is used to validation part by using assert based on integer
 * @param actualdata
 * @param expecteddata
 * @author PAAVANI
 */
public void getValidationByAssertBasedOnInt(int actualdata, int expecteddata)
{
	Assert.assertEquals(actualdata, expecteddata);
}

/**
 * This method is used to take a screenshot
 * @param driver
 * @param javautility
 * @param className
 * @throwsIOException
 * @author PAAVANI  
 */
public void screenShotLocalSystem(WebDriver driver,JavaUtility javautility,String className) throws IOException
{
	String currentTime=javautility.currentTime();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./screenshot/"+className+"_"+currentTime+".png");
	FileUtils.copyFile(src, dst);
	
	
	
}
/**
 * This method is used to take a screenshot
 * @param driver
 * @author PAAVANI  
 */

public String screenShotInBase64(WebDriver driver)
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	String tempPath=ts.getScreenshotAs(OutputType.BASE64);
	return tempPath;
}


}




