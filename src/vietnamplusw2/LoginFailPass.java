package vietnamplusw2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFailPass {
 public WebDriver driver;
 
 @BeforeTest
 public void setup() {
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
 public void LoginFailEmail() throws InterruptedException {
	// Click Đăng nhập
     driver.findElement(By.id("userprofile")).click();
     // Tài khoản
     Thread.sleep(2000);
     driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw2240@omeie.com");
     driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
     driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
     Thread.sleep(2000);
     WebElement noticeFail = driver.findElement(By.xpath("/html/body/div[12]/div[2]/p"));
     String thongbao   = noticeFail.getText();
     String chuoimongdoiString = "Email chưa được đăng ký. Hãy tạo tài khoản.";
     if (thongbao.contentEquals(chuoimongdoiString)) {
		System.out.println("Login Fail Email: Pass");
	}
     else {
		System.out.println("Fail");
	}
     driver.close();
 }
 
}
