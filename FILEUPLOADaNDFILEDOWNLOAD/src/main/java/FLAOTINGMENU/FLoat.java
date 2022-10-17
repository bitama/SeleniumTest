package FLAOTINGMENU;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FLoat {

	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/floating_menu";

	@BeforeTest
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void scrollUpAndDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

	}
//    @AfterTest
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}

}
