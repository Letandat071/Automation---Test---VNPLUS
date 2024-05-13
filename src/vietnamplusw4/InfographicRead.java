package vietnamplusw4;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InfographicRead {
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
	public void Actions() throws InterruptedException {
		 WebElement scroll = driver.findElement(By.xpath("//*[@id=\"sidebar-top-1\"]/div[2]/div/article/h2/a")); // Tìm phần tử để cuộn
	        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver); // Tạo đối tượng action để thực hiện hành động
	        action.moveToElement(scroll).perform();
	        Thread.sleep(2000);
	        WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"sidebar-top-1\"]/div[2]/div/article/h2/a"));
	        clickElement.click();
	        clickElement.click();
	        Thread.sleep(2000);
	        WebElement titlString=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1"));
	        String texString = titlString.getText();
	        System.out.println("Tiêu đề Infographic lấy được là: " +texString);
	        
	}

}