package B44.Appium.Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragandDrop {

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
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		WebElement source = driver.findElements(AppiumBy.className("android.view.View")).get(0);
		WebElement destination = driver.findElements(AppiumBy.className("android.view.View")).get(1);
		
		AndroidTouchAction action = new AndroidTouchAction(driver);
		LongPressOptions longpress = new LongPressOptions();
				
		longpress.withElement(ElementOption.element(source));
		action.longPress(longpress).moveTo(ElementOption.element(destination)).release().perform();
		
	}
}
