package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumProject_keep {

AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		
		URL ServerURL = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(ServerURL, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test()
	public void googleTask() throws InterruptedException {
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='New list']")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter list title']")).sendKeys("Project Task");
		Thread.sleep(2000);
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Done']")).click();
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(901, 1727)).perform();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/notes")).sendKeys("Notes 1");
		
		
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}