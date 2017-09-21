package LearnPrograming;
	import java.util.List;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
	public class IndentifyDataFromColumn {
		
		static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\DatabaseAutomation\\ProjectOne\\DatabaseTesting\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://money.rediff.com/gainers/bsc/dailygroupa?");
		
		Thread.sleep(500);
		//No.of Columns
        List <WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        Thread.sleep(500);
        
        //No.of rows 
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr")); 
        System.out.println("No of rows are : " + rows.size());
        Thread.sleep(500);
        
        
        for(int i=0;i<=rows.size();i++) 
        	
        {
        	
        //	System.out.println("Display name : " + rows.get(i).getText());
        	rows.get(i).click();
        }
        
        Thread.sleep(10000);
		driver.close();
	}
}