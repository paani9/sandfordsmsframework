package org.practice;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus_Scenario {

	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in");
		
		WebElement src=driver.findElement(By.xpath("//input[@id='src']"));
		src.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		
		
		WebElement dest = driver.findElement(By.xpath("//input[@id='dest']"));
		dest.sendKeys("Hyderabad");
		driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
		dest.click();
		
		
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/descendant::td[text()='10']")).click();
		
      	driver.findElement(By.xpath("//button[@id='search_btn']")).click();
      	Thread.sleep(2000);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10L));
    	WebElement slide = driver.findElement(By.xpath("//span[text()='Introducing']"));
    	WebElement close = driver.findElement(By.xpath("//div[@class='close-primo']"));
   	wait.until(ExpectedConditions.visibilityOf(slide));
      	Actions act=new Actions(driver);
   	act.moveToElement(close);

  	close.click();
      	
      	int count=0;
      
      	
      	while(count<146)
      	{
      		int count1=0;
      	List<WebElement> busnames = driver.findElements(By.xpath("//div[@class='travels lh-24 f-bold d-color']"));
         	int size = busnames.size();
         	System.out.println(size);
      	for(WebElement busn:busnames)
      	{
      		
      		String buses=busn.getText();
      		System.out.println(buses);
//      		if(count1%4==0)
//      		{
      			

      			//act.moveToElement(c);
      		
   		JavascriptExecutor js=(JavascriptExecutor)driver;
      		//System.out.println("*************************"+buses);
		js.executeScript("arguments[0].scrollIntoView(true)",busn);
		//System.out.println(busn.getText());
//        count1=count1+4;
     	//	}
		count++;	
//      		
      	}
//    	
     	}
     	System.out.println(count);
		
	
	
}}
