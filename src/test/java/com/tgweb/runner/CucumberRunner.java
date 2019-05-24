package com.tgweb.runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests; 

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = {"com.tgweb.stepDefinition"}
	//	tags = "@SmokeTest"
	//	monochrome = true, //display the console output in a proper readable format
	//	strict = true, //it will check if any step is not defined in step definition file
	//	dryRun = true //to check the mapping is proper between feature file and step def file
		//format = "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/report.html"
		//format ="com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		)
@Test
public class CucumberRunner extends AbstractTestNGCucumberTests  {

}
