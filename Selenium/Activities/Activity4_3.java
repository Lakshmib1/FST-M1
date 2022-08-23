package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		
        // Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        WebElement thirdheader = driver.findElement(By.xpath("//h3[text()='Third header']"));
        System.out.println("Third header text is "+thirdheader.getText());
        
        WebElement fifthheader = driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        System.out.println("The CSS property is "+fifthheader.getCssValue("color"));
        
        WebElement voilet = driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println("The class property is " +voilet.getAttribute("class"));
        
        WebElement greybutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("the text on grey button is " +greybutton.getText());
	}

}
