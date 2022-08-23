package alchemy.project.hrms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HrmProjectSetup {
 
	public WebDriver driver;
	public WebDriverWait wait;
	@Parameters({"url","username","password"})
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void login(String url, String username, String password)
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		System.out.println("URL matching --> Part executed");
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		Assert.assertEquals(title,"OrangeHRM");		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		WebElement dashBoard = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
		dashBoard.isDisplayed();	
				
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
