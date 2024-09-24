package com.mystore.testcases;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAcccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTest extends BaseClass {

	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on Signin");

		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterEmail("TestDemo1@nomail.com");
		logger.info("Entered Email Id");
		// Thread.sleep(2000);
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

	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String userEmail, String userPwd, String expectedUserName) throws Exception {
		logger.info("VerifyLogin test execution started");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on Signin");

		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterEmailAddress(userEmail);
		logger.info("Entered EmailId");
		myAcpg.enterPassword(userPwd);
		logger.info("Entered Password");
		myAcpg.clickSubmit();
		logger.info("Clicked on Signin");

		registeredUserAcccount regUser = new registeredUserAcccount(driver);
		String userName = regUser.getUserName();
		if (userName.equals(expectedUserName)) {
			logger.info("VerifyLogin - Passed");
			assertTrue(true);

			regUser.clickOnSignOut();

			logger.info("Cliked on SignOut");
		} else {
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver, "VerifyLogin");
			assertTrue(false);
		}

	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		// System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "/TestData/MyStoreTestData.xlsx";

		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

		String data[][] = new String[ttlRows][ttlColumns];

		for (int i = 1; i < ttlRows; i++)// rows =1,2
		{
			for (int j = 0; j < ttlColumns; j++)// col=0, 1,2
			{

				data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}

		}
		return data;
	}
}
