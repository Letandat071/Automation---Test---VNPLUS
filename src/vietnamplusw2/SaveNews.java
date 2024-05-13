package vietnamplusw2;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaveNews {

    public WebDriver driver;

    @BeforeTest
    public void Setup() {

        // Setup
        WebDriverManager.chromedriver().setup();

        // Khởi tạo ChromeOptions và thêm tiện ích mở rộng
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
        options.addExtensions(new File("E:\\Anti-Captcha-Blocker-Extension.crx"));
        // Khởi tạo WebDriver với ChromeOptions
        driver = new ChromeDriver(options);
    }
   
    @Test
    public void Login() throws InterruptedException {
    	// Truy cập website
        driver.get("https://www.vietnamplus.vn/");
        // Click Đăng nhập
        driver.findElement(By.id("userprofile")).click();
        Thread.sleep(2000);
        // Tài khoản
        driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
        driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
        Thread.sleep(2000);

    }
    @Test
    public void SaveNews() throws InterruptedException {
    	
    	//Xem tin
    	 Random random = new Random();
		 int rand = random.nextInt(4)+1;
		 String xpath = "/html/body/div[3]/div/div[2]/div[3]/div[1]/div/article[" + rand + "]/h2";
		 WebElement news = driver.findElement(By.xpath(xpath));
		 news.click();
		 news.click();
		 Thread.sleep(2000); 
		 // Lưu tin
		 WebElement savebutton = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[2]/div[1]/a[4]"));
		 savebutton.click();
		 
		 //Check Thành công thất bại
		 Thread.sleep(2000);
		 Alert alert = driver.switchTo().alert();
		 
		 String noticesave = alert.getText();
		 String noticetrue = "Bạn đã lưu tin thành công!";
		 if (noticesave.equals(noticetrue)) {
			System.out.println("Lưu bài thành công");
		} else {
			System.out.println("Lưu bài thất bại");
		}
		 
		
    }
}
