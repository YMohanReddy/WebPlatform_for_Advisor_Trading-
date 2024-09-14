package Utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseTest;

public class CapturingScreenshot extends BaseTest{

	public void getScreenshot() throws IOException {

		System.out.println("Listeners file executed");
		Date currentdate = new Date(0);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\ybhas\\eclipse-workspace\\Web_Platform_For_Advisor_Trading\\screenshots//"+screenshotfilename+".png"));
	}

}
