package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Browsertesting {
	// Driver Declaration
    AndroidDriver driver;
    public WebDriverWait wait ;
 
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
 
        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
 
        // Open the page in Chrome
        driver.get("https://www.training-support.net");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
 
    // Test method
    @Test
    public void chromeTest() throws InterruptedException {
    	Thread.sleep(15000); 
    	WebElement element = driver.findElement(AppiumBy.xpath("//android.view.View[text()='Training Support']"));
    	wait.until(ExpectedConditions.visibilityOf(element));
    	String pageHeading = element.getText();
        // Print to console
        System.out.println("Heading: " + pageHeading);
 
        // Find and click the About Us link
        WebElement element2 = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']"));
        wait.until(ExpectedConditions.elementToBeClickable(element2));
        element2.click();
 
        // Find heading of new page and print to console
        WebElement element3 = driver.findElement(AppiumBy.xpath("//android.view.View[text()='About Us']"));
        wait.until(ExpectedConditions.visibilityOf(element3));
        String aboutPageHeading = element3.getText();
        System.out.println(aboutPageHeading);
    }
 
 
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
