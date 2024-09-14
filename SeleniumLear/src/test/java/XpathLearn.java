import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathLearn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//	1.	syntax for starts-with() method is given below:
//			Syntax:
//			      XPath: //tagname[starts-with(@attribute, 'value')]
		
		driver.get("https://www.saucedemo.com/");
		WebElement userId = driver.findElement(By.xpath("//input[starts-with(@name, 'user')]"));
		userId.sendKeys("standard_user");
		
//	2.	Contains() method has the following general form which is given below:
//
//			Syntax:
//			      XPath: //tagname[contains(@attribute, 'value')]
		WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'pass')]"));
		password.sendKeys("secret_sauce");
		password.submit();
		
//	3.  And and or operator in xpath	
		driver.findElement(By.xpath("//button[text()= 'Add to cart']")).click();
		
		driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light' and @class = 'btn btn_primary btn_small btn_inventory ']")).click();
		
		driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light' or @class = 'btn btn_primary btn_small btn_inventory ']")).click();
		
		
//  4.  xpath using axis methods self, parent and child
		driver.navigate().to("https://demoqa.com/select-menu");
		driver.findElement(By.xpath("//select[@id='oldSelectMenu']//self::select")).click();

		driver.findElement(By.xpath("//select[@id='oldSelectMenu']//parent::div")).click();
		
		driver.findElement(By.xpath("//select[@id='oldSelectMenu']//child::option")).click();
		
		
		
	}

}
