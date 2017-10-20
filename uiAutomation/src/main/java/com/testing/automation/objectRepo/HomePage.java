package com.testing.automation.objectRepo;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.testing.automation.testBase.TestBase;



public class HomePage  extends TestBase{
	WebDriver driver;
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	@FindBy(xpath = "//*[text()='Signup']")
	WebElement signUpBtn;
		
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement firstNameTxtBox;
	
	@FindBy(xpath = "//*[@id='lastname']")
	WebElement lastNameTxtBox;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement emailTxtBox;
	
	@FindBy(xpath = "//*[@id='pwd']")
	WebElement pwdTxtBox;
	
	@FindBy(xpath = "//*[@id='mobile']")
	WebElement mobileTxtBox;
	
	
	@FindBy(xpath = "//*[@id='popup-error-container']/ul/li")
	WebElement ErrorMsg;
	

	public  HomePage(WebDriver driver){	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToSignUpPage(){
		log("Navigate to signup page");
		waitForElement(10, signUpBtn);
		signUpBtn.click();
	}
	
public void log(String logMessage){
		
		log.info(logMessage);
		Reporter.log(logMessage);
		
	}



}

