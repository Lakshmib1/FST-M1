package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		// Open the browser
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement firstelement = driver.findElement(By.id("actionButton"));
		System.out.println(firstelement.getText());
		firstelement.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		WebElement secondElement = driver.findElement(By.id("actionButton"));
		System.out.println(secondElement.getText());
		secondElement.click();
		driver.switchTo().defaultContent();
		
	}

}
