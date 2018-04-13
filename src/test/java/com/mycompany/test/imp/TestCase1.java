package com.mycompany.test.imp;

import org.testng.annotations.Test;

import com.mycompany.core.*;


public class TestCase1 {

	
	@Test
	public void testUIDriver() {
		System.out.println("stackoverflow");
		
		BaseDriver.getDriver().get("https://stackoverflow.com");
		
		
	}

	@Test
	public void testUIDriver1() {
		System.out.println("google");
		BaseDriver.getDriver().get("https://www.google.co.in/");
		
	}

	
	
}
