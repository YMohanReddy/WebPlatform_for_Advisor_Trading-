package Hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
	public static void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void explicitlyWaitFor(WebDriver driver, WebElement element, int time) {
		// explicit wait condition
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		// presenceOfElementLocated condition
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement findElementById(WebDriver driver, String elementID) {
		WebElement element = driver.findElement(By.id(elementID));
		return element;
	}
}
