package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10_3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://training-support.net/selenium/drag-drop");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        Actions builder = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//img[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement drop2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));
        //wait.until(ExpectedConditions.elementToBeClickable(drag));
        builder.dragAndDrop(drag, drop).build().perform();
        System.out.println("Drag and drop successful");
        
        String text = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        if(text.contains("Dropped"))
        {
        	System.out.println("the ball is dragged and dropped correctly");
        }
        else
        {
        	System.out.println("There is a problem");
        }
        builder.dragAndDrop(drop, drop2).build().perform();
        System.out.println("Drag and drop successful - 2");
        
        String text2 = driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText();
        if(text2.contains("Dropped"))
        {
        	System.out.println("the ball is dragged and dropped correctly");
        }
        else
        {
        	System.out.println("There is a problem");
        }
        

	}

}
