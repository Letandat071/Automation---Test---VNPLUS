package vietnamplusw5;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class authenticationTest {
	static WebDriver driver;

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
	    public void TC_04_usecookies() throws InterruptedException {
	        // ... (code you already have)


		  WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[3]/div[1]/div[4]/div/div[1]"));

		// Sử dụng JavascriptExecutor để cuộn trang đến phần tử đó
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement titleButton1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[3]/div[1]/div[4]/div/div[1]/select"));
        titleButton1.click(); // vào mục title cần xem
        Thread.sleep(2000); // thời gian chờ
     // Xác định phần tử <select> bằng XPath
        WebElement selectElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[3]/div[1]/div[4]/div/div[1]/select"));

        // Tạo đối tượng Select từ phần tử <select>
        Select select = new Select(selectElement);

        // Lấy danh sách các phần tử con trong <select>
        List<WebElement> options = select.getOptions();

        // Tạo một số ngẫu nhiên trong phạm vi từ 0 đến số lượng phần tử trong danh sách
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());

        // Chọn một phần tử trong danh sách dựa trên số ngẫu nhiên được tạo ra
        select.selectByIndex(randomIndex);
        selectElement.click();
        Thread.sleep(2000);
	       
}
}      
    
              
  

    //@AfterClass
    //public void afterClass() {
        //driver.quit();
    
  