package com.testing.automation.homePage;


import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.automation.objectRepo.HomePage;
import com.testing.automation.objectRepo.SignUpPage;
import com.testing.automation.testBase.TestBase;

public class TC001_SignUp_Validation extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC001_SignUp_Validation.class.getName());
	 HomePage homePage;
	 SignUpPage signUpPage;
	
	@DataProvider(name = "signUpData")
	public String [][] dataFromExcel(){
		
		String [][] testData = getDataFromExcel("TestData.xlsx", "Sheet1");
		return testData;
	}
	
	@BeforeClass
	@Parameters({"browserName","url"})
	public void setUp(String browserName, String url){
		setDriver(browserName, url);
	}
	
	@Test(dataProvider="signUpData")
	public void signUp_Validation(String firstName, String lastName, String email, String password, String mobile, String runMode){
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("UserMarked this record as no run");
		}
		log("Starting Test");
		homePage = new HomePage(driver);
		homePage.navigateToSignUpPage(); 
		signUpPage = new SignUpPage(driver);
		signUpPage.signUp(firstName, lastName, email, password, mobile);
		signUpPage.navigateToHomePage();
		screenShot("signUp_Validation");
		//signUpPage.signUp("Manish", "Sharma", "er.manishsharma95@rediffmail.com", "Wizardry@123", "8527409595");
		//Assert.assertTrue(signUpPage.errorMsgText().toString().contains("A record matching 'er.manishsharma95@rediffmail.com' was found"));
		log("Finished Test");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
public void log(String logMessage){
		
		log.info(logMessage);
		Reporter.log(logMessage);
		
	}
}
