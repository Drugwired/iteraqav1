package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected final WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using= "Home")
	WebElement homeLT;
	@FindBy(how = How.LINK_TEXT, using= "Practice")
	WebElement practiceLT;
	@FindBy(how = How.LINK_TEXT, using= "Test Automation")
	WebElement testAutomationLT;
	@FindBy(how = How.LINK_TEXT, using= "Tutorial")
	WebElement tutorialLT;
	@FindBy(how = How.LINK_TEXT, using= "Sign Up")
	WebElement signUpLT;
	@FindBy(how = How.LINK_TEXT, using= "Login")
	WebElement loginsLT;
	@FindBy(how = How.CSS, using= "input[placeholder='Search']")
	WebElement searchTB;
	@FindBy(how = How.CSS, using= "button[type='submit']")
	WebElement searchButton;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using= "Read more")
	WebElement readMoreLT;
	
	public void clickHome()
	{
		homeLT.click();
	}
	public void clickPractice()
	{
		practiceLT.click();
	}
	public void clickTestAutomation()
	{
		testAutomationLT.click();
	}
	public void clickTutorial()
	{
		tutorialLT.click();
	}
	public void clickSignUp()
	{
		signUpLT.click();
	}
	public void clickLogin()
	{
		loginsLT.click();
	}
	public void writeSearchKey(String searchKey)
	{
		searchTB.sendKeys(searchKey);
	}
	public void clickSearch()
	{
		searchButton.click();
	}
	public void clickReadMore()
	{
		readMoreLT.click();
	}
	
}
