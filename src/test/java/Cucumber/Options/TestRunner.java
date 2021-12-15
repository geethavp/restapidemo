package Cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions
        (
                features = "src/test/java/Features",
                glue = "StepDefinitions",
                stepNotifications = true,
                plugin = {
                        "pretty",
                        "json:target/jsonReports/cucumber-report.json"
                        }
                //tags = "@DeleteAssociate"

        )

public class TestRunner {
}

