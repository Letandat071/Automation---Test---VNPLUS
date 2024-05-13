package vietnamplusw4;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeLineView {
	public WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(
		new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx"));
		driver = new ChromeDriver(options);
		driver.get("https://www.vietnamplus.vn/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test
	public void ViewTL() throws InterruptedException {
		// Mở trang web VietnamPlus Timeline
		driver.get("https://www.vietnamplus.vn/timeline/");
		// Tạm dừng chương trình trong 3 giây để chờ trang web load hoàn tất
		Thread.sleep(3000);
		// Tạo một đối tượng Random để chọn ngẫu nhiên một bài báo trong danh sách
		Random random = new Random();
		int randomValue = random.nextInt(3) + 1;
		// Tạo đường dẫn xpath để truy cập vào một bài báo ngẫu nhiên trong danh sách
		String xpathKT = ("/html/body/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/article[" +randomValue + "]/h2/a");
		// Tìm phần tử (element) của bài báo đó bằng xpath
		WebElement itemElement = driver.findElement(By.xpath(xpathKT));
		// Click vào phần tử của bài báo
		itemElement.click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", itemElement);
		// Tạm dừng chương trình trong 3 giây để chờ trang web load hoàn tất
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		// Tìm phần tử (element) chứa tiêu đề của trang web
		WebElement titleElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
		// Lấy tiêu đề của trang web
	    String titleString = titleElement.getText();
	    // In ra tiêu đề của trang web
	    System.out.println("Tiêu đề bài viết: " + titleString);
	    // Tạm dừng chương trình trong 3 giây
		Thread.sleep(3000);
		// Đóng trình duyệt
	    driver.close();
	}	
}