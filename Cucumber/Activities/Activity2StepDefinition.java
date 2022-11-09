package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2StepDefinition {
	public ChromeDriver driver;

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("Enter Username and Password")
	public void enter_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}

	@Then("Read the Page Title and Confirmation Page")
	public void read_the_page_title_and_confirmation_page() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String text = driver.findElement(By.id("action-confirmation")).getText();
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		driver.close();
	}

}
