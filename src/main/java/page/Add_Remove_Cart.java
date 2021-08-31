package page;

import static org.testng.AssertJUnit.assertEquals;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class Add_Remove_Cart extends BaseClass{
	
	public Add_Remove_Cart(AppiumDriver<MobileElement> driver) {
		
	}
//	Logger log=new Logger.getLogger(BaseClass.class);
	public void add_ToCart(int num) {
		String ele="(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[";
		String strend="]";
		String i=String.valueOf(num);
		String Combined=ele.concat(i).concat(strend);
		System.out.println(Combined);
		driver.findElement(By.xpath(Combined)).click();
		try {
			
		
		if(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")).isDisplayed()) {
          System.out.println("Product Added Successfully");	
          log.info("Product Added Successfully");
          
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			String product=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")).getText();
			System.out.println("Bug: Could not add the product "+product);
			log.info("Bug: Could not add the product "+product);
		}
		

	}
	public int cart_status() {
		int status=0;
		log.info("Finding the Cart Status");
//		public static String status="//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.view.ViewGroup";
		try {		
		if(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup")).isDisplayed()) {
			System.out.println("Cart Status is not Empty");
			log.info("Cart Status is Not Empty");
			status=1;
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Cart Status is Empty");
			log.info("Cart Status is Empty");
			status=0;
//			e.printStackTrace();
		}

		return status;
	}
	
	 
    
	public void gotoCart() {
		MobileElement cart=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
		cart.click();
        log.info("Navigated to the cart");
	}
	
	public void checkout() {
		
		try {
			
		
		if(driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT")).isDisplayed()) {
			driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT")).click();
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
		}
	}
	
	public void fillCheckoutInfo() {
		
		driver.findElement(MobileBy.AccessibilityId("test-First Name")).sendKeys("Sai Teja");
		driver.findElement(MobileBy.AccessibilityId("test-Last Name")).sendKeys("Voruganti");
		driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code")).sendKeys("508206");
		driver.findElement(MobileBy.AccessibilityId("test-CONTINUE")).click();
		log.info("Entered the checkout details");
	}
	public void scrollDown() {

		TouchAction  action =new TouchAction(driver);	
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height=size.height;				
		int middleOfX=width/2;
		int startYCoordinate= (int)(height*.5);
		int endYCoordinate= (int)(height*.2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(middleOfX, startYCoordinate))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();		
		
	}
	public void clickonFinish() {
		driver.findElement(MobileBy.AccessibilityId("test-FINISH")).click();
	}
	public void orderStatus() {
		String orderstatus=driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
		System.out.println(orderstatus);
		log.info(orderstatus);
	}
	public void backtoHome() {
		driver.findElement(MobileBy.AccessibilityId("test-BACK HOME")).click();
	}
	public void detailPageVerification() {
		String HomePageEletext=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")).getText();
		driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")).click();
		String Detailpagetext=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")).getText();
		
//		AssertJUnit.assertEquals(HomePageEletext, Detailpagetext);
         if(HomePageEletext.equals(Detailpagetext)) {
        	 System.out.println(HomePageEletext+" Product Name is same in Home page and Detail Page"); 
             log.info(HomePageEletext+" Product Name is same in Home page and Detail Page");
         }
         else {
        	 System.out.println("Bug: "+HomePageEletext+"- Product Name is not same in Home page and Detail Page");
        	 log.info("Bug: "+HomePageEletext+"- Product Name is not same in Home page and Detail Page");
         }
		
	}
	public void removeFromCart() {
		try {
			
		if(driver.findElement(MobileBy.AccessibilityId("test-REMOVE")).isDisplayed()) {
			driver.findElement(MobileBy.AccessibilityId("test-REMOVE")).click();
			log.info("Product removed successfully from the cart");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			log.info("Unable to perform the action");
			
		}
		
	}
}
