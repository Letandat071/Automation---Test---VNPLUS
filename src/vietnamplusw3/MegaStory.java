package vietnamplusw3;

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

public class MegaStory {
	public WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(
		new File("E:\\\\uBlock-Origin.crx"));
		driver = new ChromeDriver(options);
		driver.get("https://www.vietnamplus.vn/");
		Thread.sleep(2000);
	}

	/// html/body/div[3]/div/div[10]/div/article[1]/figure/a
	/// html/body/div[3]/div/div[10]/div/article[2]/figure/a
	@Test
	public void viewstory() throws InterruptedException {
		Thread.sleep(2000);
		Random random = new Random();
		int randomValue = random.nextInt(4);

		String xpathPC = "html/body/div[3]/div/div[10]/div/article[" + randomValue + "]/figure/a";

		WebElement itemElement = driver.findElement(By.xpath(xpathPC));
		// String titlemongdoiString = itemElement.getText();

		itemElement.click();
		Thread.sleep(2000);
		WebElement stringTextElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1"));
		String printString = stringTextElement.getText();
		System.out.println("Tiêu đề của tin tức chọn được là: " + printString);

	}
}