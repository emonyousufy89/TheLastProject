package com.talentech.seleniumscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CardsEnvelopeShopping {
	
	
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
				
				
				//chain of actions 
				Actions action = new Actions (driver);
				WebElement menuItem =  driver.findElement(By.linkText("Mail & Ship"));
				action.moveToElement(menuItem);
				
				Thread.sleep(5000);
				
				WebElement subMenuItem =  driver.findElement(By.linkText("Stamps & Supplies"));
				action.moveToElement(subMenuItem);
				
				Thread.sleep(5000);
				
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
				
				System.out.println(" Total Price :"+ totalPrice.getText() );
				
				
				
				
				
				
				
				
				//--------------close the browser-----------------------
				Thread.sleep(5000);
				driver.quit();
		
	}

}
