package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags= "@APIAutomation"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}