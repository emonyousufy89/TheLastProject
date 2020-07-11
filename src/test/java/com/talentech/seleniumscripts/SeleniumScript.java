package com.talentech.seleniumscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumScript {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//instantiate the driver 
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");		
		
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new FirefoxDriver();		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		driver.navigate().to("https://www.usps.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		//----- using XPATH Locator-----------
		//WebElement srchBox =  driver.findElement(By.xpath("//input[@id = 'home-input']"));
		
		
		// -------------- using ID locator
		//WebElement srchBox =  driver.findElement(By.id("home-input"));
		
		
		//-------------- using NAME locator
		//WebElement srchBox =  driver.findElement(By.name("keyword"));  //wont work because name is not unique
		
		
		//------ using CLASS Locator ------
		//WebElement srchBox =  driver.findElement(By.className("search--track-input  form-control"));
		
		
//		WebElement srchBox =  driver.findElement(By.id("home-input"));
//		Thread.sleep(3000);
//		srchBox.sendKeys("1236123715635676");
//		
//		
//		Actions actions = new Actions(driver);
//		WebElement mainMenu = driver.findElement(By.linkText("Mail & Ship"));
//		actions.moveToElement(mainMenu);
//
//		WebElement subMenu = driver.findElement(By.linkText("Stamps & Supplies"));
//		actions.moveToElement(subMenu);
//		actions.click().build().perform();
		
		//
		
		
		
		
		
		
		
		
		
		//----------LinkText Locator -------------
//		WebElement clickNshipLink = driver.findElement(By.linkText("Click-N-Ship®"));
//		clickNshipLink.click();
//		
		
		//---------Partial LinkText Locator ---------------------
		
		
//		WebElement clickNshipLink = driver.findElement(By.partialLinkText("Click"));
//		clickNshipLink.click();
//		
//		
		
		
		
//		List< WebElement> listOfAllLinks = driver.findElements(By.tagName("a"));
//		
//		int noOflinks = listOfAllLinks.size();
//		
//		System.out.println("No of links on my homepage : " +  noOflinks);
//		
//		
//		WebElement srchBxHeader = driver.findElement(By.xpath("//h2[contains(text(),'Search or Track Packages')]"));
//		
//		String header =srchBxHeader.getText();
//		
//		System.out.println(" The header value is ---- " + header );
//		
//		
//		
//		
		
		//chain of actions 
		Actions action = new Actions (driver);
		WebElement menuItem =  driver.findElement(By.linkText("Mail & Ship"));
		action.moveToElement(menuItem);
		
		Thread.sleep(5000);
		
		WebElement subMenuItem =  driver.findElement(By.linkText("Stamps & Supplies"));
		action.moveToElement(subMenuItem);
		
		Thread.sleep(5000);
		
		action.click().build().perform();
		
		
		//--------------close the browser-----------------------
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		
//		
//		
//		//find searchBox
//		
//		WebElement srchBox = driver.findElement(By.id("home-input"));
//		Thread.sleep(3000);
//		srchBox.sendKeys("123710830128");
//		WebElement srchBtn = driver.findElement(By.xpath("//div[@class= 'col-lg-6  d-lg-block d-md-none d-sm-none d-none align-self-center']/form/span/div/div/button[@class = 'input--search btn']"));
//		Thread.sleep(3000);
//		srchBtn.click();
//		String status = driver.findElement(By.xpath("//div[@class= 'delivery_status']/h2/strong")).getText();
//		System.out.println("Search status : " + status);
//		
//		Thread.sleep(3000);
//		
		
		
		
	
		
	}

}
