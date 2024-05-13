package vietnamplus;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountLog {

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
        // Tài khoản
        driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
        driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
        // Kiểm tra đã đăng nhập thành công chưa
        driver.findElement(By.id("userprofile")).click();
        WebElement checklogin = driver.findElement(By.xpath("//*[@id=\"userprofile\"]/ul/li[5]/a"));
        String check = checklogin.getText();
        if (check.equals("Đăng xuất")) {
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Đăng nhập thất bại");
        }

    }
    @Test
    public void Logout() throws InterruptedException {
    	 WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"userprofile\"]/ul/li[5]/a"));
     	((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);
     	Thread.sleep(2000);
     	// Lấy cảnh báo
     	Alert alert = driver.switchTo().alert();
     	// Chấp nhận cảnh báo (bấm nút "OK")
     	
     	if(alert.getText().equals("Cảm ơn bạn đã dùng dịch vụ của VietnamPlus!") ) {
     		System.out.println("Đăng xuất thành công");
     	}
     	else if (alert == null){
			System.out.println("Đăng xuất thất bại");
		}
     	else{
			System.out.println("Đăng xuất thất bại");
		}
     	alert.accept();	
    }
    
  

    
    @Test
    public void Regist() throws InterruptedException {
    	
        // Click Đăng nhập
        driver.findElement(By.id("userprofile")).click();
        Thread.sleep(500);
        WebElement registButton = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[6]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registButton);
        Thread.sleep(500);
        
        // Điền thông tin 
        driver.findElement(By.id("txtSignupEmail")).sendKeys("xvp31054@nezid.com");
        driver.findElement(By.id("txtSignupPassword")).sendKeys("xvp31054@nezid.com");
        driver.findElement(By.id("txtConfirmSignupPassword")).sendKeys("xvp31054@nezid.com");
        driver.findElement(By.id("txtSignupFullname")).sendKeys("Tenoday");
      //Điều khoản
        WebElement dieukhoan = driver.findElement(By.id("cbPolicy"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dieukhoan);
        Thread.sleep(10000); // Cho người dùng 10s để pass capcha
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click(); //click tạo tài khoản
        Thread.sleep(1000); // Đợi 1s để hiện thông báo
        Alert alert = driver.switchTo().alert(); //chuyển sang cửa sổ thông báo 
        alert.accept(); //Nhấn Ok trên thông báo để tạo tàiu khoản thành công	
    } 
    
    
   

   
}
