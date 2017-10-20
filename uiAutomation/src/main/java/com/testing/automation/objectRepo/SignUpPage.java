package com.testing.automation.objectRepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.testing.automation.testBase.TestBase;

public class SignUpPage extends TestBase{
	
	WebDriver driver;
	public static final Logger log = Logger.getLogger(SignUpPage.class.getName());

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
	
	@FindBy(xpath = "//*[@id='btn-signup']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//*[@id='popup-error-container']/ul/li")
	WebElement ErrorMsg;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement closeSignUp;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String signUpPageTitle(){
		
		return driver.getTitle();
	}
	
	public void signUp(String firstName,String lastName, String email, String password, String mobile){
		
		waitForElement(60, firstNameTxtBox);
		log("FirstName - " + firstNameTxtBox.toString());
		firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys(firstName);
		
		waitForElement(60, lastNameTxtBox);
		log("LastName - " + lastNameTxtBox.toString());
		lastNameTxtBox.clear();
		lastNameTxtBox.sendKeys(lastName);
		
		waitForElement(60, emailTxtBox);
		log("Email - " + emailTxtBox.toString());
		emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
		
		waitForElement(60, pwdTxtBox);
		log("Password - " + pwdTxtBox.toString());
		pwdTxtBox.clear();
		pwdTxtBox.sendKeys(password);
		
		waitForElement(60, mobileTxtBox);
		log("Mobile - " + mobileTxtBox.toString());
		mobileTxtBox.clear();
		mobileTxtBox.sendKeys(mobile);
		
		//signUpSubmitBtn.click();
	}
	
	public void navigateToHomePage(){
		closeSignUp.click();
	}

	public String errorMsgText(){
		
		return ErrorMsg.getText();
	}

	public void log(String logMessage){
		
		log.info(logMessage);
		Reporter.log(logMessage);
		
	}
}
