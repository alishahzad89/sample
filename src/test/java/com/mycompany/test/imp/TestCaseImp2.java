package com.mycompany.test.imp;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mycompany.core.BaseDriver;
import com.mycompany.core.locator.LocatorFactory;
import com.mycompany.core.locator.LoginPageLoc;

public class TestCaseImp2{

	@Test
	public void openGooglePage(){
		Reporter.log("this is testng log");
		BaseDriver.getDriver().get("https://www.google.co.in/");
		LocatorFactory.getInstance(LoginPageLoc.class).inputSearch.sendKeys("selenium");
	}
}
