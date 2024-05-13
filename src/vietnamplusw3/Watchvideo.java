package vietnamplusw3;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.checkerframework.checker.lock.qual.GuardedByUnknown;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Watchvideo {
	public WebDriver driver;
	ArrayList<String> listieude = new ArrayList<String>();
	 @BeforeTest
	    public void Setup() throws InterruptedException {

	        // Setup
	        WebDriverManager.chromedriver().setup();

	        // Khởi tạo ChromeOptions và thêm tiện ích mở rộng
	        ChromeOptions options = new ChromeOptions();
	        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
	        options.addExtensions(new File("E:\\Anti-Captcha-Blocker-Extension.crx"));
	        // Khởi tạo WebDriver với ChromeOptions
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
			 driver.get("https://www.vietnamplus.vn/");
		    }
	 @Test
	 public void Watchingvideo() throws InterruptedException {
		 // Vào danh mục video
		 Thread.sleep(2000);
		 WebElement videoWebElement =  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[1]/div[1]/div[4]/h3/a"));
		 Thread.sleep(2000);
		 videoWebElement.click(); // Kích hoạt quảng cáo
		 Thread.sleep(2000);
		videoWebElement.click(); // Bỏ qua quảng cáo vào tranh chính
		Thread.sleep(2000);
		for (int i = 1; i <= 30; i++) {
			WebElement titlelistElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div/article["+i+"]/h2/a"));
			listieude.add(titlelistElement.getText());	
		}
		Random random = new Random();
		int sopatch = random.nextInt(29)+1;
		driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div/article["+sopatch+"]/h2/a")).click();
		
		WebElement gett = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/h1"));
		String sosanhthucteString = gett.getText();
		if (listieude.contains(sosanhthucteString)) {
			System.out.println("Xem video thành công");
		} else {
			System.out.println("Thất bại"); // In kết quả fail
		}
		driver.close();
	 }
	
	 
}




