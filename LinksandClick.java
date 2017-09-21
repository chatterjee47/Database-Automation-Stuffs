package LearnPrograming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksandClick {

	private static WebDriver driver;
	public static void main(String rags[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\DatabaseAutomation\\ProjectOne\\DatabaseTesting\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.navigate().to("http://www.phptravels.net/");
		
		Thread.sleep(10000);
		
		List <WebElement> alllinks = driver.findElements(By.tagName("a"));

	    for(int i=0;i<alllinks.size();i++)
	        System.out.println(alllinks.get(i).getText());

	    for(int i=0;i<alllinks.size();i++){
	        alllinks.get(i).click();
		
		Thread.sleep(10000);
		driver.close();
	}

}
}
