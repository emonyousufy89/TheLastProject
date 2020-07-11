package com.talentech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupStudyPage {
	
	public GroupStudyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='Email']")
	WebElement insertEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement insertPasswd;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement clickLogin;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement clickLogout;	
	
	public void Username(String uname) {	
		insertEmail.clear();
		insertEmail.sendKeys(uname);
	}
	public void Password(String pwd) {
		insertPasswd.clear();
		insertPasswd.sendKeys(pwd);
	}
	public void clickSubmit() {
		clickLogin.click();
	}
	public void clickLogout() {
		clickLogout.click();
	}
}
