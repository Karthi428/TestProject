package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Loginfeature.feature",
glue= {"stepdefinitions"},
monochrome = true,
dryRun = false,
plugin = {"pretty","html:target/reports.html","pretty","json:target/reports.json"})
public class TestRunner 
{
	
}

