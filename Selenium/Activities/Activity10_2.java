package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10_2 {

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
        WebElement keypressed = driver.findElement(By.id("keyPressed"));
        
        Action actionseq = builder.sendKeys("S").build();
        actionseq.perform();
        String text = keypressed.getText();
        System.out.println("The pressed key is "+text);
        
      //Create action sequence for Spacebar
        Action actionSequence2 = builder
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSequence2.perform();
        String text1 = keypressed.getText();
        System.out.println("The pressed key is "+text1);
        

	}

}
