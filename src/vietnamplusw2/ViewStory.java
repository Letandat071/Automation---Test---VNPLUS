package vietnamplusw2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class ViewStory {
  public WebDriver driver;

  @BeforeTest
	public void setup()throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
		driver = new ChromeDriver(options);
		driver.get("https://www.vietnamplus.vn/");
		Thread.sleep(2000);
	}
  
  @Test
	public void viewstory() throws InterruptedException  {
	  Thread.sleep(2000);
		Random random = new Random();
		int randomValue = random.nextInt(4) + 1;
		
		String xpathPC = "/html/body/div[3]/div/div[4]/div/article["+randomValue+"]/h2/a";
		
		WebElement itemElement = driver.findElement(By.xpath(xpathPC));
		String titlemongdoiString = itemElement.getText();
		
		itemElement.click();
		itemElement.click();
		
		if(driver.getTitle().contains(titlemongdoiString)) {
			System.out.println("Xem stories thành công !!");
		} else {
			System.out.println("Xem stories Thất bại");
		}
		

	}

  @AfterTest
  public void afterTest() {
	  driver.close();
	    }
  
  
  


}