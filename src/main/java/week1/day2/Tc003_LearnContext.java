package week1.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Tc003_LearnContext {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "OnePlus 7T Pro");
		dc.setCapability("platformName", "Android");
		//dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
				new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String context = driver.getContext();
		System.out.println(context);
		
		
		Set<String> allContext = driver.getContextHandles();
		System.out.println(allContext.size());
		
		for (String eachContext : allContext) {
			System.out.println(eachContext);
			if(eachContext.contains("WEBVIEW")) {
				driver.context(eachContext);
			}
		}
		
	}

}
