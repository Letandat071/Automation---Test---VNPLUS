package vietnamplusw6;

import java.awt.Window;
import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import graphql.language.Argument;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_English {

    // Khai báo biến driver để sử dụng trong toàn bộ lớp
    public WebDriver driver;

    // Phương thức thiết lập trước mỗi bài kiểm tra
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập trình điều khiển Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Thêm tiện ích mở rộng uBlock-Origin cho Chrome
        options.addExtensions(new File("B://uBlock-Origin.crx"));

        // Khởi tạo đối tượng WebDriver với trình điều khiển Chrome và các tùy chọn đã thiết lập
        driver = new ChromeDriver(options);

        // Mở trang web https://vietnamplus.vn/
        driver.get("https://vietnamplus.vn/");

        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }
    
	
    
    
    @Test(priority = 0)
    public void ChangeEn() throws InterruptedException {
    	// Truy cập vào trang web En-Vie tnamPlus.
    	WebElement VNE = driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", VNE);
    	
    	//
    	String currentWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        Thread.sleep(2000);
        String tranghientaiString = "https://www.vietnamplus.vn/";
        if(!driver.getCurrentUrl().equals(tranghientaiString)) {
        	System.out.println("Chuyển trang thành công");
        	System.out.println("Đã chuyển đến trang "+ driver.getCurrentUrl());
        } else {
			System.out.println("Chuyển trang thất bại");
		}
        System.out.println("----------------------------------");
        Thread.sleep(4000);
    }
    
    @Test(priority = 1)
    public void SearchTC1() throws InterruptedException {
        // Tìm ô tìm kiếm có thẻ a để thực hiện tìm kiếm và click vào đó bằng JavaScript.
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSearch);

        //Input để nhập từ khóa tìm kiếm "Wood".
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/input")).sendKeys("Wood");
        
        // Tìm và click vào nút tìm kiếm.
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a/i")).click();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        
        WebElement getTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a"));
        
       System.out.println(getTitle.getText());
       System.out.println("----------------------------------");
       Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void SearchTC2() throws InterruptedException {
        // Tìm ô tìm kiếm có thẻ a để thực hiện tìm kiếm và click vào đó bằng JavaScript.
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSearch);

        //Input để nhập từ khóa tìm kiếm "Wood".
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/input")).sendKeys("    ");
        
        // Tìm và click vào nút tìm kiếm.
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a/i")).click();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        
        WebElement getTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a"));
        
       System.out.println(getTitle.getText());
       System.out.println("----------------------------------");
       Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void SearchTC3() throws InterruptedException {
        // Tìm ô tìm kiếm có thẻ a để thực hiện tìm kiếm và click vào đó bằng JavaScript.
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSearch);

        //Input để nhập từ khóa tìm kiếm "Wood".
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/input")).sendKeys("@#$%^&*:><?Ư|");
        
        // Tìm và click vào nút tìm kiếm.
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a/i")).click();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        
        WebElement getTitle1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/h1"));
        WebElement getTitle2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/p"));
        
       System.out.println(getTitle1.getText());
       System.out.println(getTitle2.getText());
       System.out.println("----------------------------------");
       Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void SearchTC4() throws InterruptedException {
        // Tìm ô tìm kiếm có thẻ a để thực hiện tìm kiếm và click vào đó bằng JavaScript.
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSearch);

        //Input để nhập từ khóa tìm kiếm "Wood".
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/input")).sendKeys("123245525836591");
        
        // Tìm và click vào nút tìm kiếm.
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a/i")).click();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
        
        WebElement getTitle1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a"));
//        WebElement getTitle2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/p"));
        
       System.out.println(getTitle1.getText());
//       System.out.println(getTitle2.getText());
       System.out.println("----------------------------------");
       Thread.sleep(2000);
    }
    @AfterTest
    public void AfterTest() throws InterruptedException {
    	// Đóng chương trình
    	driver.quit();
    }
}