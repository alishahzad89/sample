package com.mycompany.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycompany.core.testdata.ScenarioTestData;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleTag;


//	@RunWith(Cucumber.class)
//	@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},features = "src/test/Test.feature")
//	public class RunCukesJunit {
//	}
//	

//@CucumberOptions(features = "src/test/resources/features/Feature1.feature", 
//plugin = { "pretty", "html:target/cucumber-reports","json:target/cukjson/cucumber2.json" },
//glue={"com.mycompany.feature.imp","MyStepdef"},
////dryRun = true,
//monochrome = true
//)


public class RunCukesTestNG {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ScenarioTestData dat=new ScenarioTestData();
        dat.addDataToTable();
    }
    
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleEventWrapper pickleEventWrapper,CucumberFeatureWrapper cucumberFeature) {
    	System.out.println("feature uri "+pickleEventWrapper.getPickleEvent().uri);
    	System.out.println("feature title "+pickleEventWrapper.getPickleEvent().pickle.getName());
    	
    	   	
    	for(PickleTag tag:pickleEventWrapper.getPickleEvent().pickle.getTags()) {
    		System.out.println("Tags Name " +tag.getName());
    	}
    	
    	for(PickleStep tag:pickleEventWrapper.getPickleEvent().pickle.getSteps()) {
    		System.out.println("Steps Name "+tag.getText());
    	}
    	
        try {
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
