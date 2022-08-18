package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
  static ExtentReports extent;
  
 
  public static ExtentReports getReportObject() {
	  String path = System.getProperty("user.dir")+"//Reports//index.html";
	  ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	  reporter.config().setDocumentTitle("Test Results");
	  
		extent = new ExtentReports();
	
	  extent.attachReporter(reporter);
	  return extent;
  }
}
