/**
 * Refactoring: joseph.nassar@msg.group
 * CucumberContextConfiguration Class
 */
package de.wissentransfer.tobias.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class CucumberContextConfiguration {

   private static final Logger LOG = LoggerFactory.getLogger(CucumberContextConfiguration.class.getName());
    protected static Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        scenario = scenario;
    }
    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}
