package vietnamplusw3;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WatchNewsSame {
	public WebDriver driver;
	ArrayList<String> listieude = new ArrayList<String>();

	@BeforeTest
	public void Setup() throws InterruptedException {

		// Setup
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
	        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
	        options.addExtensions(new File("E:\\Anti-Captcha-Blocker-Extension.crx"));
	        // Khởi tạo WebDriver với ChromeOptions
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
			 driver.get("https://www.vietnamplus.vn/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void views() throws InterruptedException {
		Random random = new Random();
		int rand = random.nextInt(4) + 1;
		String xpath = "/html/body/div[3]/div/div[2]/div[3]/div[1]/div/article[" + rand + "]/h2";
		WebElement news = driver.findElement(By.xpath(xpath));
		news.click();
		news.click();
	}

	@Test(priority = 2)
	public void scrollview() throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement scroll = driver
					.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[12]/button"));
			Actions action = new Actions(driver);
			action.moveToElement(scroll).perform();
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			WebElement scroll = driver
					.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[13]/button"));
			Actions action = new Actions(driver);
			action.moveToElement(scroll).perform();
			Thread.sleep(4000);
		}

	}

	@Test(priority = 3)
	public void gettile() throws InterruptedException {
		Random random= new Random();
		int chisorandom = random.nextInt(30) +1;
		try {
			Thread.sleep(2000);
			for (int i = 1; i <= 30; i++) {
				WebElement titlelistElement = driver.findElement(
						By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[12]/div/article[" + i + "]/h2/a"));
				listieude.add(titlelistElement.getText());
			}
			Thread.sleep(2000);
			WebElement baibaoElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[12]/div/article[" + chisorandom + "]/h2/a"));
			baibaoElement.click();
		} catch (Exception e) {
			Thread.sleep(2000);
			for (int i = 1; i <= 30; i++) {
				WebElement titlelistElement = driver.findElement(
						By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[13]/div/article[" + i + "]/h2/a"));
				listieude.add(titlelistElement.getText());
			}
			
			Thread.sleep(2000);
			WebElement baibaoElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[4]/div[1]/div[13]/div/article[" + chisorandom + "]/h2/a"));
			baibaoElement.click();
		
			
		}
	}


}


