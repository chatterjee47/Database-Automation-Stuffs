package Tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RNDWebtable {
    WebDriver driver ;
    

 @BeforeTest
 public void setup() throws Exception {
	 System.setProperty("webdriver.chrome.driver", "E:\\DatabaseAutomation\\ProjectOne\\DatabaseTesting\\drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
 }

 @AfterTest
 public void tearDown() throws Exception {
  driver.quit();
 }

 @Test
 public void Handle_Dynamic_Webtable() {
	 
	 WebElement element = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr[2]/td[3]"));
	 System.out.println("Data display as : " + element.getText() );
	 
	 
	 
	 
 
   List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr"));
	   int rows_count = rows.size();
	   System.out.println("Number of cells In Row " + rows_count);
	  
	   for(int i = 0;i<=rows.size();i++) 
	   {
		   System.out.println("Number of values In Row " + rows.get(i).getText());  
	   }
	  

   
   
   
 }
}