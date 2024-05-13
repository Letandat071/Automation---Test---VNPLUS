import java.io.File;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	 public WebDriver driver;
	    @BeforeTest
	    public void Setup() throws InterruptedException {
	        // Setup
	        WebDriverManager.chromedriver().setup();
	        // Khởi tạo ChromeOptions và thêm tiện ích mở rộng
	        ChromeOptions options = new ChromeOptions();
	        String chromeProfilePath = "C:\\Users\\letan\\AppData\\Local\\Google\\Chrome\\User Data";
	        options.addArguments("user-data-dir=" + chromeProfilePath);
	        // Khởi tạo WebDriver với ChromeOptions
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.vietnamplus.vn/");
	        Thread.sleep(2000);
	    }
	    
	    @Test (priority = 0)
	    public void LoginkhongdienEmail() throws InterruptedException {
	    	System.out.println("Test case 1: Đăng nhập điền Password không điền Gmail");
	    	Thread.sleep(2000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập email!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 1: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 1: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    @Test (priority = 1)
	    public void LoginkhongdienPass() throws InterruptedException {
	    	System.out.println("Test case 2: Đăng nhập điền Gmail không điền Password");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập mật khẩu dài từ 6 ký tự trở lên!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 2: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 2: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    
	    @Test (priority = 2)
	    public void Loginkhongdiengica() throws InterruptedException {
	    	System.out.println("Test case 3: Đăng nhập không điền gì");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập email!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 3: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 3: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	driver.navigate().refresh();
	    	System.out.println("============");
	    }
	    
	    @Test (priority = 3)
	    public void LogintrueMailWrongPass() throws InterruptedException {
	    	System.out.println("Test case 4: Đăng nhập đúng Gmail sai Password");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw224@omeie.com");
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn nhập sai mật khẩu.";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 4: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 4: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    
	    @Test (priority = 4)
	    public void LoginWrongmailformatTruePasss() throws InterruptedException {
	    	System.out.println("Test case 5: Đăng nhập Sai định dạng Gmail đúng Password");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie");
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập email!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 5: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 5: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    
	    @Test (priority = 5)
	    public void LoginWrongmailformatWrongPasss() throws InterruptedException {
	    	System.out.println("Test case 6: Đăng nhập Sai định dạng Gmail sai Password");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie");
	    	Thread.sleep(1000);
	    	driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw2240@omeie.com");
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập email!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 6: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 6: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    
	    @Test (priority = 6)
	    public void LoginWrongmailformatNoPasss() throws InterruptedException {
	    	System.out.println("Test case 7: Đăng nhập Sai định dạng Gmail không Password");
	    	Thread.sleep(4000);
	    	//Nhấp vào icont đăng nhập 
	    	driver.findElement(By.id("userprofile")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie");
	    	Thread.sleep(1000);
	    	Thread.sleep(9000);
	    	driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
	    	Thread.sleep(1000);
	    	Alert alert = driver.switchTo().alert();
	    	String mongdoiString = "Kết quả mong đợi: Bạn vui lòng nhập email!";
	    	String thucteString = "Kết quả thực tế: " + alert.getText();
	    	System.out.println();
	    	if (mongdoiString.contains(alert.getText())) {
				System.out.println("Test case 7: Thành công!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			} else {
				System.out.println("Test case 7: Thất bại!");
				System.out.println(mongdoiString);
				System.out.println(thucteString);
			}
	    	alert.accept();
	    	System.out.println("============");
	    	driver.navigate().refresh();
	    }
	    
	    
	    @Test (priority = 7)
	    public void Login() throws InterruptedException {
	    	// Truy cập website
	    	System.out.println("Test case 8: Đăng nhập Đúng Email Đúng Password");
	    	Thread.sleep(4000);
	        // Click Đăng nhập
	        driver.findElement(By.id("userprofile")).click();
	        // Tài khoản
	        driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
	        driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("/html/body/div[12]/div[2]/button")).click();
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
}
