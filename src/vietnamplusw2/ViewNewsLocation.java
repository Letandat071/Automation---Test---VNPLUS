package vietnamplusw2;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewNewsLocation {
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
	  public void ViewNewsLocation() throws InterruptedException {
		  driver.findElement(By.xpath("/html/body/header/div/div/i[1]")).click();
		  Random random = new Random();
	      int rand = random.nextInt(2)+ 1 ;
	      
	      String RandomNews = "/html/body/div[5]/ul/li[20]/ul/li["+ rand +"]/a";
	      WebElement ChooseRandom = driver.findElement(By.xpath(RandomNews));
	      ChooseRandom.click();
	      Thread.sleep(2000);
	   
	      
	    
	     
	      WebElement dropdown=driver.findElement(By.id("location-select"));
	      Select select = new Select(dropdown);
	      select.selectByValue("379");
	      Thread.sleep(2000);
	    
	      WebElement text =driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/article/h2"));
	      String PrintText = text.getText();
	      System.out.println(PrintText);
	  }
	  

}
