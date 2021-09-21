package com.automation.pages;

import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.SimpleLayout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PracticeForm {

	protected final WebDriver driver;
	
	public PracticeForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "name")
	WebElement nameTB;
	@FindBy(how = How.ID, using = "phone")
	WebElement mobileNumberTB;
	@FindBy(how = How.ID, using = "email")
	WebElement emailAddressTB;
	@FindBy(how = How.ID, using = "password")
	WebElement passwordTB;
	@FindBy(how = How.ID, using = "address")
	WebElement addressTB;
	@FindBy(how = How.NAME, using = "submit")
	WebElement submitButton;
	@FindBy(how = How.XPATH, using = "//input[@name='optionsRadios']/parent::label")
	List<WebElement> genderRB;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox'] [@class = 'form-check-input']")
	List<WebElement> weekdaysCB;
	@FindBy(how = How.CLASS_NAME, using = "custom-select")
	WebElement travelDestinationDD;
	@FindBy(how = How.CLASS_NAME, using = "custom-control-label")
	List<WebElement> yearOfExperienceRB;
	@FindBy(how = How.CLASS_NAME, using = "custom-control-label")
	List<WebElement> frameworkCB;
	@FindBy(how = How.ID, using = "inputGroupFile02")
	WebElement fileBrowseButton;
	@FindBy(how = How.CLASS_NAME, using = "input-group-text")
	WebElement fileUploadButton;

	public void writeName(String name) {
		nameTB.sendKeys(name);
	}

	public void writeMobileNumber(String mobileNumber) {
		mobileNumberTB.sendKeys(mobileNumber);
	}

	public void writeEmailAddress(String emailAddress) {
		emailAddressTB.sendKeys(emailAddress);
	}

	public void writePassword(String password) {
		passwordTB.sendKeys(password);
	}

	public void writeAddress(String address) {
		addressTB.sendKeys(address);

	}

	public void clickSubmit() {
		submitButton.click();
	}

	public void genderRB(String gender) {
		for (WebElement option : genderRB) {
			if (option.getText().trim().equalsIgnoreCase(gender)) {
				option.click();
				break;
			}
		}
	}

	public void weekdaysCB(String weekday) {
		for (WebElement option : weekdaysCB) {
			if (option.getAttribute("id").equalsIgnoreCase(weekday)) {
				option.click();
				break;
			}
		}
	}

	public void travelDestinationDD(String destination) {
		Select select = new Select(travelDestinationDD);
		List<WebElement> option = select.getOptions();
		for (int i = 0; i < option.size(); i++) {
			if (option.get(i).getText().equalsIgnoreCase(destination)) {
				select.selectByIndex(i);
				break;
			}
		}
	}

	public void yearOfExperienceRB(String experience) {
		for (WebElement option : yearOfExperienceRB) {
			String exp = experience.toLowerCase();
			if (option.getText().contains(exp)) {
				option.click();
				break;
			}
		}
	}

	public void frameworkCB(String frameworks) {
		for (WebElement option : frameworkCB) {
			String frmwrk = frameworks.toLowerCase();
			if (option.getText().equalsIgnoreCase(frmwrk)) {
				option.click();
				break;
			}
		}
	}

	public void fileBrowseButton(String filePath) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("alert('enter correct login credentials to continue');");
			// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			// js.executeScript("arguments[0].scrollIntoView(true);", fileBrowseButton);
			// js.executeScript("document.getElementById('inputGroupFile02').click();");
			// Actions actions = new Actions(driver);
			// actions.click(fileBrowseButton);
			js.executeScript("window.scrollBy(0,1000)");
			System.out.println(fileBrowseButton.isDisplayed());
			System.out.println(fileBrowseButton.isEnabled());
			System.out.println(fileBrowseButton.isSelected());
			//logger.debug("Test log");
			//logger.warn("Test log");
			//logger.fatal("Test log");
			//logger.info("Test log");
			
			// WebDriverWait wait = new WebDriverWait(driver, 30);
			// wait.until(ExpectedConditions. elementToBeClickable(fileBrowseButton));
			fileBrowseButton.click();
			// fileBrowseButton.sendKeys(filePath);
			// Runtime.getRuntime().exec("./AutoIT/FilePicker.exe"+" "+filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileUploadButton() {
		fileUploadButton.click();
	}
	
	
}
