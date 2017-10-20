package com.testing.automation.customListner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListner implements WebDriverEventListener {
	
	public static final Logger log = Logger.getLogger(WebEventListner.class.getName());

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		log("Value of  : "+element.toString()+ "after change");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log("Clicked on "+element.toString());
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		log("After find By  : "+arg0.toString()+ "'");
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		log("After Navigate Back  : '");
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		log("After Navigate Forward  : '");
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		log("After Navigate Refresh  : '");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigated to : "+url+ "'");
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		log("After Script  :"+arg0.toString()+" '");
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		log("Before alert Accept  : '");
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		log("Before alert Dismiss  : '");
		
	}


	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Trying to Click on "+element.toString());
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver driver) {
		log("Before Find By  : "+arg0.toString()+" '");
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		log("Before Navigate Back  : '");
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		log("Before Navigate Forward  : '");
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		log("Before Navigate Refresh  : '");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log("Before navigate to : "+url+ "'");
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		log("Before Script  : "+arg0+" '");
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		log("Value of  : "+arg0.toString()+ "before change");
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		log("Value of  : "+arg0.toString()+ "after change");
		
	}
	
	public void log(String logMessage){
		
		log.info(logMessage);
		Reporter.log(logMessage);
		
	}



}
