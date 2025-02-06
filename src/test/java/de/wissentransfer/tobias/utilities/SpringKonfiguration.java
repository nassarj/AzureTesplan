package de.wissentransfer.tobias.utilities;

//import javax.sql.DataSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("de.wissentransfer.tobias.cucumber.pages")
public class SpringKonfiguration {

    private  String  GENESIS_BROWSER = TestContext.getStageprops().getProperty("browser");
    //private String  GENESIS_BROWSER = TestContext.getCurrentConfigsProfile().getBrowserName();

    //int WEB_DRIVER_TIMEOUT = Integer.parseInt(TestContext.getStageprops().getProperty("oeaws.maximale.wartezeit.in.sekunden"));
//    @Autowired
//    private DataSource dataSource;

    /**
     * webDriver
     * @return WebDriver
     */
    @Bean
    public WebDriver webDriver() {
        WebDriver webDriver=null;
        //logInfo("SpringConfiguration/GENESIS_BROWSER: "+GENESIS_BROWSER);
        switch (GENESIS_BROWSER) {
            case "firefox":
                //logInfo("Browser ist Firefox");
                webDriver= FirefoxDriverSingleton.getInstance().getDriver();
                break;
//            case "chrome" :
//                //logInfo("Browser ist Chrome");
//                webDriver= ChromeDriverSingleton.getInstance().getDriver();
//                break;
            default:
                //logInfo("bitte Browser angeben, es wird Firefox als standard Browser gesetzt");
                return FirefoxDriverSingleton.getInstance().getDriver();
        }
        return webDriver;
    }

    /**
     * WebDriverWait
     * @return WebDriverWait
     */
//    @Bean
//    public WebDriverWait webDriverWait() {
//        return new WebDriverWait(webDriver(), WEB_DRIVER_TIMEOUT);
//    }

    /**
     * JdbcTemplate
     * @return JdbcTemplate
     */
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource);
//    }

    /**
     * PlatformTransactionManager
     * @return PlatformTransactionManager
     */
//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
