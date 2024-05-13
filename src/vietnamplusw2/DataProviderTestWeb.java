package vietnamplusw2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestWeb {
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
	        Thread.sleep(4000);
	    }
	  @Test(dataProvider="Account")
	  public void TestAccount(String username, String password) throws InterruptedException { 
	      driver.findElement(By.xpath("//*[@id=\"userprofile\"]/a/i")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.id("txtLoginEmail")).sendKeys(username);
	      Thread.sleep(2000);
	      driver.findElement(By.id("txtLoginPassword")).sendKeys(password);
	      Thread.sleep(2000);	      
	      driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
	      Thread.sleep(3000);
		  driver.findElement(By.id("userprofile")).click();
		  driver.findElement(By.className("ic-profile")).click();
	
	  }
	
	@Test(dataProvider = "textDataProvider")   
	public void TestInforMationAccount(String expectedText, String expectedEmail, 
	String expectedPhone, String expectedGender, String expectedDay, 
	String expectedMonth, String expectedYear, String expectedAddress) throws InterruptedException {
	    boolean allMatched = true; // Biến để kiểm tra tất cả các giá trị mong đợi
	    
	    // Kiểm tra văn bản của trường tên
	    WebElement nameElement = driver.findElement(By.xpath("//*[@id=\"txtName\"]")); 
	    String nameText = nameElement.getAttribute("value");
	    Assert.assertEquals(nameText, expectedText, "Name không trùng khớp với giá trị mong đợi");
	    
	    // Kiểm tra văn bản của trường email
	    WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")); 
	    String emailText = emailElement.getAttribute("value");
	    Assert.assertEquals(emailText, expectedEmail, "Email không trùng khớp với giá trị mong đợi");
	    
	    WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"txtPhone\"]")); 
	    String phoneText = phoneElement.getAttribute("value");
	    Assert.assertEquals(phoneText, expectedPhone, "Phone không trùng khớp với giá trị mong đợi");
	    
        WebElement genderElement = driver.findElement(By.xpath(" //*[@id=\"cbGender\"]"));
        Select dropdown = new Select(genderElement);
        dropdown.selectByValue("1");
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
	    Assert.assertEquals(selectedText, expectedGender, "Giới tính không trùng khớp với giá trị mong đợi");
	    
	    WebElement dayElement = driver.findElement(By.xpath("//*[@id=\"lsBirthDay\"]")); 
        Select daydropdown = new Select(dayElement);
        daydropdown.selectByValue("14");
        WebElement selectedOption2 = daydropdown.getFirstSelectedOption();
        String selecteddayText = selectedOption2.getText();
	    Assert.assertEquals(selecteddayText, expectedDay, "Ngày không trùng khớp với giá trị mong đợi");
	    
	    WebElement monthElement = driver.findElement(By.xpath("//*[@id=\"lsBirthMonth\"]")); 
        Select monthdropdown = new Select(monthElement);
        monthdropdown.selectByValue("10");
        WebElement selectedOption3 = monthdropdown.getFirstSelectedOption();
        String selectedmonthText = selectedOption3.getText();
	    Assert.assertEquals(selectedmonthText, expectedMonth, "Tháng không trùng khớp với giá trị mong đợi");
	    
	    WebElement yearElement = driver.findElement(By.xpath("//*[@id=\"lsBirthYear\"]")); 
        Select yeardropdown = new Select(yearElement);
        yeardropdown.selectByValue("2003");
        WebElement selectedOption4 = yeardropdown.getFirstSelectedOption();
        String selectedyearText = selectedOption4.getText();
	    Assert.assertEquals(selectedyearText, expectedYear, "Năm không trùng khớp với giá trị mong đợi");
	 
	    WebElement addressElement = driver.findElement(By.xpath("//*[@id=\"txtAddress\"]")); 
	    String addressText = addressElement.getAttribute("value");
	    Assert.assertEquals(addressText, expectedAddress, "Địa chỉ không trùng khớp với giá trị mong đợi");
	    
	    if (allMatched) {
	        System.out.println("Tất cả các giá trị thông tin trùng khớp với Web");
	    }
	   
	    
	 
	}
	@DataProvider(name = "textDataProvider")
	public Object[][] getTextData() {
	    return new Object[][] {
	        {"Hoàng Khang",    		  //Value Tên expected trùng khớp
	         "hok74554@gmail.com",    //Value Email expected trung khớp
	         "0965484027",   		  //Value Phone expected trùng khớp
	         "Nam",					  //Value Gender expected trùng khớp
	         "14", 					  //Value Day expected trùng khớp
	         "10",					  //Value Month expected trùng khớp
	         "2003",				  //Value Year expected trùng khớp
	         "Thành Phố Hồ Chí Minh"  //Value Address expected trùng khớp
	         } 
	    };
	}
	
	@DataProvider(name = "Account")
	public Object[][] TestingAccount() 
	{
		return new Object[][] {
			
			{
				"hok74554@gmail.com","14102003"
			},
			

		};
		
	};
	@AfterTest
	public void Close() {
		driver.close();
	}
}