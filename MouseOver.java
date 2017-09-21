package LearnPrograming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
	
	public static void main(String[] args) throws InterruptedException{

		   System.setProperty("webdriver.chrome.driver", "E:\\DatabaseAutomation\\ProjectOne\\DatabaseTesting\\drivers\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("http://www.google.com");
		  
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		     // Go to URL
		     driver.get("http://www.myntra.com/");
		  
		     // Maximize Window
		     driver.manage().window().maximize();
		     Thread.sleep(3000L);
		     // Mouse Over On " Men link " 
		     Actions a1 = new Actions(driver);
		     WebElement s1 = driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]"));
		     WebElement s2 = driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[2]/div[2]/div[2]/a[2]"));
		    
		     a1.moveToElement(s1).moveToElement(s2).click().build().perform();
		     Thread.sleep(3000L);
		  
		     //closing current driver window 
		     driver.close();   
		    }
		


}
