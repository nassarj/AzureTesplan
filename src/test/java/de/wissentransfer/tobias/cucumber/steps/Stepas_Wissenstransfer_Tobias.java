package de.wissentransfer.tobias.cucumber.steps;

import de.wissentransfer.tobias.cucumber.pages.Pages_Wissenstransfer_Tobias;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public class Stepas_Wissenstransfer_Tobias {

    @Autowired
    Pages_Wissenstransfer_Tobias pages_Wissenstransfer_Tobias;

    @Given("Der Anwender ruft destatis webseite auf.")
    public void derAnwenderRuftDestatisWebseiteAuf() {
        pages_Wissenstransfer_Tobias.call_Webseite();

    }

    @When("der Anwender prüft, ob {string} im Ordner vom {string} vorhanden ist.")
    public void derAnwenderPrüftObImOrdnerVomVorhandenIst(String datei, String verzeichnis) {
        assertTrue(pages_Wissenstransfer_Tobias.derAnwenderPrüftObImOrdnerVomVorhandenIst( datei,  verzeichnis));

    }

    @And("der Anwender öffnet Datei {string}")
    public void derAnwenderÖffnetDatei(String datei) {
        pages_Wissenstransfer_Tobias.derAnwenderÖffnetDatei( datei);
    }


    @Then("der Anwender hinterlegt die Info in einer interner Liste mit {string}.")
    public void derAnwenderHinterlegtDieInfoInEinerInternerListe(String key) {
        pages_Wissenstransfer_Tobias.derAnwenderHinterlegtDieInfoInEinerInternerListe(key);
    }

    @And("der Anwender ordnet dem {string} der info {string} die Information in Sheet {string} und {string} und {string}")
    public void derAnwenderOrdnetDemDerInfoDieInformationInSheetUndUnd(String key,String datei, String sheet, String zeile, String spalte) {
        pages_Wissenstransfer_Tobias.derAnwenderHoltAusDerDieInformation( key, datei, sheet, zeile,  spalte);
    }
}