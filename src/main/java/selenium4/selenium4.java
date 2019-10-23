package selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Log;

public class selenium4 {
	public static WebDriver driver;
	@Test
	public void m() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		String title=driver.getTitle();
		System.out.println(title);
		BasicConfigurator.configure();
//		PropertyConfigurator.configure("\\log4j.properties");
//		Logger log=Logger.getLogger(log4j.class);

		Log.info("pass");
		Log.info("good");
		
//		Assert.assertEquals(title, "makemytrip");
	WebElement element=	driver.findElement(By.xpath("//li[text()='Round Trip']"));
	File src=((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:/HaudAPI/selenium4/target/screenshot.png"));
	
		
		
		
	// open new blank tab
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.makemytrip.com/" );
	
//	open new new window
	driver.switchTo().newWindow(WindowType.WINDOW); 
	driver.getTitle();
	driver.close();
	}		
}
