package com.talentech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SdarkPage {

	//public WebDriver Idriver;
	
	public SdarkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() {
		lnkLogout.click();
	}
}
