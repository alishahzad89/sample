package com.mycompany.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class TestNGListner implements ISuiteListener, IInvokedMethodListener, ITestListener {

	public static boolean isGridRunning = false;

	
	public void onStart(ISuite suite) {
		System.out.println("This is onStart Suite");

		GridHubNodeConfig.startHub();
		GridHubNodeConfig.startNode();

	}

	public void onFinish(ISuite suite) {
		try {
			File reportOutputDirectory = new File("target");
			List<String> jsonFiles = new ArrayList<String>();
			jsonFiles.add("target/cukjson/cucumber2.json");

			String buildNumber = "1";
			String projectName = "cucumberProject";
			boolean runWithJenkins = false;
			boolean parallelTesting = false;

			Configuration configuration = new Configuration(reportOutputDirectory, projectName);
			// optional configuration
			configuration.setParallelTesting(parallelTesting);
			configuration.setRunWithJenkins(runWithJenkins);
			configuration.setBuildNumber(buildNumber);
			// addidtional metadata presented on main page
			configuration.addClassifications("Platform", "Windows");
			configuration.addClassifications("Browser", "Firefox");
			configuration.addClassifications("Branch", "release/1.0");

			// optionally add metadata presented on main page via properties file
//			List<String> classificationFiles = new ArrayList<>();
//			classificationFiles.add("properties-1.properties");
//			classificationFiles.add("properties-2.properties");
//			configuration.addClassificationFiles(classificationFiles);

			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
			reportBuilder.generateReports();
		} catch (Exception e) {

		}

	}

	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {


	}

	
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart " + result.getName());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajiv.sharma\\Desktop\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://172.20.202.82:4444/wd/hub"), DesiredCapabilities.chrome());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BaseDriver.threadLocalWebDriver.set(driver);

	}

	
	public void onTestSuccess(ITestResult result) {
		BaseDriver.threadLocalWebDriver.get().close();

	}

	
	public void onTestFailure(ITestResult result) {
		BaseDriver.threadLocalWebDriver.get().close();

	}

	
	public void onTestSkipped(ITestResult result) {
//		BaseDriver.threadLocalWebDriver.get().close();

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext context) {
		System.out.println("onStart ");

	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
