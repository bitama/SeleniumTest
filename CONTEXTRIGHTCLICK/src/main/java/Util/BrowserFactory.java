package Util;

import java.awt.Checkbox;
import java.awt.Desktop.Action;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserFactory {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/drag_and_drop";

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
	public void drageAndDob() throws InterruptedException {
		
		
		WebElement sourcElement=driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement targetElement=driver.findElement(By.xpath("//div[@id='column-b']"));
//		Actions actions = new Actions(driver);
		
//		actions.clickAndHold(sourcElement).moveToElement(targetElement).release().build().perform();
//		actions.dragAndDropBy(sourcElement,116,16).perform();
//		final Actions action = new Actions(driver);
//		action.clickAndHold(sourcElement)
//		.moveByOffset(-1, -1) // To fix issue with drag and drop in Chrome V61.0.3163.79
//		.moveToElement(targetElement, targetElement.getLocation().getX()+targetElement.getSize().getWidth()/2, targetElement.getLocation().getY()+targetElement.getSize().getHeight()/2)
//		.release(targetElement)
//		.build()
//		.perform();
//		
		int x = sourcElement.getLocation().x;
        int y = targetElement.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(sourcElement)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(sourcElement)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(targetElement)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
		
	}
	
	
//     @Test
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
