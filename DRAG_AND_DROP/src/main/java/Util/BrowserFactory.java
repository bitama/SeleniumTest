package Util;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserFactory {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/dropdown";

//	public static void setup() {
//		
//	}

	@BeforeTest
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void seleDropDown() throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
		select.selectByVisibleText("Option 2");
	}
	
	
//    @Test
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}

}
