package com.automation.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.PracticeForm;
import com.automation.utils.BaseTest;


public class PracticeFormTest extends BaseTest {
	protected PracticeForm pf =null;
	
	@Test
	public void textareaPractice() {
		helper.startTestCase("textareaPractice");
		pf =new PracticeForm(driver);
		helper.info("started automation test");
		Assert.assertEquals(helper.getPageTitle(driver) , (asserts[2][1]).trim());
		
		pf.writeName(userdata[1][1]);
		pf.writeMobileNumber(userdata[2][1]);
		pf.writeEmailAddress(userdata[3][1]);
		pf.writePassword(userdata[4][1]);
		pf.writeAddress(userdata[5][1]);
		pf.clickSubmit();
		pf.genderRB(userdata[6][1]);
		pf.weekdaysCB(userdata[7][1]);
		pf.travelDestinationDD(userdata[8][1]);
		pf.yearOfExperienceRB(userdata[9][1]);
		pf.frameworkCB(userdata[10][1]);
		//pf.fileBrowseButton(userdata[11][1]);
		//pf.fileUploadButton();
		helper.endTestCase("textareaPractice");
	}
	
}
