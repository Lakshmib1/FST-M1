package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		
        // Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        WebElement checkbx = driver.findElement(By.xpath("//input[@name='toggled']"));
        System.out.println("Checkbox is displayed or not "+checkbx.isDisplayed());
        
        driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
        
        WebElement checkbx1 = driver.findElement(By.xpath("//input[@name='toggled']"));
        System.out.println("Checkbox is displayed or not after remove clicked "+checkbx1.isDisplayed());
        
	}

}
