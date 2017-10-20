package com.testing.automation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testing.automation.readExcel.Excel_Read;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	protected WebDriver driver;
	Excel_Read excel;

	
public void setDriver(String browser, String url){
		selectBrowser(browser);
		getUrl(url);
		String log4jFilePath = "log4j.properties";
		PropertyConfigurator.configure(log4jFilePath);
	}
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			log.info("Creating object of Browser " +browser);
			driver = new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			
		      // Create object of HashMap Class
			Map<String, Object> prefs = new HashMap<String, Object>();
	              
	          // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);
	 
	          // Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
	           // Set the experimental option
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions-");
			log.info("Creating object of Browser " +browser);
			driver = new ChromeDriver(options);
		}
		
	}
	
	public void getUrl(String url){
		driver.get(url);
		log.info("Navigating to  " +url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	

	
	public String[][] getDataFromExcel(String workbookName,String sheetName){
		String path = System.getProperty("user.dir")+"/src/main/java/com/testing/automation/data/"+workbookName;
		excel  = new Excel_Read(path);
		String [][] data = excel.getSheetData(workbookName,sheetName);;
		return data;
	}
	
	
	public void waitForElement(int timeOutInSeconds, WebElement element){
		
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void screenShot(String ScreenShotname){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_mm_ss");
		
		try {
		 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 String screenshotPath = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/testing/automation/screenShot/";
		 File destFile = new File((String) screenshotPath+ScreenShotname+"_"+formater.format(calendar.getTime())+".png");
		 
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}














