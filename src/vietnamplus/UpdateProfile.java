package vietnamplus;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class UpdateProfile {
    static WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {

        // Setup
        WebDriverManager.chromedriver().setup();

        // Khởi tạo ChromeOptions và thêm tiện ích mở rộng
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("E:\\uBlock-Origin.crx"));
        options.addExtensions(new File("E:\\Anti-Captcha-Blocker-Extension.crx"));
        // Khởi tạo WebDriver với ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.navigate().to("https://www.vietnamplus.vn/");;
    }
    @Test
    public void Login() throws InterruptedException {
        Thread.sleep(5000);	
        driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"txtLoginEmail\"]"))
              .sendKeys("hok74554@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"txtLoginPassword\"]"))
              .sendKeys("14102003");
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();  
    }
    
    @Test
    public void Updateprofile() throws InterruptedException {
        driver.findElement(By.id("userprofile")).click();
        driver.findElement(By.className("ic-profile")).click();
        Thread.sleep(6000);
        WebElement deleteoldtext = driver.findElement(By.xpath("//*[@id=\"txtName\"]"));
		Actions action = new Actions(driver);
		action.keyDown(deleteoldtext,Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Hoàng Khang';", deleteoldtext);
		
		Thread.sleep(3000);
		 WebElement deleteoldphone = driver.findElement(By.xpath("//*[@id=\"txtPhone\"]"));
		Actions action2 = new Actions(driver);
		action2.keyDown(deleteoldphone,Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '0965484027';", deleteoldphone);
		
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.id("cbGender"));
		Select select = new Select(dropdown);
		select.selectByValue("1");
		Thread.sleep(2000); 
		
		WebElement dropdown2=driver.findElement(By.id("lsBirthDay"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("14");
		Thread.sleep(2000); 
		
		WebElement dropdown3=driver.findElement(By.id("lsBirthMonth"));
		Select select3 = new Select(dropdown3);
		select3.selectByValue("10");
		Thread.sleep(2000); 

		
		WebElement dropdown4=driver.findElement(By.id("lsBirthYear"));
		Select select4 = new Select(dropdown4);
		select4.selectByValue("2003");
		
		 WebElement deleteoldaddress = driver.findElement(By.xpath("//*[@id=\"txtAddress\"]"));
		 Actions action3 = new Actions(driver);
		 action3.keyDown(deleteoldaddress,Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).perform();
		 Thread.sleep(3000);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Thành Phố Hồ Chí Minh';", deleteoldaddress);
			
		 Thread.sleep(3000);
	     driver.findElement(By.id("btnUpdateProfile")).click(); 
	     
		 Thread.sleep(3000);
		 WebElement h3Element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]"));
		String h3 = h3Element.getText();
        System.out.println("Nội dung của phần tử <h3> là: " + h3);
        
        driver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
        
    }
    @AfterClass
    public void closeBrowser() {
    	driver.quit();
    }

}
