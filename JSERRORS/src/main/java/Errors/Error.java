package Errors;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Error {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/javascript_error";



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
	public void findPageLogs(){

		 LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		 List<LogEntry>lgEntries=logEntries.getAll();
		 for(LogEntry logEntry:lgEntries) {
			 System.out.println(logEntry);
		 }
		 
		 if(driver.getPageSource().contains("Not Found")){
			 System.out.println("Error was found on page");
		 }else {
			System.out.println("error was not foun on page");
	
		}
	
    }
	
     @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
