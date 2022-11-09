package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class GeneralStore_TC_001 {
	AndroidDriver driver;
	@BeforeMethod
	public void init() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.thunkable.android.rs_sunny100.General_Store");
		options.setAppActivity(".Screen1");
		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void Testcase_001() throws InterruptedException
	{
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']")).click();
	//	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='email address']")).sendKeys("lakshmi2@gmail.com");
	//	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='subscribe']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Image[@text='General Store']")).click();
		Thread.sleep(2000);
		
		driver.findElements(AppiumBy.className("android.view.View")).get(1).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='New Arrivals']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Image[@text='Brancusi Pant - Engineer Stripe']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Basket\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add to Basket']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
