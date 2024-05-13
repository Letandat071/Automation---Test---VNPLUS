package vietnamplusw2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestFailAccount {
	static WebDriver driver;
	  @Test(dataProvider="Account")
	  public void TestAccount(String username, String password) throws InterruptedException { 
		   WebDriverManager.chromedriver().setup();
	        ChromeOptions opt = new ChromeOptions();
	        opt.addExtensions(new File("E:\\uBlock-Origin.crx"));
	        driver = new ChromeDriver(opt);
	        driver.manage().window().maximize();
	        Thread.sleep(5000);
		  driver.navigate().to("https://www.vietnamplus.vn/");
	       Thread.sleep(2000);
	      driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.id("txtLoginEmail")).sendKeys(username);
	      Thread.sleep(2000);
	      driver.findElement(By.id("txtLoginPassword")).sendKeys(password);
	      Thread.sleep(2000);	      
	      driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
	      Thread.sleep(2000);	      
	      driver.findElement(By.id("userprofile")).click();
	      Thread.sleep(2000);	      
	      driver.close();

	
	  }

	@DataProvider(name = "Account")
	public Object[][] TestingAccount() 
	{
		return new Object[][] {
			
			{
				"hok74554@gmail.com","14102003"    //Thông tin tài khoản đúng
			},
			
			{ 
				"hok74554@gmail.com","14102005"    //Thông tin tài khoản sai
			},
			
			{
				"slendertv12@gmail.com","slendertv123"    //Thông tin tài khoản đúng
			},

			
			{
				"slendertv12@gmail.com","slendertv1"    //Thông tin tài khoản sai
			},
			

		};
		
	};
	
}