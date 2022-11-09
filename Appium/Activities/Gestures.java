package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.touchboarder.android.api.demos");
		options.setAppActivity("com.touchboarder.androidapidemos.MainActivity");
		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		

		// Driver Initialization
		AndroidDriver driver = new AndroidDriver(serverURL, options);
		options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='OK']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='API Demos']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("text(\"Views\")")).click();
		WebElement webElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		
		AndroidTouchAction action = new AndroidTouchAction(driver);
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(webElement))).perform();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement peopleNames = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		
		LongPressOptions longpress = new LongPressOptions();
		longpress.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(peopleNames));
		action.longPress(longpress).release().perform();
		
		boolean displayed = driver.findElement(AppiumBy.id("android:id/title")).isDisplayed();
		System.out.println(displayed);
        
        
        		
        
        
        
		
		

	}

}
