package de.wissentransfer.tobias.testsuite;

;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import de.wissentransfer.tobias.cucumber.runner.RunDestatis_start;
import de.wissentransfer.tobias.utilities.CucumberReport;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Testsuite für die GUI Tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
        RunDestatis_start.class
})
public class TestSuite_Wissesnstransfer {
    // Neue Reports einfach in dieser Liste hinzufuegen.
    private static final List<String> JSON_REPORTS = new ArrayList<>();

    static {
        JSON_REPORTS.add("target/cucumber_Destatis_start-v001.json");
    }

    /**
     * Erstellt den Cucumber Report für alle Testklassen
     */
    @AfterClass
    public static void erstelleReport() {
        List<String> jsonFiles = new ArrayList<>();

        JSON_REPORTS.stream().filter(TestSuite_Wissesnstransfer::jsonDateiVorhanden).forEach(jsonFiles::add);
        CucumberReport.generateReport("Cucumber Genesis Testautomatisierung", jsonFiles);
    }

    /**
     * Prüfung ob eine json Datei vorhanden ist.
     * @param jsonDatei Jeson Datei
     * @return true oder false
     */
    static boolean jsonDateiVorhanden(String jsonDatei) {

        Path path = Paths.get(jsonDatei);
        return Files.exists(path);
    }
}
