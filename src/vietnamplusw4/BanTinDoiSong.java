package vietnamplusw4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BanTinDoiSong {
	static WebDriver driver;

	String chromeDriverPath = "D:\\chromedriver.exe"; // Đường dẫn tới ChromeDriver

	@BeforeClass
	public void beforeClass() throws InterruptedException {
	// Thiết lập đường dẫn ChromeDriver
	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	// Khởi tạo một đối tượng WebDriver mới bằng ChromeDriver
	driver = new ChromeDriver();
	// Cấu hình thời gian chờ cho WebDriver là 30 giây
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// Phóng to cửa sổ của trình duyệt lên kích thước tối đa trên màn hình
	driver.manage().window().maximize();
	// Mở trang web có URL được cung cấp ("https://www.vietnamplus.vn/") trên trình duyệt Chrome đã được khởi tạo trước đó.
	driver.navigate().to("https://www.vietnamplus.vn/");
	WebElement acceptButton = driver.findElement(By.xpath("/html/body/header/div/div/i[1]"));
	acceptButton.click(); // Click vào nút chấp nhận
	Thread.sleep(2000);
	WebElement DoiSongButton = driver.findElement(By.xpath("/html/body/div[5]/ul/li[6]/a"));
	DoiSongButton.click(); //click vào mục đời sống
	Thread.sleep(3000);
	}
	@Test
	public void TC_04_usecookies() throws InterruptedException {
	// ... (code you already have)
	driver.navigate().to("https://www.vietnamplus.vn/doisong/");
	Thread.sleep(10000);
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.vietnamplus.vn/doisong/");
}
}