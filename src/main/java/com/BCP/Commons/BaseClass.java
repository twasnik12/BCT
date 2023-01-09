package com.BCP.Commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	@BeforeTest
	
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Tathagat\\eclipse-workspace\\BrowserCompatibilityProject\\src\\main\\java\\com\\BCP\\Properties\\config.properties");
			prop.load(f);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApp(String	 browserName) {
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")){
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "E://software//edgedriver_win64//msedgedriver.exe");
			driver = new EdgeDriver();}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launching the URL	
		driver.get(prop.getProperty("url"));//will wait for still web page open
	}}