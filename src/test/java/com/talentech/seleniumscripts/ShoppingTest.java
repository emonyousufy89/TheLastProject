package com.talentech.seleniumscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ShoppingTest {
	
  WebDriver driver;
  
  @BeforeMethod         //annotations
  public void setUp() throws InterruptedException {
	  
	  
	    System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");		
		
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new FirefoxDriver();		
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		driver.navigate().to("https://www.usps.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
	  
  }

  
  @Test
  public void testCardShopping() {
	  
	  
	  double expectedTotalPrice = 109.75;
	  
	  
	//chain of actions 
		Actions action = new Actions (driver);
		WebElement menuItem =  driver.findElement(By.linkText("Mail & Ship"));
		action.moveToElement(menuItem);
		
		//Thread.sleep(5000);
		
		WebElement subMenuItem =  driver.findElement(By.linkText("Stamps & Supplies"));
		action.moveToElement(subMenuItem);
		
		//Thread.sleep(5000);
		
		action.click().build().perform();
		
		
		
		
		//WebElement cardsEnvlink = driver.findElement(By.xpath("//a/img[@src='https://www.usps.com/store/images/ps-subicon-cards.png']"));
		WebElement cardsEnvlink = driver.findElement(By.partialLinkText("Cards"));
		cardsEnvlink.click();
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement checkprodtype = driver.findElement(By.xpath("//label[contains(text(),'Greeting & Note Cards (27)')]"));
		js.executeScript("arguments[0].scrollIntoView();", checkprodtype);
		checkprodtype.click();
		
		
		WebElement selectTheme = driver.findElement(By.xpath("//label[contains(text(),'Commemorative (6)')]"));
		js.executeScript("arguments[0].scrollIntoView();", selectTheme);
		selectTheme.click();
		
		WebElement selectYear = driver.findElement(By.xpath("//label[contains(text(),'2018 (2)')]"));
		js.executeScript("arguments[0].scrollIntoView();", selectYear);
		selectYear.click();
		
		WebElement selectQuantity = driver.findElement(By.xpath("//label[contains(text(),'1 through 10 (2)')]"));
		js.executeScript("arguments[0].scrollIntoView();", selectQuantity);
		selectQuantity.click();
		
		WebElement selectColor = driver.findElement(By.xpath("//div[@style = 'background-color:#228b22;']"));
		js.executeScript("arguments[0].scrollIntoView();", selectColor);
		System.out.println("Color :" + selectColor.getCssValue("background-color"));
		
		selectColor.click();
		
		
		WebElement birdNwinCard = driver.findElement(By.xpath("//div[contains(text(),'Birds in Winter Notecards')]"));
		js.executeScript("arguments[0].scrollIntoView();", birdNwinCard);
		birdNwinCard.click();
		
		
		WebElement incQuant = driver.findElement(By.xpath("//span[@class='quantity-stepup']"));
		
		for(int i = 1 ;i <5;i++){
			incQuant.click();
		}
		
		
		WebElement totalPrice = driver.findElement(By.xpath("//span[@id='totalPrice']"));
		
		
		String actualvalstr = totalPrice.getText();
		String modstr = actualvalstr.replace("$", "");

		System.out.println(" Total Price :"+ totalPrice.getText() );
		
		
		double actauldoubleval = Double.parseDouble(modstr);
		 
		System.out.println(" Double Price :"+ actauldoubleval );
		
		 Assert.assertEquals(expectedTotalPrice, actauldoubleval);
		
		
		
		
  }
  
  
  @AfterMethod
  public void tearDown() {
	  
	  driver.quit();
	  
  }
  
  

}
