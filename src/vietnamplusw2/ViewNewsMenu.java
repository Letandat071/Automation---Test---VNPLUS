package vietnamplusw2;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import graphql.language.Argument;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewNewsMenu {

    // Khai báo biến driver để sử dụng trong toàn bộ lớp
    public WebDriver driver;

    // Phương thức thiết lập trước mỗi bài kiểm tra
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập trình điều khiển Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Thêm tiện ích mở rộng uBlock-Origin cho Chrome
        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
        // Khởi tạo đối tượng WebDriver với trình điều khiển Chrome và các tùy chọn đã thiết lập
        driver = new ChromeDriver(options);
        // Mở trang web https://vietnamplus.vn/
        driver.get("https://vietnamplus.vn/");
        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }

    // Bài kiểm tra chức năng Menu
    @Test
    public void Menu() throws InterruptedException {
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        // Tìm và chọn phần tử có class "ic-menu"
        WebElement clickmenuElement = driver.findElement(By.className("ic-menu"));
        // Sử dụng JavascriptExecutor để thực hiện thao tác click trên phần tử menu
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickmenuElement);
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        // Tạo một số ngẫu nhiên từ 1 đến 19 
        Random radom = new Random();
        int rant = radom.nextInt(19) + 1;
        // Xây dựng xpath để chọn một mục menu ngẫu nhiên
        String xpathMenu = "/html/body/div[5]/ul/li[" + rant + "]/a";
        // Tìm và chọn phần tử menu theo xpath đã xây dựng
        WebElement menuElement = driver.findElement(By.xpath(xpathMenu));
        // Sử dụng JavascriptExecutor để thực hiện thao tác click trên phần tử menu
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuElement);
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        // Thực hiện thao tác click trên phần tử menu (quay lại trang chủ)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickmenuElement);
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        // Thực hiện thao tác click trên phần tử menu (quay lại trang trước đó)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuElement);
        // Tìm và chọn phần tử menu có xpath "/html/body/div[2]/div/div[1]/h1/a"
        WebElement menuTileOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1/a"));
        // Lấy nội dung văn bản của phần tử menu đã chọn
        String chudeString = menuTileOptionElement.getText();
        // In ra nội dung văn bản của phần tử menu
        System.out.println(chudeString);
        // Đóng trình duyệt
//        driver.close();
    }
}