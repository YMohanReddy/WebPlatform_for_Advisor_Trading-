import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit. asp?filename=tryjsref_alert");
		
		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		
		//Print the title of the page
		String script = "return document.title;";
		String title = (String) jsexec. executeScript(script);
		System.out.println(title);
		
		//CLick button
		driver.switchTo() .frame("iframeResult");
		jsexec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert(). accept();

		//highlight button
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		jsexec.executeScript("arguments[0]. style. border='5px solid green'", button);
		//Scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement certifiedbutton = driver.findElement(By.xpath("//*[@id=\"certsection\"]/p/a"));
		jsexec. executeScript("arguments[0]. scrollIntoView(true);", certifiedbutton);



	}

}

