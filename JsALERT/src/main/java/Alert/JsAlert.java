package Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JsAlert {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/javascript_alerts";



	@BeforeTest
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void checkAlert(){
	WebElement jsAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	jsAlert.click();
	Alert alert=driver.switchTo().alert();
		alert.accept();
		
	if(driver.getPageSource().contains("You successfuly clicked an alert")) {
		System.out.println("You successfuly clicked an alert");
	}
	 
    }
	@Test(priority = 1)
	public void checkToJsComfirm(){
		WebElement jsComfirm=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		jsComfirm.click();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
		if(driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("You clicked: Cancel");
		}
		
	}
	@Test(priority = 3)
	public void checkToJsPrompt(){
		WebElement jsPrompt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		jsPrompt.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Hello I am jsAlert");
		alert.accept();
		
		if(driver.getPageSource().contains("You entered: Hello I am jsAlert")) {
			System.out.println("You entered: Hello I am jsAlert");
		}
		
	}
     @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}



}
