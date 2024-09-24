package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

	
	//create object of web driver
			WebDriver ldriver;
			
			public myAccount(WebDriver rdriver)
			{
				ldriver = rdriver;
						PageFactory.initElements(rdriver, this);
			}

			//Identifying web elements 
			//For New User
			@FindBy(id = "email_create") WebElement createEmailId;
			
			@FindBy(id = "SubmitCreate") WebElement SubmitCreate;
			
			
			//Existing User
			@FindBy(id = "email") WebElement registeredUsersEmail;
			@FindBy(id = "passwd") WebElement registeredUsersPwd;
			@FindBy(id = "SubmitLogin") WebElement submitLogin;
			
			//Identify action/Method on web element
			//New user Register methods
			public void enterEmail(String emailAdd) {
				createEmailId.sendKeys(emailAdd);;
			}
			
			public void clickSubmitCreate() {
				SubmitCreate.click();
			}
			
			//Existing user  methods
			public void enterEmailAddress(String emailAdd) {
				registeredUsersEmail.sendKeys(emailAdd);;
			}
			
			public void enterPassword(String pwd) {
				registeredUsersPwd.sendKeys(pwd);
			}
			
			public void clickSubmit()
			{
				submitLogin.click();
			}

}
