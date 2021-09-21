package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
	
	File file;
	FileInputStream fis;
	Properties prop;
	
	final String filePath = "./src/test/resources/Configuration/config.properties";
	
	public ReadFromProperties()
	{
		try
		{
			file = new File(filePath);
			fis = new FileInputStream(file);
			prop  = new Properties();
			prop.load(fis);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test input data files
	public String getTestInputFilePath()
	{
		return prop.getProperty("testdatafilepath");
	}
	public String getUserDataSheet()
	{
		return prop.getProperty("userdatasheet");
	}
	public String getAssetsDataSheet()
	{
		return prop.getProperty("assertdatasheet");
	}
	
	//Drivers paths
	public String getChromeDriverPath()
	{
		return prop.getProperty("chromepath");
	}
	public String getIEDriverPath()
	{
		return prop.getProperty("iepath");
	}
	public String getEdgeDriverPath()
	{
		return prop.getProperty("edgepath");
	}
	public String getFireFoxDriverPath()
	{
		return prop.getProperty("firefoxpath");
	}
	//Test Properties
	public String getbaseURL()
	{
		return prop.getProperty("baseURL");
	}
	public String getUserName()
	{
		return prop.getProperty("username");
	}
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	public String getBrowserName()
	{
		return prop.getProperty("browserName");
	}
	
}
