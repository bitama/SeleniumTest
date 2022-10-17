package Iframes;

import java.util.concurrent.TimeUnit;

import javax.sound.sampled.ReverbType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserFactory {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/iframe";

	@BeforeTest
	public static WebDriver launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	@Test
	public static void switchToIframe() {


		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
		element.clear();
		element.sendKeys("Hello I am arrived");
		 String text =driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
		 if(text.contains("Hello I am arrived")) {
			 System.out.println("Text was typed as expected");
		 }

		driver.switchTo().defaultContent();

	}
     public static void tearDown() {
    	 driver.close();
    	 driver.quit();
     }

}
