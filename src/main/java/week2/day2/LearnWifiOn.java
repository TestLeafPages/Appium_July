package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class LearnWifiOn {
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		//dc.setCapability("noReset", true);
		
		// launch the app
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ConnectionStateBuilder csb = new ConnectionStateBuilder();
		ConnectionState state = csb.withAirplaneModeDisabled().build();
		driver.setConnection(state);
		
		
		ConnectionStateBuilder csb1 = new ConnectionStateBuilder();
		ConnectionState state1 = csb1.withAirplaneModeEnabled().build();
		driver.setConnection(state1);
		
		
		driver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
		
		
		
		
		driver.openNotifications();
			
		
	}

}
