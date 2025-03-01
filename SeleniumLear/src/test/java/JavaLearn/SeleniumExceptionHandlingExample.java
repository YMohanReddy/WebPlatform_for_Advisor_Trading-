package JavaLearn;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;

public class SeleniumExceptionHandlingExample {

    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a webpage
            driver.get("https://www.example.com");

            // Handle NoSuchElementException (element not found)
            try {
                WebElement element = driver.findElement(By.id("nonExistentElement"));
                element.click();
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
            }

            // Handle TimeoutException (element not loaded in time)
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delayedElement")));
                element.click();
            } catch (TimeoutException e) {
                System.out.println("Timeout while waiting for element: " + e.getMessage());
            }

            // Handle StaleElementReferenceException (element no longer attached to the DOM)
            try {
                WebElement element = driver.findElement(By.id("staleElement"));
                element.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Element is stale, trying to re-find it: " + e.getMessage());
                WebElement element = driver.findElement(By.id("staleElement"));
                element.click();
            }

            // Handle ElementClickInterceptedException (element blocked by overlay)
            try {
                WebElement button = driver.findElement(By.id("button"));
                button.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element is blocked, using JavaScript to click: " + e.getMessage());
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.id("button")));
            }

            // Handle InvalidElementStateException (unable to interact with the element)
            try {
                WebElement inputField = driver.findElement(By.id("disabledInput"));
                inputField.sendKeys("Test");
            } catch (InvalidElementStateException e) {
                System.out.println("Element is not in a valid state for interaction: " + e.getMessage());
            }

            // Handle NoAlertPresentException (alert not present)
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                System.out.println("No alert present: " + e.getMessage());
            }

            // Handle FileNotFoundException (file upload scenario)
            try {
                File file = new File("C:\\path\\to\\nonexistentfile.txt");
                if (file.exists()) {
                    driver.findElement(By.id("fileUpload")).sendKeys(file.getAbsolutePath());
                } else {
                    throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File upload error: " + e.getMessage());
            }

            // Handle WebDriverException (generic WebDriver issues)
            try {
                WebElement element = driver.findElement(By.id("element"));
                Actions action = new Actions(driver);
                action.moveToElement(element).click().perform();
            } catch (WebDriverException e) {
                System.out.println("WebDriver exception occurred: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the driver after the test is complete
            driver.quit();
        }
    }
}

