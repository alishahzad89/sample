package com.mycompany.core;

import org.openqa.selenium.WebDriver;

public class BaseDriver {

	public static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver) {
		threadLocalWebDriver.set(driver);
	}

	public static WebDriver getDriver() {
		System.out.println("in getDriver");
		return threadLocalWebDriver.get();

	}

	
}
