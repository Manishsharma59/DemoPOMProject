package com.testing.automation.customListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.testing.automation.testBase.TestBase;

public class Listner extends TestBase implements ITestListener{

	public static final Logger log = Logger.getLogger(Listner.class.getName());
	
	
	/*
	  WebDriver driver;
	public Listner(WebDriver driver){
		this.driver=driver;
	}*/

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if(!result.isSuccess()){
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		String screenShotPath = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/testing/automation/FailureScreenShot/";
		File destFile = new File((String)screenShotPath+methodName+"_"+formater.format(calendar.getTime())+".png");
		FileUtils.copyFile(srcFile, destFile);
		Reporter.log("<a href = '"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"' height = '100' width = '100'/></a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
