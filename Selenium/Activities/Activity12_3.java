package alchemy.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12_3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		// Open the browser
		driver.get("https://www.training-support.net/selenium/popups");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		//title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		Actions builder = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//button[@onclick = 'openModal()']"));
		builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
		System.out.println("Tool tip" +button.getAttribute("data-tooltip"));
		button.click();
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@onclick = 'signIn()']")).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		System.out.println("confirmation message "+element.getText());

	}

}
