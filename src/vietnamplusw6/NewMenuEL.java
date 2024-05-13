package vietnamplusw6;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewMenuEL {

public WebDriver driver;


	@BeforeTest
	public void setup() throws InterruptedException {
	
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addExtensions(new File("E:\\uBlock-Origin.crx"));
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get("https://vietnamplus.vn/");
	    
	
	    Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void changelanguage() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
		
			
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
	}
	
	@Test (priority = 1)
	public void viewCategory() throws InterruptedException {
		Thread.sleep(2000);
		//Openmenu
		driver.findElement(By.id("st-trigger-effects")).click();
		Thread.sleep(500);
		
		Random random = new Random();
		int key = random.nextInt(1,2);
		switch (key) {
		case 1: {
			System.out.println("Xem tin theo danh mục");
			int sotin = random.nextInt(2,10);
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div/div/nav/ul/li["+sotin+"]/a")).click();
			Thread.sleep(1000);
			WebElement headerElement = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/a"));
			System.out.println("Đang xem tin tại trang " + headerElement.getText());
			break;
		}
		
		case 2: {
			System.out.println("Xem tin theo media");
			int sotin = random.nextInt(2,7);
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[11]/ul/li["+sotin+"]/a")).click();
			Thread.sleep(1000);
			WebElement headerElement = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/header/h3/a"));
			System.out.println("Đang xem tin tại trang " + headerElement.getText());
			break;
		}
		
		default:
			System.out.println("Xem thất bại");
			break;
		}
		
		driver.close();
	}
}
