/**
 * Autor: joseph.nassar@msg.group
 * Common Hooks Class
 */
package de.wissentransfer.tobias.cucumber.steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import de.wissentransfer.tobias.utilities.SpringKonfiguration;

import static de.wissentransfer.tobias.utilities.Logger.logError;

public class CommonHooks {

    private static final Logger LOGGER =  LoggerFactory.getLogger(CommonHooks.class.getName());

    @Autowired
    public SpringKonfiguration springConfiguration;

    /**
     * Screenshot Aufnahme im Fehlerfall
     * @param scenario
     * @throws Exception
     */
    @After
    public void embedScreenshot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) springConfiguration.webDriver() ).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.embed(screenshot, "image/png");
                scenario.write(testName);
                logError("Scenario Failed: "
                        + "  / "+  testName
                        + " -line: "
                        +scenario.getLine());
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();}
        }
    }
}
