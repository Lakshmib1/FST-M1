package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12_1 {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		// Open the browser
		driver.get("https://www.training-support.net/selenium/iframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		driver.switchTo().frame(0);
		WebElement firstbutton = driver.findElement(By.xpath("(//button[@id='actionButton'])[1]"));
		
		System.out.println("The button text is "+firstbutton.getText());
		System.out.println("The color of the button is "+firstbutton.getCssValue("background-color"));
		firstbutton.click();
		System.out.println("The button text is "+firstbutton.getText());
		System.out.println("The color of the button is "+firstbutton.getCssValue("background-color"));
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement secondbutton = driver.findElement(By.xpath("(//button[@id='actionButton'])[1]"));
		
		System.out.println("The button text is "+secondbutton.getText());
		System.out.println("The color of the button is "+secondbutton.getCssValue("background-color"));
		secondbutton.click();
		System.out.println("The button text is "+secondbutton.getText());
		System.out.println("The color of the button is "+secondbutton.getCssValue("background-color"));
		driver.switchTo().defaultContent();
	}
	

}
