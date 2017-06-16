package com.liferay.jarvis;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "features"
	,format = {"pretty", "html:target/cucumber"} 

)
public class TestRunner {

}