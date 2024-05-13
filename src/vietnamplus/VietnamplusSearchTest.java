package vietnamplus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VietnamplusSearchTest {

	public static void main(String[] args) {
		// Thiết lập đường dẫn đến ChromeDriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        // Khởi tạo trình duyệt và mở trang web VietnamPlus
        driver.get("https://www.vietnamplus.vn/");


		try {

			// Tìm phần tử input theo class và placeholder
			WebElement searchBox = driver
					.findElement(By.cssSelector("input.search.txtsearch[placeholder='Nhập từ khóa']"));

			// Gửi từ khóa tìm kiếm và thực hiện tìm kiếm
			searchBox.sendKeys("ô tô"); // Tìm kiếm thông tin về vaccine (có thể thay đổi theo nhu cầu)
			searchBox.sendKeys(Keys.RETURN);

			// Chờ cho kết quả xuất hiện (ở đây, chờ 5 giây để đơn giản)
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Kiểm tra kết quả
			List<WebElement> searchResults = driver.findElements(By.xpath("//a[contains(@class, 'cms-link') and .//img]"));


			if (!searchResults.isEmpty()) {
				// In ra các kết quả đầu tiên
				for (WebElement result : searchResults.subList(0, Math.min(5, searchResults.size()))) {
					String title = result.getAttribute("title");
				    System.out.println("Title: " + title);
					System.out.println("URL: " + result.getAttribute("href"));
					System.out.println("--------");
				}
				
				System.out.println("Kiểm thử thành công!");
			} else {
				System.out.println("Không có kết quả tìm kiếm.");
			}

		} catch (Exception e) {
			System.out.println("Đã xảy ra lỗi: " + e.getMessage());
		} finally {
			// Đóng trình duyệt
			driver.quit();
		}
	}
	
	
	
	
}