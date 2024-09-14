import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {


		//		implicit wait
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a"));

		Actions action = new Actions (driver);
		action.moveToElement(element) .perform();
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/div[2]/div[1]/div[2]/ul/li[1]/a")).click();


		//		Explicit wait
		//		WebDriverManager.chromedriver().setup();
		//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).perform();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='mainContent']/div[1]/ul/li[6]/div[2]/div[1]/div[2]/ul/li[1]/a"))).click();


//		Fluent wait
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout (Duration.ofSeconds(10))
				. pollingEvery(Duration. ofSeconds(2))
				.withMessage("RCV Academy: This is custom message")
				.ignoring(NoSuchElementException.class);
		wait1. until(ExpectedConditions. presenceOfElementLocated(
				By.xpath("//*[@id='mainContent' ]/div[1]/ul/li[6]/div[2]/div[1]/div[2]/ul/li[1]/a/jhfgjhf"))).click();



	}

}

