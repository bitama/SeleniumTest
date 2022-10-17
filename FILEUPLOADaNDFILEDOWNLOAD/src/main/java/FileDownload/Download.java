package FileDownload;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Download {
	static WebDriver driver;
	static String browser = "chrome";
	static String url = "http://localhost:7080/download";



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
	public void checkDownloadedFile() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='visionCar.webp']"));
		element.click();
		
		File files = new File("C:\\Users\\Patrick  Perereza\\Downloads");
		File[]allFiles=files.listFiles();
		for(File file:allFiles) {
			if(file.getName().equals("visionCar.webp")){
				System.out.println("File is downloaded");
			
			}
		}
		
		
	}
//     @AfterTest
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}

}
