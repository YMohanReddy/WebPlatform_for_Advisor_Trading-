import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org. openqa. selenium. support. locators. RelativeLocator. with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		WebElement userId = driver.findElement(By.id("user-name"));
		userId.sendKeys("Mohan");
		
		// Relative locators
		WebElement password_relative = userId.findElement(RelativeLocator.with(By.tagName("input")).below(userId));
		WebElement password_relative1 = driver.findElement(with(By. tagName("input")).below(userId));

//		WebElement password_relative2 = driver.findElement(withTagName("input")).below(userId);
		password_relative1.sendKeys("123@moh");

		WebElement password = driver.findElement(By.id("password"));
		WebElement userId_relative = userId.findElement(RelativeLocator.with(By.tagName("input")).above(password));
		userId_relative.sendKeys("Reddy");
		
		userId.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(password));
		userId.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(password));
		
		
	}

}
