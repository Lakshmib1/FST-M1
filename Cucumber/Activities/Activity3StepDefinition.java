package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3StepDefinition {

	public ChromeDriver driver;
	public Alert alert;

	@Given("User is on the page")
	public void user_is_on_the_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


	@When("User clicks the Simple Alert button")
	public void user_clicks_the_simple_alert_button() {
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

	}

	@When("User clicks the Confirm Alert button")
	public void user_clicks_confirm_alert() {
		driver.findElement(By.xpath("//button[text()='Confirmation']")).click();
	}

	@When("User clicks the Prompt Alert button") 
	public void user_clicks_prompt_alert() {
		driver.findElement(By.xpath("//button[text()='Prompt']")).click();
	}

	@Then("Alert opens")
	public void alert_opens() {
		alert = driver.switchTo().alert();
	}

	@Then("Read the text from it and print it")
	public void read_the_text_from_it_and_print_it() {

		System.out.println("The Text on the alert is "+alert.getText());
	}

	@Then("Close the alert")
	public void close_the_alert() {
		alert.accept();
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.close();
	}



	@Then("Close the alert with Cancel")
	public void close_the_alert_with_cancel() {
		alert.dismiss();
	}



	@Then("Write a custom message in it")
	public void write_a_custom_message_in_it() {
		alert.sendKeys("custom message");
	}


}
