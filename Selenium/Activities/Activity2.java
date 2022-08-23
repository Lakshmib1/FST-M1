package alchemy.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
        // Open the browser
        driver.get("https://www.training-support.net");
		
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        String text2 = driver.findElement(By.partialLinkText("About Us")).getText();
        System.out.println("text in the page is "+text2);
        String text3 = driver.findElement(By.id("about-link")).getText();
        System.out.println("text in the page is "+text3);
        String text4 = driver.findElement(By.className("green")).getText();
        System.out.println("text in the page is "+text4);
        
        //Find the About Us link using cssSelector()
        String cssLocator = driver.findElement(By.cssSelector(".green")).getText();
        System.out.println("Text in element: " +cssLocator );
        
	}

}
