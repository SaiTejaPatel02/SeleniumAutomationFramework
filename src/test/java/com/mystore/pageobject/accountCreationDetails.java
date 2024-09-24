package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {

	
	//create object of web driver
			WebDriver ldriver;
			
			public accountCreationDetails(WebDriver rdriver)
			{
				ldriver = rdriver;
						PageFactory.initElements(rdriver, this);
			}

			//Identifying web elements
			@FindBy(id = "id_gender1") WebElement titleMr;
			@FindBy(id = "customer_firstname") WebElement firstName;
			@FindBy(id = "customer_lastname") WebElement lastName;
			@FindBy(id = "passwd") WebElement password;
			@FindBy(id = "submitAccount") WebElement register;
			
			
			//Identify action/Method on web element
			public void selectTitleMr() {
				titleMr.click();
			}
			
			public void enterFirstName(String fname) {
				firstName.sendKeys(fname);
			}
			
			public void enterLastName(String lName) {
				lastName.sendKeys(lName);
			}
			
			public void enterPasssword(String pwd) {
				password.sendKeys(pwd);
			}
			
			public void clickRegister() {
				register.click();;
			}
			

}
