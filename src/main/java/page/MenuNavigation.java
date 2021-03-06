package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class MenuNavigation extends BaseClass{
	
	public MenuNavigation(AppiumDriver<MobileElement> driver) {
		
	}
	public void menuClick() {
         
		driver.findElement(MobileBy.AccessibilityId("test-Menu")).click();
	}
	public void filter() {
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype1=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (Z to A)']")).getText();
		System.out.println("Filtering with respect to "+filtertype1+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (Z to A)']")).click();
		afterSorting(filtertype1);
		
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype2=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (A to Z)']")).getText();
		System.out.println("Filtering with respect to "+filtertype2+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (A to Z)']")).click();
		afterSorting(filtertype2);
		
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype3=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (low to high)']")).getText();
		System.out.println("Filtering with respect to "+filtertype3+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (low to high)']")).click();
		afterSorting(filtertype3);
		
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype4=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (high to low)']")).getText();
		System.out.println("Filtering with respect to "+filtertype4+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (high to low)']")).click();
		afterSorting(filtertype4);
	}
	public void afterSorting(String filtertype) {
		String ProductName1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]")).getText();
	    String Price1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]")).getText();
	    String ProductName2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[2]")).getText();
	    String Price2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[2]")).getText();
	    System.out.println("-------------------------------------"); 
	    System.out.println("Details after filtering w.r.t "+filtertype);
	    System.out.println(ProductName1 +" "+ Price1);
	    System.out.println(ProductName2 +" "+ Price2);
	    System.out.println("**************************************");
	    System.out.println("");
	    
	    log.info("-------------------------------------"); 
	    log.info("Details after filtering w.r.t "+filtertype);
	    log.info(ProductName1 +" "+ Price1);
	    log.info(ProductName2 +" "+ Price2);
	    log.info("**************************************");
	    log.info("");
	}
	
	public void MenuOperations() {
		
		clickon_AllItemsOption();
		clickon_WebViewOption();
//		clickon_GeoLocationOption();
//		clickon_QRCodeScannerOption();
		clickon_LogoutOption();
	}
	public void clickon_AllItemsOption() {
		menuClick();
		driver.findElement(MobileBy.AccessibilityId("test-ALL ITEMS")).click();
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		if(driver.findElementByXPath("//android.widget.TextView[@text='PRODUCTS']").isDisplayed()) {
			System.out.println("All Items are displayed");
			
		}
		
	}
	public void clickon_WebViewOption() {
		menuClick();
		driver.findElement(MobileBy.AccessibilityId("test-WEBVIEW")).click();
		if(driver.findElementByXPath("//android.widget.TextView[@text='WEBVIEW SELECTION']").isDisplayed()) {
			System.out.println("Successfully Navigated to WebView Selction Page");
		}
		
	}
    public void clickon_QRCodeScannerOption() {
    	menuClick();
		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-QR CODE SCANNER\"]")).click();
		try {
			
    	if(driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").isDisplayed()) {
    		driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
//    		System.out.println("Successfully Navigated to WebView Selction Page");
    		try {
				
    			if(driver.findElementByXPath("//android.widget.TextView[@text='Scan a QR Code that contains a url.']").isDisplayed()) {
                    System.out.println("QR Code Scanner is launched");				
    			}
        	}catch(org.openqa.selenium.NoSuchElementException e1) {
        		System.out.println("QR Code Scanner is not launched");
        		
        	}
    	}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			try {
				
			if(driver.findElementByXPath("//android.widget.TextView[@text='Scan a QR Code that contains a url.']").isDisplayed()) {
                System.out.println("QR Code Scanner is launched");				
			}
    	}catch(org.openqa.selenium.NoSuchElementException e1) {
    		System.out.println("QR Code Scanner is not launched");
    		
    	}
		}
    }
    public void clickon_GeoLocationOption() {
    	
    	menuClick();
    	driver.findElement(MobileBy.AccessibilityId("test-GEO LOCATION")).click();
    	try {
			
    		
        	if(driver.findElementById("com.android.permissioncontroller:id/permission_allow_always_button").isDisplayed()) {
        		driver.findElementById("com.android.permissioncontroller:id/permission_allow_always_button").click();
//        		System.out.println("Successfully Navigated to WebView Selction Page");
        		try {
    				
        			if(driver.findElementByXPath("//android.widget.TextView[@text='GEO LOCATION']").isDisplayed()) {
                        System.out.println("Navigated to Geo Location Page");
                        System.out.println("Latitude and Longitude values are displayed");
                        
                        
        			}
            	}catch(org.openqa.selenium.NoSuchElementException e1) {
            		System.out.println("Not Navigated to Geo Location Page");
            		
            	}
        		
        	}
    		}catch(org.openqa.selenium.NoSuchElementException e) {
    			try {
    				
    			if(driver.findElementByXPath("//android.widget.TextView[@text='GEO LOCATION']").isDisplayed()) {
                    System.out.println("Navigated to Geo Location Page");
                    System.out.println("Latitude and Longitude values are displayed");
                    
                    
    			}
        	}catch(org.openqa.selenium.NoSuchElementException e1) {
        		System.out.println("Not Navigated to Geo Location Page");
        		
        	}
    		}
    	
    }
    public void clickon_LogoutOption() {
		menuClick();
		driver.findElement(MobileBy.AccessibilityId("test-LOGOUT")).click();
		try {
		if(driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).isDisplayed()) {
			System.out.println("Logged out successfully");
			
		}
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			System.out.println("Not Logged out");
			
		}
		
	}
}
