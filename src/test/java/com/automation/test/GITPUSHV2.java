package com.automation.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.utils.BaseTest;


public class GITPUSHV2 extends BaseTest {
	
	protected HomePage hm = null;
	
	@Test
	public void clickonTestAutomation() {
		helper.startTestCase("clickonTestAutomation");
		
		Assert.assertEquals(helper.getPageTitle(driver), asserts[1][1]);
		hm = new HomePage(driver);
		hm.clickTestAutomation();
		helper.info("Navigated to Automation page");
		helper.endTestCase("clickonTestAutomation");
		
	}
}
