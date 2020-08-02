package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class LearnStartActivity {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		// launch the app
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Search").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("APPIUM JULY 2020");
		
		driver.findElementById("com.whatsapp:id/conversations_row_contact_name").click();
		
		// Only for Android
		Activity act = new Activity("com.oneplus.mms", "com.android.mms.ui.ConversationList");
		String currentActivity = act.getAppActivity();
		System.out.println(currentActivity);
		driver.startActivity(act);
		
		driver.findElementByAccessibilityId("Search messages").click();
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/search_src_text").sendKeys("Tl Sam");
		
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/title").click();
		
		// stopRunningApp - In Android
		new Activity("com.oneplus.mms", "com.android.mms.ui.ConversationList").setStopApp(false);
		

	}

}
