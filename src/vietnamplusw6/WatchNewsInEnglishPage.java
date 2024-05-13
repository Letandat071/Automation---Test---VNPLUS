package vietnamplusw6;
import java.io.File;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WatchNewsInEnglishPage {
    public WebDriver driver;
    Random random = new Random();

    @BeforeTest
  	public void setup()throws InterruptedException {
  		WebDriverManager.chromedriver().setup();
  		ChromeOptions options = new ChromeOptions();
          options.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx"));
  		driver = new ChromeDriver(options);
  		Thread.sleep(2000);
  	}

    @Test
    public void Action() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://www.vietnamplus.vn/");
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        Thread.sleep(2000);

        // Lấy danh sách cửa sổ đang mở
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        // Chờ cho cửa sổ con hoàn toàn mở và sẵn sàng
        while (driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[3]/a")).size() == 0) {
            Thread.sleep(1000);
        }

        String[] xpaths1 = {
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[2]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[3]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[4]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[5]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[6]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[7]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[8]/a",
                "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[1]/ul/li[9]/a"
        };
        
        String[] xpaths2 = {
                "/html/body/div[1]/div/div/div/div[2]/div/div/article/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div/div/ul/li[1]/article[1]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div/div/ul/li[1]/article[2]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div/div/ul/li[2]/article[1]/h2/a",
                "/html/body/div[1]/div/div/div/div[2]/div/div/ul/li[2]/article[2]/h2/a"
            };
        
        int randomIndex1 = random.nextInt(xpaths1.length);
        String randomXPath1 = xpaths1[randomIndex1];
        WebElement element1 = driver.findElement(By.xpath(randomXPath1));
        element1.click();
        Thread.sleep(3000);
        
        int randomIndex2 = random.nextInt(xpaths2.length);
        String randomXPath2 = xpaths2[randomIndex2];
        WebElement element2 = driver.findElement(By.xpath(randomXPath2));
        element2.click();
    }
}