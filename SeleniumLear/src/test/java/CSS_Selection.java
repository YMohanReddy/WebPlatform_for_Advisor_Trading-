import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSS_Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		//	1.	CSS selector with id attribute
		driver.findElement(By.cssSelector("#user-name")).sendKeys("Mohan");
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");


		//	2.	CSS selector with class attribute
		driver.findElement(By.cssSelector("input.input_error form_input")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[class='input_error form_input']")).sendKeys("standard_user");

		//	3.	Advanced CSS selector

		driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']")).sendKeys("Mohan");
		driver.findElement(By.cssSelector("input#password[placeholder='Password']")).sendKeys("Mohan@123");

		//	4.	CSS selector - Sub string
		//Prefix
		driver.findElement(By.cssSelector("input[name ^= 'user-n']")).sendKeys("standard_user");
		//Sufix
		driver.findElement(By.cssSelector("input[name $= 'r-name']")).sendKeys("standard_user");
		//Sub string
		driver.findElement(By.cssSelector("input[name *= 'er-na']")).sendKeys("standard_user");

		//		5. Child Element => This will select direct child (>)
		driver.findElement(By.cssSelector("div[class='form_group']>input[id^='user']")).sendKeys("standard_user");

		//		Child and sub child selector -> use space ( ) -> if any sub child is available under child that also gets selected
		driver.findElement(By.cssSelector("div[class='form_group'] input[id^='user']")).sendKeys("standard_user");

//		6. First , last and nth child
		driver.findElement(By.cssSelector("div[class='form_group']:first-child")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("div[class='form_group']:last-child")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("div[class='form_group']:nth-child(1)")).sendKeys("standard_user");
		
//		7. First, last and nth sibling of type element
		driver.findElement(By.cssSelector("div[class='form_group']>input:first-of-type")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("div[class='form_group']>input:last-of-type")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("div[class='form_group']>input:nth-of-type(1)")).sendKeys("standard_user");
		

	}

}
