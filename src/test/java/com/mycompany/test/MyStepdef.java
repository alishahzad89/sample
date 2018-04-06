package com.mycompany.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

public class MyStepdef {
	
	 @Given("I want to write a step with precondition")
	    public void i_want_to_write_a_step_with_precondition() throws Exception {
	       System.out.println("this is my test");
	       System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajiv.sharma\\Desktop\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://github.com/");
			driver.close();
	    }
	 
	 @Given("^This is the test method(\\d+)$")
	 public void this_is_the_test_method(int arg1) throws Exception {
		 
		 System.out.println("this is my test");
	 }
	 
	 

}
