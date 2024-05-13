package vietnamplusw3;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewMoreNews { // Khai báo lớp ViewMoreNews

    static WebDriver driver; // Biến driver để sử dụng WebDriver

    @BeforeTest // Phương thức được chạy trước khi các phương thức kiểm thử được thực thi
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Cài đặt WebDriver cho Chrome
        ChromeOptions opt = new ChromeOptions(); // Khởi tạo một số tùy chọn cho trình duyệt Chrome
        opt.addExtensions(new File("E:\\uBlock-Origin.crx")); // Thêm extension cho trình duyệt Chrome
        driver = new ChromeDriver(opt); // Khởi tạo trình duyệt Chrome với các tùy chọn đã cấu hình
        driver.manage().window().maximize(); // Phóng to cửa sổ trình duyệt
        Thread.sleep(5000); // Dừng chương trình trong 5 giây để chờ trình duyệt mở và tải trang
        driver.navigate().to("https://www.vietnamplus.vn/"); // Điều hướng đến trang web cần kiểm thử
        Thread.sleep(2000); // Dừng chương trình trong 2 giây để chờ trang web tải hoàn thành
    }


    @Test(priority = 1) // Phương thức kiểm thử đánh dấu là ưu tiên 1
    public void ClickNews() throws InterruptedException {
        	Thread.sleep(3000);
        	WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/article[1]/h2/a"));
        	clickElement.click();
            Thread.sleep(2000);  
    }

    @Test(priority = 2) // Phương thức kiểm thử đánh dấu là ưu tiên 2
    public void More() throws InterruptedException {
        WebElement scroll = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[12]/button"));
        Actions action = new Actions(driver);
        action.moveToElement(scroll).perform();
        Thread.sleep(4000);
        WebElement butElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[12]/button"));
        butElement.click();
        Thread.sleep(3000);
    }

    @AfterTest // Phương thức được chạy sau khi các phương thức kiểm thử được thực thi
    public void Close() {
        driver.quit(); // Đóng trình duyệt
    }
}