//package drop;
//
//import java.awt.Checkbox;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class BrowserFactory {
//	static WebDriver driver;
//	static String browser = "chrome";
//	static String url = "http://localhost:7080/checkboxes";
//
////	public static void setup() {
////		
////	}
//
//	@BeforeTest
//	public static void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get(url);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//	}
//
//	@Test
//	public void checkTheBoxes() throws InterruptedException {
//		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		for (int i = 0; i < elements.size(); i++) {
//
//			if (elements.get(i).isEnabled()) {
//				elements.get(i).click();
//			} else if (elements.get(i).isSelected()) {
//
//				elements.get(i).click();
//			}
//		}
//		
//	}
//     @Test
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}
//
//}
