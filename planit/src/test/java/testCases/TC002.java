package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.commonfunctions;
import pageObject.contactpage;

public class TC002 extends commonfunctions {

	final static Logger log = Logger.getLogger(TC002.class.getName());
	
	@Test
	@Parameters({"userName","surName","stremail","phoneNumber","strmessage"})
	public void ScenarioTwo(String userName,String surName,String stremail,String phoneNumber,String strmessage) { 
		
		Reporter.log("Navigating to Contact");
		log.debug("Navigating to Contact");
		contactpage cp = new contactpage(driver);
		cp.clickContact();
		
		Reporter.log("Enter valid data in all 5 fields");
		log.debug("Enter valid data in all 5 fields");
		cp.enterValues(userName,surName,stremail,phoneNumber,strmessage);
		
		Reporter.log("Click submit");
		log.debug("Click Submit");		
		cp.clickSubmit();
		
		Reporter.log("Verify the success message");
		log.debug("Verify the success message");
		Assert.assertEquals(cp.getAlertMessage(),"Thanks " + userName + ", we appreciate your feedback.");	
	}
	
}
