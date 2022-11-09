package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/features/Activity4.feature",
glue = "stepDefinitions",
monochrome = true,
publish = true,
tags = "@Sample")
public class ActivitiesRunner extends AbstractTestNGCucumberTests{

}

