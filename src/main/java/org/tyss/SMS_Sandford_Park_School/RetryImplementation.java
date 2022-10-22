package org.tyss.SMS_Sandford_Park_School;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{
	int count=0;
	int maxReties=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxReties)
		{
			count++;
		}
		return false;
	}
	

}
