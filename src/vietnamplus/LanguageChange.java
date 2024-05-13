package vietnamplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageChange {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://www.vietnamplus.vn/"); 
		driver.getTitle();
		// TODO Auto-generated method stub
		
            // VietnamPlus
            driver.get("https://www.vietnamplus.vn/");

            // ngôn ngữ Tiếng Việt
            WebElement vietnameseLink = driver.findElement(By.linkText("Tiếng Việt"));
            vietnameseLink.click();
            String vietnameseLanguage = driver.getTitle();

            // ngôn ngữ Tiếng Anh
            WebElement englishLink = driver.findElement(By.linkText("English"));
            englishLink.click();
            String englishLanguage = driver.getTitle();

            //ngôn ngữ Français
            WebElement frenchLink = driver.findElement(By.linkText("Français"));
            frenchLink.click();
            String frenchLanguage = driver.getTitle();

            // ngôn ngữ Español
            WebElement spanishLink = driver.findElement(By.linkText("Español"));
            spanishLink.click();
            String spanishLanguage = driver.getTitle();

            //  ngôn ngữ 中文
            WebElement chineseLink = driver.findElement(By.linkText("中文"));
            chineseLink.click();
            String chineseLanguage = driver.getTitle();

            // ngôn ngữ Русский
            WebElement russianLink = driver.findElement(By.linkText("Русский"));
            russianLink.click();
            String russianLanguage = driver.getTitle();

            System.out.println("Tiếng Việt: " + vietnameseLanguage);
            System.out.println("Français: " + frenchLanguage);
            System.out.println("Español: " + spanishLanguage);
            System.out.println("中文: " + chineseLanguage);
            System.out.println("Русский: " + russianLanguage);
            System.out.println("English: " + englishLanguage);
            
            Thread.sleep(3000);
            driver.quit();
        }
    }