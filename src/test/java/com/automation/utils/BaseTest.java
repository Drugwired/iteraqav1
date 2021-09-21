package com.automation.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected static WebDriver driver;
	protected static ReadFromProperties prop;
	protected static ReadFromExcel excel;
	protected static HelperUtils helper;
	protected static String[][] userdata;
	protected static String[][] asserts;
	
	//String browserName = prop.getBrowserName();
	
	@BeforeSuite
	@Parameters({"browser","browserType"})
	public void setup(String browserName, @Optional("regular") String browserType)
	{
		prop = new ReadFromProperties();
		helper = new HelperUtils();
		excel = new ReadFromExcel();
		
		userdata = excel.readExcel(prop.getUserDataSheet());
		asserts = excel.readExcel(prop.getAssetsDataSheet());
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",prop.getChromeDriverPath());
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		System.setProperty("webdriver.edge.driver",prop.getEdgeDriverPath());
		driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",prop.getFireFoxDriverPath());
		driver = new FirefoxDriver();
		}
		else
			System.out.println("invalid browser type");
		
		driver.get(prop.getbaseURL());
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterSuite
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
