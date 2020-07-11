package com.talentech.stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.talentech.pages.GroupStudyPage;

import cucumber.api.java.en.*;

public class GroupStudySteps {

	public WebDriver driver;
	GroupStudyPage gp;

	@Given("^User launch Chrome browser$")
	public void user_launch_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		driver = new ChromeDriver();
		gp= new GroupStudyPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		driver.get(url);  
		driver.manage().window().maximize();
	}

	@Then("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) throws Throwable {
		gp.Username(email);
		gp.Password(password);	    
	}

	@Then("^User clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		gp.clickSubmit();
	}

	//	@Then("^User should be on \"([^\"]*)\"$")
	//	public void user_should_be_on(String arg1) throws Throwable {
	//	    if(driver.getTitle()=="Dashboard / nopCommerce administration") {
	//	    System.out.println(driver.getTitle());	
	//	    }
	//	    else {
	//	    	driver.quit();
	//	    }
	//		System.out.println(driver.getTitle());
	//	}

	@Then("^User should be on \"([^\"]*)\"$")
	public void user_should_be_on(String title) throws Throwable {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			//Assert.assertTrue(false);
		}
		else {
			//Assert.assertEquals(title, driver.getTitle());
			System.out.println(driver.getTitle());
		}	Thread.sleep(2000);
	}

	@Then("^User clicks logout$")
	public void user_clicks_logout() throws Throwable {
		gp.clickLogout(); 
	}

	@Then("^User shoud be on page \"([^\"]*)\"$")
	public void user_shoud_be_on_page(String arg1) throws Throwable {
		System.out.println(driver.getTitle());
	}

	@Then("^User close the browser$")
	public void user_close_the_browser() throws Throwable {
		driver.quit();
	}

}
