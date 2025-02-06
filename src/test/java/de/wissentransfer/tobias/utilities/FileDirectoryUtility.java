package de.wissentransfer.tobias.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

import static de.wissentransfer.tobias.utilities.Logger.logError;


/**
 * Joseph Nassar
 * Utility zur Files handling
 */
@Component
public class FileDirectoryUtility {



    private String cell;

    /**
     * CSV_FileInhalt auf nicht Existenz prüfen
     *
     * @param fileName
     * @return
     */
    public String liefere_csv_Cell_Inhalt(String fileName,int rowIndex,int cellIndex ) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.lines().forEach(zeile -> {

                StringTokenizer st = new StringTokenizer(zeile, ",");
                while (st.hasMoreElements()) {
                    Cell excelCell = (Cell) st.nextElement();
                    Row row = excelCell.getRow();
                    if (row.getRowNum() == rowIndex && row.getCell(cellIndex).getColumnIndex() == cellIndex ) {
                        cell = row.getCell(cellIndex).getStringCellValue();
                        break;
                    }
                }
            });
        } catch (Exception e) {
            logError("ERROR: " + e.getMessage());
        }
        return cell;
    }

    public String Liefere_Excel_CellValue(String fileName, int sheetIndex, int rowIndex,int cellIndex) {
        String cellValue="";
        AtomicBoolean gefunden = new AtomicBoolean(false);
        try {
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            cellValue = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
            inputStream.close();
        } catch (IOException e) {
            logError("ERROR: " + e.getMessage());
        }
        return cellValue;
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
            return vorhanden;
        } catch (Exception e) {
            logError("fileVorhanden/file: " + file);
            logError(e.toString());
            return false;
        }
    }

}
