package com.BCP.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BCP.Commons.BaseClass;
import com.BCP.PageObjects.HomePage;
import com.BCP.PageObjects.LoginPage;





public class LoginTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homepage;
	
	 @Parameters("browserName")
	 @BeforeMethod
	public void setup(String browserName) throws Exception {
		launchApp(browserName); 
		loginPage = new LoginPage();
		homepage = new HomePage();
		System.out.println("changes done");
	}
	
//@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//	
	
	@Test
	public void loginTest() throws Throwable {
		
		homepage =loginPage.LoginData(prop.getProperty("un"), prop.getProperty("pass"));
	}

}