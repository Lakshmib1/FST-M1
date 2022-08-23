package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10_1 {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://www.training-support.net/selenium/input-events");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        Actions builder = new Actions(driver);
        
        WebElement cube = driver.findElement(By.xpath("//div[@id='wrapD3Cube']"));
        WebElement cubenum = driver.findElement(By.xpath("//div[@id='D3Cube']"));
                
        //Left click and print the value of the side in the front.
        builder.click(cube).perform();
        System.out.println("The number in the cube is "+cubenum.getText());
        
      //Find the cude
        WebElement cube1 = driver.findElement(By.id("wrapD3Cube"));
 
        //Left click
        builder.click(cube1).perform();
        WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + cubeVal.getText());
        
        //rightclick
        builder.contextClick(cube1).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Right Click: " + cubeVal.getText());
       
        //doubleclick
        builder.doubleClick(cube1).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Double Click: " + cubeVal.getText());
        
	}

}
