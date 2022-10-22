package org.tyss.SMS_Sandford_Park_School;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;



public class RetryToListener implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod)
	{
	annotation.setRetryAnalyzer(org.tyss.SMS_Sandford_Park_School.RetryImplementation.class);	
	}
	
	
	

}
