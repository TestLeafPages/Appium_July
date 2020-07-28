package week1.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC002_Install_App {
	
	public static void main(String[] args) throws MalformedURLException {
		
		// If the app is not available in mobile ->
		
			 // Mandatory DC are 
					// deviceName
					// app
		
			// Optional
					// platformName
		
		// Step01: Desired Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("app", "C:\\leaforg.apk");
		
		// Step02: Create the driver
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		
		
	}

}
