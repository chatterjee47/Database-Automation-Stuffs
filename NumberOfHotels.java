package LearnPrograming;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfHotels {

	private static WebDriver driver;
	public static void main(String rags[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\DatabaseAutomation\\ProjectOne\\DatabaseTesting\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.navigate().to("http://www.phptravels.net/");
		
		Thread.sleep(10000);
		
		List<WebElement> imagesList = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of images are " + imagesList.size());
		
		for (int i = 0;i<= imagesList.size();i++) 
		{
		//	System.out.println("Name of images :" +imagesList.get(i).getAttribute("href"));
			System.out.println("Name of links :" +imagesList.get(i).getAttribute("href"));
			System.out.println("Name of images :" +imagesList.get(i).getText());
		//	imagesList.get(i).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(10000);
		driver.close();
	}

}
