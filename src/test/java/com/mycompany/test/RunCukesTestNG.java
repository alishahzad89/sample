package com.mycompany.test;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.ScenarioImpl;
import gherkin.pickles.PickleTag;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//	@RunWith(Cucumber.class)
//	@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},features = "src/test/Test.feature")
//	public class RunCukesJunit {
//	}
//	

@CucumberOptions(features = "src", plugin = "json:target/cucumber1.json",
glue={"com.mycompany.test","MyStepdef"},
//dryRun = true,
monochrome = true
)
public class RunCukesTestNG {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    
//    @BeforeMethod
//    public void scenarioTagName(Scenario scenario) {
//   	 for(String tag : scenario.getSourceTagNames()){
//            System.out.print("Tag: " + tag);
//        }
//    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleEventWrapper pickleEventWrapper,CucumberFeatureWrapper cucumberFeature) {
    	System.out.println(pickleEventWrapper.getPickleEvent().uri);
    	for(PickleTag tag:pickleEventWrapper.getPickleEvent().pickle.getTags()) {
    		System.out.println(tag.getName());
    	}
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
	
