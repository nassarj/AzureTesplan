/**
 * Autor: joseph.nassar@msg.group
 * FirefoxDriverSingleton class
 */
package de.wissentransfer.tobias.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import static de.destatis.oeaws.utilities.Logger.logInfo;

public class FirefoxDriverSingleton {

    private static final FirefoxDriverSingleton firefoxDriverSingleton = new FirefoxDriverSingleton();
    private WebDriver driver = null;

    private final FirefoxOptions firefoxOptions = new FirefoxOptions();
    private final String BROWSER_DRIVER_PATH = TestContext.getStageprops().getProperty("browser.driver.path");
    //private final String BROWSER_DRIVER_LOGFILE = TestContext.getStageprops().getProperty("browser.driver.logfile");
    //private final String BROWSER_USER_DATA_PATH = TestContext.getStageprops().getProperty("browser.user.data.path");
    //private final String BROWSER_ARGUMENT_HEADLESS_BOOL = TestContext.getStageprops().getProperty("browser.argument.headless");
    private final String BROWSER_ARGUMENT_HEADLESS_BOOL =TestContext.getStageprops().getProperty("browser.headless");

    //private final String BROWSER_ARGUMENT_HANDLE_UNTRUSTED_CERTIFICATE = TestContext.getStageprops().getProperty("browser.handle.untrusted.certificate");

    //private final String root_file =  TestContext.getStageprops().getProperty("oeaws.root.file");
    //private final String root_directory = new File(root_file).getAbsolutePath().replaceAll(root_file,"");


    /**
     * FirefoxDriverSingletonoeaws.root.file
     */
    private FirefoxDriverSingleton() {
        initDriver();
    }


    /**
     * @return Liefert die Instanz des Singleton zurück.
     */
    public static FirefoxDriverSingleton getInstance() {
        return firefoxDriverSingleton;
    }


    /**
     * @return Liefert den initialisierten Chrome Webtreiber zurück.
     */
    public WebDriver getDriver() {
        if (driver == null)
            initDriver();
        return driver;
    }


    /**
     * initDriver
     */
    private void initDriver() {
//        logInfo("BROWSER_DRIVER_PATH:"+BROWSER_DRIVER_PATH+"\n"+
//                "BROWSER_DRIVER_LOGFILE:"+BROWSER_DRIVER_LOGFILE+"\n"+
//                "BROWSER_ARGUMENT_HEADLESS_BOOL:"+BROWSER_ARGUMENT_HEADLESS_BOOL+"\n"+
//                "BROWSER_USER_DATA_PATH:"+BROWSER_USER_DATA_PATH+"\n"+
//                "BROWSER_ARGUMENT_HANDLE_UNTRUSTED_CERTIFICATE:"+BROWSER_ARGUMENT_HANDLE_UNTRUSTED_CERTIFICATE );

        System.setProperty("webdriver.gecko.driver", BROWSER_DRIVER_PATH);
        //System.setProperty("webdriver.gecko.logfile", BROWSER_DRIVER_LOGFILE);
        System.setProperty("webdriver.gecko.verboseLogging", "true");

        if (BROWSER_ARGUMENT_HEADLESS_BOOL.equals("true")) {
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--test-type");
            firefoxOptions.setHeadless(true);
            firefoxOptions.addArguments("--proxy-server='direct://'");
            firefoxOptions.addArguments("--proxy-bypass-list=*");
        }
        firefoxOptions.addArguments("--start-maximized");
        //firefoxOptions.addArguments("user-data-dir=" + BROWSER_USER_DATA_PATH);
        firefoxOptions.addArguments("--remote-debugging-port=9222");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-extensions");
//        firefoxOptions.setAcceptInsecureCerts(
//                BROWSER_ARGUMENT_HANDLE_UNTRUSTED_CERTIFICATE != null &&
//                        BROWSER_ARGUMENT_HANDLE_UNTRUSTED_CERTIFICATE.equals("true")
//        );
        firefoxOptions.addPreference("browser.download.folderList",2);
        //firefoxOptions.addPreference("browser.download.dir", root_directory);
        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        firefoxOptions.addPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk","text/comma-separated-values, text/csv, application/csv");
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk","application/excel, application/vnd.ms-excel");
        //logInfo("firefoxdriver neues Instanz anfordern");
        driver = new FirefoxDriver(this.firefoxOptions);
        if (BROWSER_ARGUMENT_HEADLESS_BOOL.equals("false")) {
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        //logInfo("WebDriver wurde erfolgreich initialisiert: "+driver.toString());
    }
}
