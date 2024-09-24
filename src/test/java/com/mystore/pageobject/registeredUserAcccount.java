package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAcccount {

	
	//create object of web driver
			WebDriver ldriver;
			
			public registeredUserAcccount(WebDriver rdriver)
			{
				ldriver = rdriver;
						PageFactory.initElements(rdriver, this);
			}

			//Identifying web elements
			@FindBy(xpath = "//a[@title='View my customer account']") WebElement userName;
			
			@FindBy(linkText = "Sign out") WebElement signOut;
			
			
			//Identify action/Method on web element
			public String getUserName() {
				String text = userName.getText();
				return text;
			}
			
			public void clickOnSignOut() {
				signOut.click();
			}

}
