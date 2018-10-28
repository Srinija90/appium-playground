package test_maven.com.myappium.playground;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyDriver {
	

	static String appName = "ApiDemos-debug.apk";
	static String appiumServer = "http://127.0.0.1:4723/wd/hub";
	static AndroidDriver driver = null;
	
	public static AndroidDriver getDriver() {
		if (driver != null) {
			return driver;
		}

		File f = new File("src");
		File fs = new File(f, appName);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus-5-1");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		try {
			driver = new AndroidDriver(new URL(appiumServer), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
