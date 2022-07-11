package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "json:target/MyReports/report.json", "junit:target/MyReports/report.xml"},
        monochrome = true,
        publish = true)

public class Runner {
}
