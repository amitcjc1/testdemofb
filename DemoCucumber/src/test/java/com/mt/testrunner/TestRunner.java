package com.mt.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumberreport","html:target/htmlreport"},
features = {"src//test//resources//FeatureCollections"},
glue = {"com.mt.steps"},
tags = {"@SmokeTest"})
public class TestRunner {

}
