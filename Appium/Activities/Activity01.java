package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity01 {

	AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		URL ServerURL = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(ServerURL, options);
	}
	
	@Test()
	public void Activity1() {
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "45");
		System.out.println(result);
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
