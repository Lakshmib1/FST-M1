package B44.Appium.Activity;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class basics {

	public static void main(String[] args) throws MalformedURLException {
		
		/*File appDir = new File("src/main/java");
		File app = new File(appDir,"ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LakshmiEmulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		cap.setCapability("autoGrantPermissions", "true");
		driver.findElement(AppiumBy.xpath(".//android.widget.Button[@text='Allow']")).click();*/
		
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
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Hello");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']")).click();
		
		
	}
		
		
		
	

	
}
