package resources;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import firstPackage.Base;
public class Listeners extends Base implements ITestListener{

	
	ExtentTest test;
	ExtentReports extent =ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/*
	 * This threadlocal class will keep test object thread safe and this test object
	 * is of ExtentTest class hence we are passing the class(ExtentTest) here
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		/*
		 * After creating test object you need to set this to extentTest i.e. object of
		 * thread local class that means you are sending your test object(For every test
		 * case) in the pool of thread local. So after setting test object to extentTest
		 * we will use extentTest.get() everywhere instead of test obj as extentTest will automatically provide the 
		 * right test object.
		 */
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String methodName= result.getMethod().getMethodName();
		//To get access of variable of any class using testng listener
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			
		}  
		try {
			String ssPath = getScreenShotPath(methodName,driver);
			extentTest.get().addScreenCaptureFromPath(ssPath, methodName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
