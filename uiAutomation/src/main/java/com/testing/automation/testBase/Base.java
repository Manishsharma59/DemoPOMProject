package com.testing.automation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base {
	
	private static final Logger log = Logger.getLogger(Base.class.getName());
	
	protected WebDriver driver;
	
	public WebDriver getDriver(){
		
		return driver;
	}
	
	private void setDriver(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("Firefox"))
		driver = initFirefox(url);		
		if(browserName.equalsIgnoreCase("Chrome"))
		driver = initFirefox(url);			
	}
	
	
	private static WebDriver initFirefox(String url){
		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		log.info("Creating object of Browser ");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	private static WebDriver initChrome(String url){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		log.info("Creating object of Browser ");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	@Parameters({"browserName","url"})
	@BeforeClass
	public void initilizeBrowserAndUrlSetUp(String browserName, String url){
		try {
			setDriver(browserName, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
