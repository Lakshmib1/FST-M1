package alchemy.activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://training-support.net/selenium/selects");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='single-select']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        
        WebElement singletext = driver.findElement(By.xpath("//h3[@id='single-value']"));
        System.out.println(singletext.getText());
        
        select.selectByIndex(2);
        System.out.println(singletext.getText());
        
        select.selectByValue("4");
        System.out.println(singletext.getText());
        
        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options) {
        	String text = webElement.getText();
        	System.out.println(text);
			
		}
        
        
        
        

	}

}
