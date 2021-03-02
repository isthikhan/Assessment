package testCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.commonfunctions;
import pageObject.contactpage;


public class TC001 extends commonfunctions {
	
	final static Logger log = Logger.getLogger(TC001.class.getName());
	
	@Test	
	@Parameters({"userName","stremail","strmessage"})
	public void ScenarioOne(String userName,String stremail,String strmessage) {
		
		Reporter.log("Navigating to Contact");
		log.debug("Navigating to Contact");		
		
		contactpage cp = new contactpage(driver);
		cp.clickContact();		
		
		Reporter.log("Click Submit");
		log.debug("Click Submit");
		cp.clickSubmit();
			
		Reporter.log("Verify the error messages ");
		log.debug("Verify the error messages ");
	    assertTrue(cp.isNameErrorDisplayed());	
		assertTrue(cp.isEmailErrorDisplayed());
		assertTrue(cp.isMessageErrorDisplayed());
		
		Assert.assertEquals(cp.getNameError(), "Forename is required");
		Assert.assertEquals(cp.getEmailError(), "Email is required");
		Assert.assertEquals(cp.getMessageError(), "Message is required");
		
		Reporter.log("Verify the error messages have disappeared"); 
		log.debug("Verify the error messages have disappeared");
		cp.enterValues(userName,"",stremail,"",strmessage);
		
		assertFalse(cp.isNameErrorDisplayed());
		assertFalse(cp.isEmailErrorDisplayed());
		assertFalse(cp.isMessageErrorDisplayed());
		
	}
}
	


