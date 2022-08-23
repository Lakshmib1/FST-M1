package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        WebElement chkbox = driver.findElement(By.xpath("//input[@name='toggled']"));
        WebElement toggle = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        
        toggle.click();
        wait.until(ExpectedConditions.invisibilityOf(chkbox));
        
        toggle.click();
        
        wait.until(ExpectedConditions.visibilityOf(chkbox));
        chkbox.click();
        
	}

}
