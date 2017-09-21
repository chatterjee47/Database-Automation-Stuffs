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

public class WebTable {
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
 
 
  //To locate rows of table.
  List<WebElement> rows_table = driver.findElements(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody/tr"));
  //To calculate no of rows In table.
  int rows_count = rows_table.size();
  System.out.println("Number of rows:" + rows_count);
  
  for(int i=0;i<=rows_table.size();i++) 
  {
	  System.out.println(rows_table.get(i).getText());  
  }
  
  
  //Loop will execute till the last row of table.
  for (int i=0; i<rows_count; i++){
   //To locate columns(cells) of that specific row.
   List<WebElement> Columns_row = rows_table.get(i).findElements(By.tagName("td"));
   System.out.println("Columns_row");
   //To calculate no of columns(cells) In that specific row.
   int columns_count = Columns_row.size();
   System.out.println("Number of cells In Row "+i+" are "+columns_count);
   
   //Loop will execute till the last cell of that specific row.
   for (int j=0; j<columns_count; j++){
    //To retrieve text from that specific cell.
    String celtext = Columns_row.get(j).getText();
    System.out.println("celtext");
    System.out.println("Cell Value Of row number "+i+" and column number "+j+" Is "+celtext);
   }
   System.out.println("--------------------------------------------------");
  }  
 }
}