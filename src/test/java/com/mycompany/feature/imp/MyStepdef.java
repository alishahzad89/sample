package com.mycompany.feature.imp;

import org.testng.Reporter;

import com.mycompany.core.testdata.ScenarioTestData;
import com.mycompany.test.imp.TestCaseImp1;
import com.mycompany.test.imp.TestCaseImp2;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyStepdef {

	@Given("I want to write a \"([^\\\"]*)\" with precondition(\\d+)")
	public void i_want_to_write_a_step_with_precondition1(String str) throws Exception {
		
		System.out.println("sys - I want to write a step with precondition " +str );
		
//		TestCaseImp1 TestCaseImp1 = new TestCaseImp1();
//		
//		TestCaseImp1.openGooglePage();

		// LocatorFactory.getInstance(TestCaseImp1.class).btnSearch.click();

	}

	@Given("I want to write a step with precondition2")
	public void i_want_to_write_a_step_with_precondition2() throws Exception {
		System.out.println("sys - I want to write a step with precondition");
		TestCaseImp2 TestCaseImp2 = new TestCaseImp2();
		TestCaseImp2.openGooglePage();

	}

	@Given("I want to write a step with precondition3")
	public void i_want_to_write_a_step_with_precondition3() throws Exception {
		System.out.println("sys - I want to write a step with precondition");
		Reporter.log("this is testng log");
	}

	@Given("I want to write a step with precondition4")
	public void i_want_to_write_a_step_with_precondition4() throws Exception {
		System.out.println("sys - I want to write a step with precondition");
		Reporter.log("this is testng log");
	}

	@Given("^This is the test method(\\d+)$")
	public void this_is_the_test_method(int arg1) throws Exception {

		System.out.println("This is the test method");
		Reporter.log("this is testng log");
	}
	
//	@Given("^I want to write a (.*) with precondition1$")
//	public void i_want_to_write_a_with_precondition1(String arg1) throws Exception {
//		System.out.println("first step balance "+ScenarioTestData.getMap().get(arg1.replace("<","").replace(">", "")));
//	}
//
//	@Then("^check below Numbers$")
//	public void check_below_Numbers(DataTable arg1) throws Exception {
//		System.out.println("DataTable "+arg1);
//	}
//	
//	@Given("^I want to write a (.*) with precondition2$")
//	public void i_want_to_write_a_with_precondition2(String arg1,DataTable table) throws Exception {
//		
//		System.out.println("first step Account "+ScenarioTestData.getMap().get(arg1.replace("<","").replace(">", "")));
//	    System.out.println(table);
//	}

	

}
