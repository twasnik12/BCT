package com.BCP.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BCP.Commons.BaseClass;


public class LoginPage extends BaseClass {
	
	BaseClass t = new BaseClass();
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;

	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement Loginbtn;
	


	public LoginPage()
	{
		PageFactory.initElements(t.driver, this);
	}
	

	public HomePage LoginData(String un, String pass) throws InterruptedException

	{
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		uname.sendKeys(un);
		password.sendKeys(pass);
		Loginbtn.click();
		
			
		return new HomePage();
	}

}

