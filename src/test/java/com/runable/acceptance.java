package com.runable;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="com.steps",
		tags="@studentform",
		plugin= {"pretty",
				"json:target/cucumber.json",
				"html:target/cucumber-html-reports/index.html"},
		monochrome = true
		)
public class acceptance {

}
