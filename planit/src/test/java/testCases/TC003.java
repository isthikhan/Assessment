package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.commonfunctions;
import pageObject.loginpage;

public class TC003 extends commonfunctions {
	
	final static Logger log = Logger.getLogger(TC003.class.getName());
	
	@Test	
	public void scenariothird() throws Exception {
		
		Reporter.log("Click on the ‘login’ link");
		log.debug("Click on the ‘login’ link");
		loginpage lp = new loginpage(driver);
		lp.clickLogin();
		
		String userName = getPropertyValue("username");
		
		Reporter.log("enter any username, and the password ");
		log.debug("enter any username, and the password ");
		lp.setUserName(userName);
		lp.setPassword(getPropertyValue("password"));
		
		Reporter.log("Click login ");
		log.debug("Click Login");
		lp.clickSubmit();
		
		
		Reporter.log("Verify the name of the logged in user");
		log.debug("Verify the name of the logged in user");
		Assert.assertEquals(lp.getUserName(), userName);
	}
	

}
