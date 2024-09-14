import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver() .setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage() .window() .maximize();
		
//		WebElement ddown = driver.findElement(By.name("employees_c"));
//		Select select = new Select(ddown);
//		select.selectByValue("level1");
//		select.selectByVisibleText("51 - 100 employees");
//		select.selectByIndex(5);

		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement multiSelectDD = driver.findElement(By.cssSelector("#ide"));
		Select select = new Select(multiSelectDD);
		select.selectByValue("nb");
		select.selectByIndex(0);
		select.selectByVisibleText("Visual Studio");
		List <WebElement> selectedOptions = select.getAllSelectedOptions();
		
		System.out.println(selectedOptions.size());
		
		select.deselectByIndex(0);
		select.deselectByValue("nb");
		select.deselectByVisibleText("Visual Studio");
		

		List <WebElement> selectedOptions1 = select.getAllSelectedOptions();
		
		System.out.println(selectedOptions1.size());
		
		select.selectByValue("nb");
		select.selectByIndex(0);
		select.selectByVisibleText("Visual Studio");
		
		System.out.println(select.getFirstSelectedOption());
		
		select.deselectAll();
	}

}
