package TestRunner;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/Login.feature",glue={"StepDefinition"},
dryRun =false,
monochrome = false,
/*plugin = {"pretty","html:target/CucumberReport/Report1.html"}
		)*/
plugin = { "pretty", "json:target/CucumberReport/Cucumber.json",
		"html:target/CucumberReport/Report1.html"})

public class Runner {

}
