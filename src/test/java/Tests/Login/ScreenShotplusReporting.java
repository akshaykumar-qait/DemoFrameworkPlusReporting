package Tests.Login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Readers.OptionReader;
import utility.InitWebdriver;

public class ScreenShotplusReporting implements ITestListener {
	WebDriver driver = null;
	String filePath = "Screenshots/";

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		takeScreenShot(methodName);
		
		double timetaken = (result.getEndMillis()-result.getStartMillis())/1000;

		try {
			new OptionReader().writeit(result.getName()+"<<<<<<<<<<", "FAILED>>>>>>>>>   "+"Time taken :"+timetaken+" sec");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void takeScreenShot(String methodName) {
		// get the driver
		driver = InitWebdriver.getDriver();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFinish(ITestContext context) {
		try {
			new OptionReader().writeit(context.getName().toString(),
					"======================Finished=========================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestStart(ITestResult result) {

		try {
			new OptionReader().writeit(result.getName().toString(),
					"======================Started=========================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		double timetaken = (result.getEndMillis()-result.getStartMillis())/1000;

		try {
			new OptionReader().writeit(result.getName()+"  >>>>>>>>>>>>>>", "Passed<<<<<<<<<<<<<<<      "+"Time taken :"+timetaken+" sec");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		double timetaken = (result.getEndMillis()-result.getStartMillis())/1000;

		try {
			new OptionReader().writeit(result.getName()+"  >>>>>>>>>>>>>>", "Skipped<<<<<<<<<<<<<<<      "+"Time taken :"+timetaken +" sec");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext result) {
		try {
			new OptionReader().writeit("Suite Started execution at",result.getStartDate().toGMTString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
}