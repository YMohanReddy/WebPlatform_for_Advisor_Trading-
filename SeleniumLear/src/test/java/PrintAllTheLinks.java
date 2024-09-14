import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllTheLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.sugarcrm.com/au/request-demo");
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for (WebElement e : allLinks) {
			System.out.println(e.getAttribute("href"));
			System.out.println(e.getAttribute("value"));
			System.out.println(e.getText());
		}
		
	}

}
