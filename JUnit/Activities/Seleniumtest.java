package junit.alchemy.activities;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Seleniumtest {
 	private static ChromeDriver driver;
 	WebElement element;
 	
 	

 @BeforeClass
 public static void openBrowser(){
     WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	} 

 @Test
 public void valid_UserCredential(){

	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("https://demoqa.com/login");	
     
     driver.findElement(By.id("userName")).sendKeys("lakshmi");
     driver.findElement(By.id("password")).sendKeys("Test123$$");
     driver.findElement(By.id("login")).click();
     try{
		 element = driver.findElement (By.xpath("//button[text()='Log out']"));
	 }catch (Exception e){
		}
     Assert.assertNotNull(element);
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @Test
 public void inValid_UserCredential()
 {
	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("https://demoqa.com/login");	
     
     driver.findElement(By.id("userName")).sendKeys("lakshmi");
     driver.findElement(By.id("password")).sendKeys("Test123$$");
     driver.findElement(By.id("login")).click();
     try{
		element = driver.findElement (By.xpath("//button[text()='Log out']"));
     }catch (Exception e){
		}
     Assert.assertNotNull(element);
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}

