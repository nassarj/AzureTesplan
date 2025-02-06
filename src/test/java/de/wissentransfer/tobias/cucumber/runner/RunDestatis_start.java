package de.wissentransfer.tobias.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:feature/Destatis_start-v001.feature",
        glue = "de.wissentransfer.tobias.cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber_Destatis_start-v001.json",
                "junit:target/cucumber_Destatis_start-v001.xml"},
        monochrome = true,
        tags = {"@RegressionTest"  }
)
public class RunDestatis_start {
}
