package com.cigna.runner;

import org.testng.annotations.*;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.TestNGCucumberRunner;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/test/resources/features2",
        glue = {"com.talentech.stepdefinitions"},
        monochrome= true,
        //tags = {"~@Ignore"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner { 
	
	private TestNGCucumberRunner testNGCucumberRunner;
	 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features2")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    @DataProvider
    public Object[][] features2() {
        return testNGCucumberRunner.provideFeatures();
    }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
}
}