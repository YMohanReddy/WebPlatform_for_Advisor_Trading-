import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotAndDate {

	public static void main(String[] args) throws InterruptedException {


		Date currentdate = new Date(0);
		System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);


		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.ebay.com.au/"); 
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\ybhas\\eclipse-workspace\\SeleniumLear\\target//"+screenshotfilename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}

