package alchemy.activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
        // Open the browser
        driver.get("https://training-support.net/selenium/tables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        
        System.out.println("The number of rows in the table is "+rows.size());
        System.out.println("The number of cols in the table is "+cols.size());
        
        WebElement second = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second col value is "+second.getText());
        
        //click the name header for sorting
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        
        WebElement second1 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second col value after sorting is "+second1.getText());
        
        
	}

}
