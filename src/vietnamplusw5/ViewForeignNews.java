package vietnamplusw5;

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
import org.zeromq.ZStar.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewForeignNews {
	public WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(
		new File("E:\\uBlock-Origin.crx"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.vietnamplus.vn/");
		Thread.sleep(2000);
	}
	
	@Test
	public void CheckLink() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement scroll = driver.findElement(By.xpath("/html/body/footer/div[2]/div[1]/a")); // Tìm phần tử để cuộn
	        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform();
	        Thread.sleep(2000);
	        Random random = new Random();
	        int sotrang = random.nextInt(1,11);
	        Thread.sleep(2000);
	        
	        String currentWindow = driver.getWindowHandle();
	        
	        WebElement trangbaoElement = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/a["+sotrang+"]/img"));
	        trangbaoElement.click();

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
	        
	}

}
