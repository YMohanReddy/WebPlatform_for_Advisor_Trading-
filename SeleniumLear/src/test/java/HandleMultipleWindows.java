import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/au/");
		driver. findElement(By.xpath("//*[@id=\"1682325589592_4ma\"]/div[1]/article/div[2]/div/pbc-button[1]/a"));
		Thread. sleep(4000);
		Set<String> windowhandles = driver.getWindowHandles();
		System.out. println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out . println (parentwindow);
		String childwindow = iterator.next();
		System.out.println(childwindow);
		driver.switchTo().window(childwindow);
		driver.findElement(By.name("UserFirstName")) . sendKeys("RCV");
		driver.findElement(By.name("UserLastName")) . sendKeys ("Academy");
		driver.switchTo().window(parentwindow);




	}

}

