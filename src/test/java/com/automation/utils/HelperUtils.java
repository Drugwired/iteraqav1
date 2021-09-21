package com.automation.utils;

import java.time.Duration;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class HelperUtils {
	private static Logger logger = LogManager.getLogger(HelperUtils.class);

	// fluent waits
	public WebElement fluentWait(final By locator, WebDriver driver, int timeOut) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(ElementNotVisibleException.class);

		// instead of assigning to a variable direclty returning webelement
		return fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// return foundElememt;
				return driver.findElement(locator);
			}
		});
	}

	public void log4J(String method, String message) {
		switch (method) {
		case "trace":
			logger.trace(message);
		case "info":
			logger.info(message);
		case "debug":
			logger.debug(message);
		case "warn":
			logger.warn(message);
		case "error":
			logger.error(message);
		case "fatal":
			logger.fatal(message);
		default:
			System.out.println("Invalid Input!");
		}

	}

	public void startTestCase(String testCaseName) {

		logger.info("*******************************************************************");
		logger.info("################### " + testCaseName + "STARTS" + "###################");
		logger.info("*******************************************************************");

	}

	// This is to print log for the ending of the test case

	public void endTestCase(String testCaseName) {
		logger.info("*******************************************************************");
		logger.info("################### " + testCaseName + "ENDS" + "###################");
		logger.info("*******************************************************************");
	}

	public void info(String message) {

		logger.info(message);

	}

	public void warn(String message) {

		logger.warn(message);

	}

	public void error(String message) {

		logger.error(message);

	}

	public static void fatal(String message) {

		logger.fatal(message);

	}

	public static void debug(String message) {

		logger.debug(message);

	}
	
	public String getPageTitle(WebDriver driver)
	{
	return driver.getTitle();
	}
}