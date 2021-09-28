package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//".//Features//FixtureToday.feature", ".//Features//Sports.feature",

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {".//Features//Login.feature", ".//Features//LoginScenario2.feature", ".//Features//LoginScenario3.feature",
                        ".//Features//LoginScenario4.feature"},
                glue = "stepDefinitions",
                dryRun = false,
                plugin = {"pretty", "html:target/html-report/cucumber-html-reports.html"}
        )

public class TestRunner {
}
