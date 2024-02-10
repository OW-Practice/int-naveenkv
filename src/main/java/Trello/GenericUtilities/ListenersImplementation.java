package Trello.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "====Test Execution Started=====");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"====PASS====");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"====FAIL====");
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String screenShotName = methodName+"-"+ new JavaUtilities().getSystemDateInFormat();
		
		try {
			String path=wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"====SKIP====");
		test.log(Status.INFO, result.getThrowable());
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("====Suite Execution Started=====");
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtilities().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("EzyBill Execution Report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Execution Report");
		
		report =new ExtentReports();
		report.attachReporter(htmlreporter);
		
		String URL = null;
		try {
			URL = pUtil.readDataFromPropertyFile("url");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.setSystemInfo("Base URL", URL);
		
		String BROWSER = null;
		try {
			URL = pUtil.readDataFromPropertyFile("browser");
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.setSystemInfo("Base Browser", BROWSER);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Muzammil");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("====Suite Execution Ended=====");
		
		report.flush();
	}
		
		
}
