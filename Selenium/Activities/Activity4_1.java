package alchemy.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
        // Open the browser
        driver.get("https://www.training-support.net");
		
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        driver.findElement(By.xpath("//a[text()='About Us']")).click();
        
        String title1 = driver.getTitle();
        System.out.println("Title of the new page is "+title1);
        
	}

}
