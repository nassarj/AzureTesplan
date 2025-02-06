/*
 * Autor: joseph.nassar@msg.group
 * Cucumber-Report Erstellung
 */

package de.wissentransfer.tobias.utilities;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.List;

public class CucumberReport {
    /**
     * Erstelle einen net.masterthought cucumber Report.
     *
     * @param title     Titel des Reports.
     * @param jsonFiles Cucumber json Dateien der einzelnen Testklassen Durchlaeufe.
     */
    public static void generateReport(String title, List<String> jsonFiles) {
        File reportOutputDirectory = new File("target");
        Configuration configuration = new Configuration(reportOutputDirectory, title);
        configuration.addClassifications("Testobjekt URL", System.getProperty("webdriver.chrome.target"));
        configuration.addClassifications("Build Branch", System.getenv("GIT_BRANCH"));
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}
