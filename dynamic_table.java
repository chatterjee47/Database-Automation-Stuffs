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

public class dynamic_table {
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
 
  //To locate table.
  WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
  //To locate rows of table.
  List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
  //To calculate no of rows In table.
  int rows_count = rows_table.size();
  
 
   for (int i=0; i<rows_count; i++){
   List<WebElement> Columns_row = rows_table.get(i).findElements(By.tagName("td"));
   int columns_count = Columns_row.size();
   System.out.println("Number of cells In Row "+i+" are "+columns_count);
   

   for (int j=0; j<columns_count; j++){
   String celtext = Columns_row.get(j).getText();
   System.out.println("Cell Value Of row number "+i+" and column number "+j+" Is "+celtext);
   }
   System.out.println("--------------------------------------------------");
  }  
 }
}