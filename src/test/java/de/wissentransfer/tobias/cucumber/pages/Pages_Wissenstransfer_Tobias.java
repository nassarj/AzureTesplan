package de.wissentransfer.tobias.cucumber.pages;

import de.wissentransfer.tobias.utilities.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.wissentransfer.tobias.utilities.Logger.logError;
import static de.wissentransfer.tobias.utilities.Logger.logInfo;
import static org.junit.Assert.assertTrue;

@Component
public class Pages_Wissenstransfer_Tobias {

    @Autowired
    protected WebDriver driver;
    @Autowired
    FileDirectoryUtility fileDirectoryUtility;

    public static Map<String, String> testDaten = new HashMap<>();
    public static Map<String, List<String>> testDatenListe = new HashMap<>();

    public void call_Webseite() {

        String webseite = TestContext.getStageprops().getProperty("destatis.web.seite");
        logInfo("WEbseite Aufruf: " + webseite);
        driver.get(webseite);
        driver.navigate();
    }


    public boolean derAnwenderPrüftObImOrdnerVomVorhandenIst(String datei, String verzeichnis) {
        return fileVorhanden(verzeichnis+"\\"+datei);
    }


    public void derAnwenderÖffnetDatei(String datei) {

    }


    /**
     *
     * @param datei
     * @param sheet
     * @param zeile
     * @param spalte
     */
    public void derAnwenderHoltAusDerDieInformation(String key,String datei,String sheet,String zeile, String spalte) {
        String excelfileOrdner = TestContext.getStageprops().getProperty("testdata.path");
        String info = fileDirectoryUtility.Liefere_Excel_CellValue(excelfileOrdner+datei,
                Integer.parseInt(sheet),
                Integer.parseInt(zeile),
                Integer.parseInt(spalte)
        );
        logInfo("CellValue: "+info+
        "\n in File: "+excelfileOrdner+datei+
        "\n in Sheet: "+        Integer.parseInt(sheet)+
        "\n in Row: "+        Integer.parseInt(zeile)+
        "\n in Column: "+       Integer.parseInt(spalte)
        );
        testDaten.put(key,info);
    }


    public void derAnwenderHinterlegtDieInfoInEinerInternerListe(String key) {
        logInfo(testDaten.get(key));
    }

    /**
     * Prüfung ob eine json Datei vorhanden ist.
     *
     * @param file Jeson Datei
     * @return true oder false
     */
    public boolean fileVorhanden(String file) {

        try {
            Path path = Paths.get(file);
            boolean vorhanden = Files.exists(path);
            if (!vorhanden) {
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            logError("fileVorhanden/file: " + file);
            logError(e.toString());
            return false;
        }
    }
}
