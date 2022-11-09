package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4StepDefinition{

	public ChromeDriver driver;

	@Given("Login to browser and navigate to URL")
	public void browserloginin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	 
		driver.findElement(By.id("username")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
	}
	
	@And("The Browser should be closed")
	public void closebrowser() {
		driver.close();
	}
}

