package tests;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import page.Add_Remove_Cart;
import page.BaseClass;
import page.Login;
import page.MenuNavigation;

public class TestCase extends BaseClass{
	
	
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("TestCase.class");
	@BeforeTest()
	public void applaunch() {
		driver=BaseClass.setUp();
		log.info("App Launched Successfully");

				
	}
	@Test(priority=1)
	public void Checkout() {
		log.info("Starting Checkout Scenario");
		Login login=new Login(driver);
		login.clickonLogin("standard_user","secret_sauce");
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.add_ToCart(1);
		add.gotoCart();
		add.checkout();
		add.fillCheckoutInfo();
		add.scrollDown();		
		add.clickonFinish();
		add.orderStatus();
		add.backtoHome();
		log.info("End of checkout Scenario");
	}
	@Test(priority=2)
	public void Cartstatus() {
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		login.clickonLogin("standard_user","secret_sauce");
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.cart_status();
		
		
	}
	
	@Test(priority=3)
	public void InvalidLogin() {
		
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		log.info("Logging in with invalid credentials");
		login.clickonLogin("jhsvcj","secret_sauce");
		
	}
	@Test(priority=4)
	public void problemUser() {
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		login.clickonLogin("problem_user","secret_sauce");
		log.info("Logging in with Problem_User credentials");
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.add_ToCart(2);
		add.detailPageVerification();
		
	}
	@Test(priority=5)
	public void filterActions() {
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		login.clickonLogin("standard_user","secret_sauce");
		MenuNavigation menu=new MenuNavigation(driver);
		log.info("Filter Actions");
		menu.filter();
		
	}
	@Test(priority=6)
	public void autoFillLogin() {
		driver=BaseClass.setUp();
		
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		Login login=new Login(driver);
		login.tapToAutoFill("locked_out_user");
	}
	@Test(priority=7)
	public void MenuActions() {
        driver=BaseClass.setUp();
		
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		Login login=new Login(driver);
		login.tapToAutoFill("standard_user");
		MenuNavigation menu=new MenuNavigation(driver);
		log.info("Performing Menu Actions");
		menu.MenuOperations();
	}
	@Test(priority=8)
	public void MenuActions2() {
        driver=BaseClass.setUp();
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		Login login=new Login(driver);
		login.tapToAutoFill("standard_user");
		MenuNavigation menu=new MenuNavigation(driver);
		menu.clickon_QRCodeScannerOption();
		menu.clickon_GeoLocationOption();
	}
	@Test(priority=9)
	public void RemoveFromCart() {
		driver=BaseClass.setUp();
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		Login login=new Login(driver);
		login.tapToAutoFill("standard_user");
		add.add_ToCart(1);
		add.gotoCart();
		add.removeFromCart();
	}
	
	@AfterTest
	public void quit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("Driver Quit");
		driver.quit();
	}
	
    
}
