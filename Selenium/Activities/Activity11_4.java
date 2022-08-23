package alchemy.activity;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity11_4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://www.training-support.net/selenium/tab-opener");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles.size());
        
        for (String handle : handles) {
			driver.switchTo().window(handle);
		}
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("Title of the new page is "+driver.getTitle());
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        for (String handle : handles) {
			driver.switchTo().window(handle);
		}
        driver.quit();
        
        
	}

}
