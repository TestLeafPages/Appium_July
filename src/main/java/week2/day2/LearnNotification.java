package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class LearnNotification {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", " net.oneplus.launcher");
		dc.setCapability("appActivity", "net.oneplus.launcher.Launcher");
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		// launch the app
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.openNotifications();
		
		String text = driver.findElementByXPath("//*[@text='USB debugging connected']").getText();
		System.out.println(text);
		System.out.println("****************************************");
		
		driver.findElementByXPath("//*[@text='USB debugging connected']").click();
		
		Thread.sleep(2000);
		
		List<WebElement> ellElements = driver.findElementsById("android:id/title");
		for (WebElement eachElement : ellElements) {
			System.out.println(eachElement.getText());
		}
		
		
		
		

	}

}
