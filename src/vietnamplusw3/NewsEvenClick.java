package vietnamplusw3;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewsEvenClick { // Khai báo lớp NewsEvenClick

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
        driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
    }

    @Test(priority = 1) // Phương thức kiểm thử đánh dấu là ưu tiên 1
    public void Login() throws InterruptedException {
        Thread.sleep(3000); // Dừng chương trình trong 5 giây để chờ trang web tải hoàn thành
        // Điền địa chỉ email vào trường đăng nhập.
        driver.findElement(By.xpath("//*[@id=\"txtLoginEmail\"]"))
              .sendKeys("hok74554@gmail.com");
        // Điền mật khẩu vào trường mật khẩu đăng nhập.
        driver.findElement(By.xpath("//*[@id=\"txtLoginPassword\"]"))
              .sendKeys("14102003");
        // Click vào nút đăng nhập.
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
        Thread.sleep(2000); // Dừng chương trình trong 2 giây để chờ trang web phản hồi
    }

    @Test(priority = 2) // Phương thức kiểm thử đánh dấu là ưu tiên 2
    public void ClickNews() throws InterruptedException {
    	   Thread.sleep(3000);
           Random random = new Random();
           int ran = random.nextInt(8) + 1; // Thay đổi để chỉ số bắt đầu từ 1
           String RandomNews = "/html/body/div[2]/div/div/a[" + ran + "]";

           // Kiểm tra xem có ít nhất một phần tử tồn tại trong danh sách
           if (driver.findElements(By.xpath(RandomNews)).size() > 0) {
               WebElement ChooseRandom = driver.findElement(By.xpath(RandomNews)); // Tìm phần tử tin tức ngẫu nhiên
               ChooseRandom.click(); // Click vào tin tức ngẫu nhiên
               Thread.sleep(2000);
           } else {
               System.out.println("Không tìm thấy phần tử tin tức ngẫu nhiên");
           }
       
        Thread.sleep(2000);
        WebElement stringTextElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1"));
        String printString=stringTextElement.getText();
        System.out.println("Tiêu đề của tin tức chọn được là: "+printString);
    }

    @AfterTest // Phương thức được chạy sau khi các phương thức kiểm thử được thực thi
    public void Close() {
        driver.quit(); // Đóng trình duyệt
    }
}