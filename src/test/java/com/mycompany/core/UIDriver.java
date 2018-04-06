package com.mycompany.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UIDriver {
	
	public static ThreadLocal<WebDriver> threadLocalWebDriver=new ThreadLocal<WebDriver>();

	@Test(priority=1)
	public void UIDriverTest() throws MalformedURLException {
		System.out.println("in firsUIDriver");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajiv.sharma\\Desktop\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new RemoteWebDriver(new URL("http://172.20.202.82:4444/wd/hub"),
				new DesiredCapabilities(readCapabilities()));
		threadLocalWebDriver.set(driver);
	}
	
	
	public WebDriver getDriver() {
		System.out.println("in secondDriver");
		return threadLocalWebDriver.get();
		
	}
	
	@Test(priority=2)
	public void testUIDriver() {
		getDriver().get("https://stackoverflow.com");
	}

	public Map<String, Object> readCapabilities() {

		ObjectMapper mapper = new ObjectMapper();
		File file = new File("src/test/resources/config/ChromeConfig.json");
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		Map<String, Object> map = new HashMap<String, Object>();
		// convert JSON string to Map
		try {
			map = mapper.readValue(file, new TypeReference<Map<String, Object>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(map);
		return map;

	}

	public void allDrivers() {
		new FirefoxDriver();
		new ChromeDriver();
		new InternetExplorerDriver();
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajiv.sharma\\Desktop\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");

		String[] args1 = new String[] {};
		try {
			GridLauncherV3.main(args1);
			System.out.println("server started");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
