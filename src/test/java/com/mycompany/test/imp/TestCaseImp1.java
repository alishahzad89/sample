package com.mycompany.test.imp;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mycompany.core.BaseDriver;
import com.mycompany.core.locator.HomePageLoc;
import com.mycompany.core.locator.LocatorFactory;



public class TestCaseImp1 {
	
	@Test
	public void openGooglePage(){
		Reporter.log("this is testng log");
		BaseDriver.getDriver().get("https://www.google.co.in/");
		
		LocatorFactory.getInstance(HomePageLoc.class).inputSearch.sendKeys("selenium");
	}
		
}
