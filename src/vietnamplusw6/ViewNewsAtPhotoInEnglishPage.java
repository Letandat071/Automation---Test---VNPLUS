package vietnamplusw6;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class ViewNewsAtPhotoInEnglishPage {
    static WebDriver driver; // Khai báo biến driver để sử dụng trong toàn bộ lớp

    @BeforeTest // Annotation BeforeTest: được thực thi trước khi bất kỳ test nào trong lớp test được thực hiện
    public void setup() throws InterruptedException { // Phương thức setup, được thực hiện trước mỗi test
        WebDriverManager.chromedriver().setup(); // Thiết lập trình điều khiển ChromeDriver tự động với WebDriverManager
        ChromeOptions opt = new ChromeOptions(); // Tạo một đối tượng ChromeOptions để cấu hình tùy chọn trình duyệt Chrome
        opt.addExtensions(new File("E:\\uBlock-Origin.crx")); // Thêm phần mở rộng uBlock Origin vào trình duyệt Chrome
        driver = new ChromeDriver(opt); // Khởi tạo một đối tượng ChromeDriver với tùy chọn đã thiết lập
        driver.manage().window().maximize(); // Mở cửa sổ trình duyệt lên cỡ tối đa
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn

    }
    @Test
    public void Action() throws InterruptedException {
    	Thread.sleep(3000);
        driver.get("https://www.vietnamplus.vn/"); // Mở URL của trang web VietnamPlus
    	driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();  //Lấy danh sách các cửa sổ đang mở trong trình duyệt và đặt chúng vào một Set (tập hợp).
		Iterator<String> iterator = window.iterator();  //Tạo một iterator để lặp qua từng cửa sổ trong danh sách cửa sổ.
		String parentwindow = iterator.next(); //Lấy ra cửa sổ đầu tiên từ danh sách (cửa sổ cha) và gán vào biến parentwindow.
		String childwindow= iterator.next();  //Lấy ra cửa sổ thứ hai từ danh sách (cửa sổ con) và gán vào biến childwindow
		driver.switchTo().window(childwindow); //Chuyển đổi sự quản lý của trình duyệt từ cửa
    	  WebElement scroll = driver.findElement(By.xpath("//*[@id=\"st-container\"]/div/div/div/div[4]/div[2]/section[1]/header/h3")); // Tìm phần tử để cuộn
          Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
          action.moveToElement(scroll).perform();
          Thread.sleep(4000);
			for (int i = 1; i <= 4; i++) {
				String xpathButton = "//*[@id=\"st-container\"]/div/div/div/div[3]/div/div/article["+i+"]/a";
				WebElement itemElement = driver.findElement(By.xpath(xpathButton));
				itemElement.click();
				Thread.sleep(2000);
		        WebElement text = driver.findElement(By.className("details__headline")); // Tìm tiêu đề tin tức
		        String PrintText = text.getText(); // Lấy văn bản của tiêu đề tin tức
		        System.out.println("Tiêu đề của trang thứ "+i+" là: "+PrintText); // In tiêu đề tin tức ra màn hình
				Thread.sleep(2000); 
				driver.navigate().back();
				Thread.sleep(3000);
			}
			driver.switchTo().window(parentwindow); //Chuyển đổi sự quản lý của trình duyệt về trang cha 
    }
    @AfterTest
    public void Close() {
    	driver.close();
    }
}
