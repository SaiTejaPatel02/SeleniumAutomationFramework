package com.mystore.testcases;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//import org.testng.annotations.Test;
import org.testng.annotations.*;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAcccount;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled=false)
	public void verifyRegistrationAndLogin() 
	{
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on Signin");

		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterEmail("TestDemo1@nomail.com");
		logger.info("Entered Email Id");
		//Thread.sleep(2000);
		myAcpg.clickSubmitCreate();
		logger.info("Clicked on create Acc");
		
		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		accCreationPg.selectTitleMr();
		accCreationPg.enterFirstName("Test");
		accCreationPg.enterLastName("Demo");
		accCreationPg.enterPasssword("Test.123");
		logger.info("Entered User Details on Account Creation Page");
		accCreationPg.clickRegister();
		logger.info("Clicked on Register Button");
		
		registeredUserAcccount regUser = new registeredUserAcccount(driver);
		String userName = regUser.getUserName();
		assertEquals("Test Demo", userName);
		logger.info("Verify User Account Added");
		
		
	}
	@Test
	public void VerifyLogin() throws Exception
	{
		logger.info("VerifyLogin test execution started");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on Signin");

		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterEmailAddress("TestDemo1@nomail.com");
		logger.info("Entered EmailId");
		myAcpg.enterPassword("Test.123");
		logger.info("Entered Password");
		myAcpg.clickSubmit();
		logger.info("Clicked on Signin");
		
		registeredUserAcccount regUser = new registeredUserAcccount(driver);
		String userName = regUser.getUserName();
		if(userName.equals("Test Demo1")) 
		{
			logger.info("VerifyLogin - Passed");
			assertTrue(true);
		}else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			assertTrue(false);
		}

	}
}
