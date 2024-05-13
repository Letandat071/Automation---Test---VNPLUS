package vietnamplus;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateProfileWithUnlimitedData {
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
        driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"txtLoginEmail\"]"))
              .sendKeys("hok74554@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"txtLoginPassword\"]"))
              .sendKeys("14102003");
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void UpdateProfile() throws InterruptedException {
        driver.findElement(By.id("userprofile")).click();
        driver.findElement(By.className("ic-profile")).click();
        Thread.sleep(6000);
        
        // Set new value for Name with unlimited data
        WebElement nameElement = driver.findElement(By.xpath("//*[@id=\"txtName\"]"));
        setValue(nameElement, "This is a very long name with unlimited "
        		+ "characters. Lorem ipsum dolor sit amet, consectetur adipiscing"
        		+ " elit. Sed do eiusmod tempor incididunt ut labore et dolore mag"
        		+ "na aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco"
        		+ " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor"
        		+ " in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        		+ " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt "
        		+ "mollit anim id est laborum.");

        // Select Gender
        Select genderSelect = new Select(driver.findElement(By.id("cbGender")));
        genderSelect.selectByValue("1");
        Thread.sleep(2000);

        // Select Birth Day
        Select daySelect = new Select(driver.findElement(By.id("lsBirthDay")));
        daySelect.selectByValue("14");
        Thread.sleep(2000);

        // Select Birth Month
        Select monthSelect = new Select(driver.findElement(By.id("lsBirthMonth")));
        monthSelect.selectByValue("10");
        Thread.sleep(2000);

        // Select Birth Year
        Select yearSelect = new Select(driver.findElement(By.id("lsBirthYear")));
        yearSelect.selectByValue("2003");
        
        // Clear and set new value for Address
        WebElement addressElement = driver.findElement(By.xpath("//*[@id=\"txtAddress\"]"));
        setValue(addressElement, "!@!#$$$$$@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // Click on Update Profile button
        driver.findElement(By.id("btnUpdateProfile")).click(); 

        // Print the content of h3 element
        Thread.sleep(3000);
        WebElement h3Element = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]"));
        String h3 = h3Element.getText();
        System.out.println("Nội dung của phần tử <h3> là: " + h3);

        // Close modal
        driver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
    }

    private void setValue(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, value);
    }
    @AfterClass
    public void closeBrowser() {
    	driver.quit();
    }
}