package vietnamplus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewNews {
	
	public WebDriver driver;
	 @BeforeTest
	    public void Setup() {

	        // Setup
	        WebDriverManager.chromedriver().setup();

	        // Khởi tạo ChromeOptions và thêm tiện ích mở rộng
	        ChromeOptions options = new ChromeOptions();
	        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
	        options.addExtensions(new File("E:\\Anti-Captcha-Blocker-Extension.crx"));
	        // Khởi tạo WebDriver với ChromeOptions
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
			 driver.get("https://www.vietnamplus.vn/");
	    }
	 
	 @Test (priority = 0)
	 public void Login() throws InterruptedException {
	        // Click Đăng nhập
	        driver.findElement(By.id("userprofile")).click();
	        Thread.sleep(2000);
	        // Tài khoản
	        driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw22403@omeie.com");
	        driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
	        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
	        Thread.sleep(2000);
	        
	 }
	 
	 @Test (priority = 1)
	 public void views() throws InterruptedException {
		 Random random = new Random();

		 int rand = random.nextInt(4)+1;
		 String xpath = "/html/body/div[3]/div/div[2]/div[3]/div[1]/div/article[" + rand + "]/h2";
		 WebElement news = driver.findElement(By.xpath(xpath));
		 news.click();
		 news.click();
		 Thread.sleep(2000); 
		 WebElement newsTitle =driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
		 String firstname = newsTitle.getAttribute("textContent").trim();
		 System.out.println(firstname);
		 
		 Thread.sleep(2000); 
		 driver.findElement(By.id("userprofile")).click();
		 WebElement newshadseen = driver.findElement(By.className("history"));
	     	((JavascriptExecutor) driver).executeScript("arguments[0].click();", newshadseen);
	     	Thread.sleep(2000);
	     	
	     	
	     	List<String> arrayList = new ArrayList();
	     	for (int i = 1; i <= 6; i++) {
	            String xpath2 = "//*[@id=\"user-history-list\"]/article[" + i + "]/h3/a";
	            WebElement article = driver.findElement(By.xpath(xpath2));
	            String text = article.getText();
	            arrayList.add(text);
	        }
	     	
	     	if(arrayList.contains(firstname)) {
	     		System.out.println("Đã xem tin và xác nhận thành công");
	     	}
	     	else {
				System.out.println("Xem tin thất bại!!");
			}

	     	

	 }
	 
	
	 
	 @AfterTest
	 public void tearDown() {
	     driver.quit();
	 }
	
}
