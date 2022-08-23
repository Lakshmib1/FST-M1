package alchemy.activity;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
        // Open the browser
        driver.get("https://www.training-support.net");
		
        // Close the browser
       // driver.close();
	}

}
