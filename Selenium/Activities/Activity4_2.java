package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_2 {

	public static void main(String[] args) {
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				
		        // Open the browser
		        driver.get("https://training-support.net/selenium/simple-form");
		        driver.manage().window().maximize();
		       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		        
		        //title of the page
		        String title = driver.getTitle();
		        System.out.println("Title of the page is "+title);
		        
		        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Lakshmi");
		        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("kamesh");
		        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("lakshmi@gmail.com");
		        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9791098866");
		        driver.findElement(By.xpath("//input[@type='submit']")).submit();
		        
			}

		}


	


