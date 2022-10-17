package window;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.transform.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewWindow {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = " http://localhost:7080/windows";


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
	public void newWindowChech() throws InterruptedException {
	WebElement element=driver.findElement(By.xpath("//div[@class='example']/a"));
	element.click();

	
	
	Set<String>windows=driver.getWindowHandles();
	
	for(String win:windows) {
		driver.switchTo().window(win);
	}
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "New Window";
	Assert.assertEquals(actualTitle,expectedTitle);
	
		
		
	
		
	}
     @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
