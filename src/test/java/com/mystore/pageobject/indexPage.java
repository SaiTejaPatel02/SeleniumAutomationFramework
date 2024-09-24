package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

		//create object of web driver
		WebDriver ldriver;
		
		public indexPage(WebDriver rdriver)
		{
			ldriver = rdriver;
					PageFactory.initElements(rdriver, this);
		}

		//Identifying web elements
		@FindBy(linkText = "Sign in") WebElement signIn;
		
		
		//Identify action/Method on web element
		public void clickOnSignIn() {
			signIn.click();
		}
}


