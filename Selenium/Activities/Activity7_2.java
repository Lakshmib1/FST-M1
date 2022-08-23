package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);

        WebElement username = driver.findElement(By.cssSelector("input[class$='-username']"));
        username.sendKeys("lakshmi");
        WebElement password = driver.findElement(By.cssSelector("input[class $= '-password']"));
        password.sendKeys("lakshmi");
        driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys("lakshmi");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        
        driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("lakshmi");
        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("lakshmi");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement findElement = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        System.out.println("The confirmation text is "+findElement.getText());
        
        
	}

}
