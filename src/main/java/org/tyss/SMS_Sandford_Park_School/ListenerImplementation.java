package org.tyss.SMS_Sandford_Park_School;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private ExtentReports reports;
	private static ExtentTest stest;
	private ExtentTest test;

	@Override//@BM
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" fail");
		System.out.println(Thread.currentThread().getId());
		
			try {
				new WebDriverUtility().screenShotLocalSystem(BaseClassforAdmin.sdriver,BaseClassforAdmin.sjavaUtility,result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.skip("Test1 skip");
		test.fail(result.getThrowable());
	}

	@Override//AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override//BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-SMS");
		spark.config().setReportName("Report Name-SMS");
		spark.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author","Paavani");
		reports.setSystemInfo("OS","Windows 10");
		reports.setSystemInfo("Browser","Chrome");
	}
		
		
		

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}
	

}
