package vietnamplusw6;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Random;

public class MostRecent {
	static WebDriver driver;
    String chromeDriverPath = "D:\\chromedriver.exe"; // Đường dẫn tới ChromeDriver

    @BeforeTest
  	public void setup()throws InterruptedException {
  		WebDriverManager.chromedriver().setup();
  		ChromeOptions options = new ChromeOptions();
          options.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx"));
  		driver = new ChromeDriver(options);
  		Thread.sleep(2000);
  	}
 
    @Test
    public void Action() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.get("https://www.vietnamplus.vn/"); // mở url của trang
    	driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
    	Thread.sleep(2000);
    	Set<String> window = driver.getWindowHandles(); // lấy danh sách các cửa sổ đang mở trong trình duyệt và đặt chúng vào 1 set
    	Iterator<String> iterator = window.iterator(); // tạo iterator để lập qua từng cửa sổ trong danh sách cửa sổ
    	String parentwindow = iterator.next();// lấy cửa sổ đầu tiên từ danh sách và gán vào parentwindow
    	String childwindow= iterator.next();// lấy cauwr sổ thứ 2 từ danh sách gán vào childwindow
    	driver.switchTo().window(childwindow); // chuyển đổi sự quản lý của trình duyệt
    }
   
        @Test
        public void testRandomLink2() {
        // Mảng chứa các đường dẫn
        String[] xpaths = {
                "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/section/div/article[1]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/section/div/article[2]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/section/div/article[3]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/section/div/article[4]/h2/a"
        };

        // Chọn một trong các đường dẫn ngẫu nhiên
        Random rand = new Random();
        int randomIndex = rand.nextInt(4); // Sinh số ngẫu nhiên từ 0 đến 3

        // Tìm và click vào phần tử có xpath tương ứng
        WebElement randomElement = driver.findElement(By.xpath(xpaths[randomIndex]));
        randomElement.click();
        
    }
}