package Base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Utils.CapturingScreenshot;

public class testListeners extends CapturingScreenshot implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Method name is - "+result.getName());
		System. out . println("Test starting");
	}
	public void onTestSuccess (ITestResult result) {
		Reporter.log ("Status of execution is - " +result. getStatus());
	}


	public void onTestFailure (ITestResult result) {
		System.out.println("Test failed - screenshot captured");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
