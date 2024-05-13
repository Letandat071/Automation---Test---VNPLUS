package vietnamplusw5;

import java.io.File; // Import thư viện để làm việc với File
import java.util.Random; // Import thư viện để sử dụng lớp Random

import org.openqa.selenium.By; // Import các lớp từ gói org.openqa.selenium để tương tác với các phần tử trên trình duyệt
import org.openqa.selenium.WebDriver; // Import lớp WebDriver từ gói org.openqa.selenium để điều khiển trình duyệt
import org.openqa.selenium.WebElement; // Import lớp WebElement từ gói org.openqa.selenium để tương tác với các phần tử web
import org.openqa.selenium.chrome.ChromeDriver; // Import lớp ChromeDriver từ gói org.openqa.selenium.chrome để điều khiển trình duyệt Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Import lớp ChromeOptions từ gói org.openqa.selenium.chrome để cấu hình tùy chọn cho trình duyệt Chrome
import org.testng.annotations.AfterTest; // Import annotation AfterTest từ gói org.testng.annotations để thiết lập việc thực thi sau mỗi bài kiểm tra
import org.testng.annotations.BeforeTest; // Import annotation BeforeTest từ gói org.testng.annotations để thiết lập việc thực thi trước mỗi bài kiểm tra
import org.testng.annotations.Test; // Import annotation Test từ gói org.testng.annotations để đánh dấu phương thức là một bài kiểm tra

import io.github.bonigarcia.wdm.WebDriverManager; // Import lớp WebDriverManager từ gói io.github.bonigarcia.wdm để quản lý trình điều khiển trình duyệt

public class ViewNewsFollowArea {
    public WebDriver driver; // Khai báo biến driver kiểu WebDriver để điều khiển trình duyệt

    // Phương thức thiết lập trước mỗi bài kiểm tra
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập trình điều khiển Chrome
    	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(
		new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx"));
		driver = new ChromeDriver(options);
		driver.get("https://www.vietnamplus.vn/");

        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);

        // Mở trang web https://www.vietnamplus.vn/region/tp-ho-chi-minh/126.vnp
        driver.get("https://www.vietnamplus.vn/region/tp-ho-chi-minh/126.vnp");

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);

        // Tạo một số ngẫu nhiên để chọn khu vực
        Random khuvucRandom = new Random();
        int random64TinhThanh = khuvucRandom.nextInt(64) + 1;
        String xpathKV = "/html/body/div[2]/div/div[2]/div[2]/select/option["+random64TinhThanh+"]";

        // Click vào phần tử được chọn ngẫu nhiên
        driver.findElement(By.xpath(xpathKV)).click();

        // Lấy tiêu đề của trang web
        WebElement titleWeb = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1/a"));
        System.out.println("Chọn khu vực để xem báo: "+ titleWeb.getText());

        // Tạm dừng chương trình trong 3 giây
        Thread.sleep(3000);
    }

    // Phương thức kiểm tra chọn bài báo
    @Test (priority = 0)
    public void ChonBaiBao() throws InterruptedException {
        // Click vào bài báo được chọn
        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/article/h2/a")).click();

        // Lấy tiêu đề của bài báo
        WebElement titleBaiBao = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
        System.out.println("Vùng chọn xem báo ở khung bên trái đầu tiên: "+ titleBaiBao.getText());

        // Tạm dừng chương trình trong 3 giây
        Thread.sleep(3000);

        // Quay lại trang trước đó
        driver.navigate().back();

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }

    // Phương thức kiểm tra chọn bài báo 2
    @Test (priority = 1)
    public void ChonBaiBao2() throws InterruptedException {
        // Tạo một số ngẫu nhiên để chọn bài báo
        Random baibao = new Random();
        int randombaibao = baibao.nextInt(2)+1;
        String xpathbaibao = "/html/body/div[2]/div/div[4]/div[1]/article["+randombaibao+"]/h2/a";
        
        // Click vào bài báo được chọn
        driver.findElement(By.xpath(xpathbaibao)).click();

        // Lấy tiêu đề của bài báo
        WebElement titleBaiBao = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
        System.out.println("Vùng chọn xem báo ở khung bên phải: "+ titleBaiBao.getText());

        // Tạm dừng chương trình trong 3 giây
        Thread.sleep(3000);

        // Quay lại trang trước đó
        driver.navigate().back();

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }

    // Phương thức kiểm tra chọn bài báo 3
    @Test (priority = 2)
    public void ChonBaiBao3() throws InterruptedException {
        // Tạo một số ngẫu nhiên để chọn bài báo
        Random baibao = new Random();
        int randombaibao = baibao.nextInt(4)+1;
        String xpathbaibao = "/html/body/div[2]/div/div[4]/div[2]/article["+randombaibao+"]/h2/a";
        
        // Click vào bài báo được chọn
        driver.findElement(By.xpath(xpathbaibao)).click();

        // Lấy tiêu đề của bài báo
        WebElement titleBaiBao = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
        System.out.println("Vùng chọn xem báo ở khung bên dưới: "+ titleBaiBao.getText());

        // Tạm dừng chương trình trong 3 giây
        Thread.sleep(3000);
    }

    // Phương thức sau mỗi bài kiểm tra
    @AfterTest
    public void  AfterTest() {
        // Đóng trình duyệt
        driver.close();
    }
}

