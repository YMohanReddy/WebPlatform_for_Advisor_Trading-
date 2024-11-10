package Utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseTest;

public class CapturingScreenshot extends BaseTest{

	public static String getScreenshot(){

//		System.out.println("Listeners file executed");
//		Date currentdate = new Date(0);
//		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		String screenshotfilename = System.currentTimeMillis()+"";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"/screenshots/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir")+"/screenshots/screenshot.png";
	}

}
