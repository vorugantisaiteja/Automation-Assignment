package page;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("BaseClass.class");
//	PropertyConfigurator.configure("log4j.properties");
//	PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separator + "log4j.properties");
	public static AppiumDriver<MobileElement> setUp() {
		try {		
			
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10 QKQ1.190915.002");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 7 Pro");
		cap.setCapability(MobileCapabilityType.UDID, "d9b3ca47");
//		cap.setCapability(MobileCapabilityType.APP, "");
		cap.setCapability("appPackage", "com.swaglabsmobileapp");
		cap.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver =new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		log.info("Launching the app");
//		MobileElement loginbutton = driver.findElement(MobileBy.AccessibilityId("test-LOGIN"));
//        loginbutton.click();
				return driver;
		}catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

}
