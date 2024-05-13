package vietnamplusw2;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.util.Random;
import javax.lang.model.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class ViewPodcast {
  
  public WebDriver driver;
	
  @BeforeTest
  public void setup() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();

      // Thêm tiện ích mở rộng uBlock-Origin cho Chrome
      options.addExtensions(new File("E:\\uBlock-Origin.crx"));

      // Khởi tạo đối tượng WebDriver với trình điều khiển Chrome và các tùy chọn đã thiết lập
      driver = new ChromeDriver(options);
      // Mở trang web https://vietnamplus.vn/
    // Mở trang web VietnamPlus Podcast
    driver.get("https://www.vietnamplus.vn/podcast/");
    // Mở cửa sổ trình duyệt với kích thước lớn nhất
    driver.manage().window().maximize();   
    // Tạm dừng chương trình trong 2 giây
    Thread.sleep(2000);
  }
  @Test
  public void ViewPostCast() throws InterruptedException {
    // Tạm dừng chương trình trong 2 giây
    Thread.sleep(2000);
    // Tạo một số ngẫu nhiên từ 1 đến 30
    Random random = new Random();
    int randomValue = random.nextInt(30) + 1;
    // Xây dựng đường dẫn XPath để chọn một bài podcast ngẫu nhiên
    String xpathPC = "/html/body/div[2]/div/div[6]/div/article[" + randomValue + "]/h2/a"; 
    // Tìm phần tử bài podcast theo XPath
    WebElement itemElement = driver.findElement(By.xpath(xpathPC));
    // Sử dụng JavascriptExecutor để thực hiện việc nhấp vào phần tử bài podcast
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", itemElement);  
    // Tạm dừng chương trình trong 2 giây
    Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
    // Tìm phần tử tiêu đề của bài podcast đã mở và in ra console
    WebElement titleElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div[1]/h1"));
    String titleString = titleElement.getText();
    System.out.println(titleString);
    // Đóng trình duyệt
    driver.close();
  }

}