package vietnamplusw4;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsuallyRead {
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
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"sidebar-top-2\"]/div[3]/div/article[2]/h2")); // Tìm phần tử để cuộn
        Actions action = new Actions(driver); // Tạo đối tượng action để thực hiện hành động
        action.moveToElement(scroll).perform();
        Thread.sleep(4000);
        WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"sidebar-top-2\"]/div[3]/h3/a"));
        clickElement.click();
        clickElement.click();

        
	}
	@Test
	public void Actions2() throws InterruptedException {
		Thread.sleep(4000);
		Random rd = new Random();
		int randomValue = rd.nextInt(20);
		String xpathPC = "/html/body/div[2]/div/div[3]/div[1]/div/article["+randomValue+"]/h2/a";
		WebElement itemElement = driver.findElement(By.xpath(xpathPC));
		itemElement.click();
		
	}
	
}