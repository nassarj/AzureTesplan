#
#Autor: Tobias Steil
#

@RegressionTest

Feature: OEAWS-Excel_Handling-v001


  Scenario Outline: Ueberpruefung des Downloads einer Tabelle ohne Qualitaetskennzeichen

#    When der Anwender prüft, ob "<Datei>" im Ordner vom "<Verzeichnis>" vorhanden ist.
#    And der Anwender öffnet Datei "<Datei>"
    And der Anwender ordnet dem "<Key>" der info "<Datei>" die Information in Sheet "<Sheet>" und "<Zeile>" und "<Spalte>"
    Then der Anwender hinterlegt die Info in einer interner Liste mit "<Key>".
    Examples:
      | Datei          | Sheet | Zeile | Spalte | Key  |
      | Testdaten.xlsx | 0     | 1     | 1      | test1      |

