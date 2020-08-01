package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class LearnTouchActionforLongPress {
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.oneplus.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Search messages").click();
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/search_src_text").sendKeys("Tl Sam");
		
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/title").click();
		
		Thread.sleep(2000);
		
		driver.findElementById("com.oneplus.mms:id/compose_message_text").sendKeys("sending msg via Appium");
		
		
		
		
		
	}

}
