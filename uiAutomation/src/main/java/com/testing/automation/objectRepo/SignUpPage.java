package com.testing.automation.objectRepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends HomePage{
	
	public static final Logger log = Logger.getLogger(SignUpPage.class.getName());
	private WebDriver driver;

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
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String signUpPageTitle(){
		
		return driver.getTitle();
	}
	
	public void signUp(String firstName,String lastName, String email, String password, String mobile){
		
		signUpBtn.click();
		log.info("FirstName - " + firstName.toString());
		firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys(firstName);
		
		log.info("LastName - " + lastName.toString());
		lastNameTxtBox.clear();
		lastNameTxtBox.sendKeys(lastName);
		
		log.info("Email - " + email.toString());
		emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
		
		log.info("Password - " + pwdTxtBox.toString());
		pwdTxtBox.clear();
		pwdTxtBox.sendKeys(password);
		
		log.info("Mobile - " + mobile.toString());
		mobileTxtBox.clear();
		mobileTxtBox.sendKeys(mobile);
		
		//signUpSubmitBtn.click();
	}
	
	public HomePage navigateToHomePage(){
		closeSignUp.click();
		return new HomePage(driver);
	}

	public String errorMsgText(){
		
		return ErrorMsg.getText();
	}


}
