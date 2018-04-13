package com.mycompany.test.imp;

import org.testng.annotations.Test;

import com.mycompany.core.BaseDriver;

public class TestCase2 extends BaseDriver{

	@Test
	public void testUIDriver() {
		System.out.println("javacodegeeks");
		BaseDriver.getDriver().get("https://examples.javacodegeeks.com/");
		
	}

	@Test
	public void testUIDriver1() {
		System.out.println("synechron");
		BaseDriver.getDriver().get("https://eag.synechron.com");
		
	}

}
