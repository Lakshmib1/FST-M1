package alchemy.activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9_2 {

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
        
        WebElement multi = driver.findElement(By.xpath("//select[@id='multi-select']"));
        Select select = new Select(multi);
        //       Chosen option
        WebElement chosen = driver.findElement(By.id("multi-value"));
        
        if(select.isMultiple())
        {
        	//Select 'JavaScript' by Visible text
            select.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());
            
            select.deselectByValue("node");
            System.out.println(chosen.getText());
            
          //Select 4,5, and 6 options by index
            for(int i=4; i<=6; i++) {
                select.selectByIndex(i);
            }
            System.out.println(chosen.getText());
    
            //Deselect 'NodeJS' by value
            select.deselectByValue("node");
            System.out.println(chosen.getText());
            
            //Deselect 7th opttion by index
            select.deselectByIndex(7);
            System.out.println(chosen.getText());
            
            //Get all selected options
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            //Print all selected options
            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }
            
            //Deselect all options
            select.deselectAll();
            System.out.println(chosen.getText());
        }

	}

}
