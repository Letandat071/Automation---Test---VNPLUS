package vietnamplusw2;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewNewFromNotification {

	static WebDriver driver;
	  @BeforeTest
	    public void setup() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions opt = new ChromeOptions();
	        opt.addExtensions(new File("E:\\uBlock-Origin.crx"));
	        driver = new ChromeDriver(opt);
	        driver.manage().window().maximize();
	        Thread.sleep(5000);
	        driver.navigate().to("https://www.vietnamplus.vn/");
	        Thread.sleep(2000);
	    }
	  @Test
	    public void Login() throws InterruptedException {
	        Thread.sleep(5000); // Dừng chương trình trong 5 giây.
	        // Click vào biểu tượng người dùng để mở hộp thoại đăng nhập.
	        driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
	        Thread.sleep(2000); // Dừng chương trình trong 2 giây.
	        // Điền địa chỉ email vào trường đăng nhập.
	        driver.findElement(By.xpath("//*[@id=\"txtLoginEmail\"]"))
	              .sendKeys("hok74554@gmail.com");
	        // Điền mật khẩu vào trường mật khẩu đăng nhập.
	        driver.findElement(By.xpath("//*[@id=\"txtLoginPassword\"]"))
	              .sendKeys("14102003");
	        // Click vào nút đăng nhập.
	        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();  
	        Thread.sleep(2000);

	    }
	  @Test
	  public void ViewNewsNotifi() throws InterruptedException {
		  driver.findElement(By.xpath("/html/body/header/div/div/i[2]")).click();
		  Thread.sleep(2000);
		  
		  Random random = new Random();
	      int rand = random.nextInt(4) + 1;
	      
	      String RandomNews = "//*[@id=\"header-news\"]/div/article["+rand+"]/h3/a";
	      WebElement ChooseRandom = driver.findElement(By.xpath(RandomNews));
	      ChooseRandom.click();
	      
	      Thread.sleep(2000);
	     WebElement GetTextNews = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
		 String PrintText = GetTextNews.getText();
		 System.out.println("Tiêu đề của trang Web lấy được là: "+PrintText);
		  
	  }
		@AfterTest
		public void Close() {
			driver.close();
		}
}
