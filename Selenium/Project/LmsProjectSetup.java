package alchemy.project.lms;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LmsProjectSetup {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://alchemy.hguy.co/lms/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
		WebElement heading = driver.findElement(By.xpath("//h1[text()=' Learn from Industry Experts ']"));
		Assert.assertEquals(heading.getText(), "Learn from Industry Experts");    
		WebElement firsttitle = driver.findElement(By.xpath("//h3[text()=' Actionable Training ']"));
		Assert.assertEquals(firsttitle.getText(), "Actionable Training");
		WebElement secondTitle = driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']"));
		Assert.assertEquals(secondTitle.getText(), "Email Marketing Strategies");
		driver.findElement(By.linkText("My Account")).click();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "My Account – Alchemy LMS");
		driver.findElement(By.xpath("//a[@href='#login']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login"))).sendKeys("root");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_pass"))).sendKeys("pa$$w0rd");
		WebElement login = driver.findElement(By.id("wp-submit"));
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		WebElement userid = driver.findElement(By.xpath("//span[@class='display-name']"));
		Assert.assertEquals(userid.getText(), "root");
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
