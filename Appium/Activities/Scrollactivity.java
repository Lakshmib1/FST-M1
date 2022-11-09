package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Scrollactivity {

	public static void main(String[] args) throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.touchboarder.android.api.demos");
		options.setAppActivity("com.touchboarder.androidapidemos.MainActivity");
		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true)";
		
		

		// Driver Initialization
		AndroidDriver driver = new AndroidDriver(serverURL, options);
		options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='OK']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='API Demos']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("text(\"Views\")")).click();
		//driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
		//driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"WebView\")")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WebView']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
	}
}
