/**
 * Autor: joseph.nassar@msg.group
 * HandleProperties
 */
package de.wissentransfer.tobias.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//import static de.destatis.oeaws.utilities.Logger.logInfo;

public class HandleProperties {

    /**
     * @param filename Lade die Properties Datei filename.
     * @return Hashtabelle mit den Properties.
     */
    public static java.util.Properties readPropertiesFile(String filename, boolean interneRessource) {
        //logInfo("Property-File: "+filename);
        java.util.Properties properties = new java.util.Properties();

        if (interneRessource) {

            try (InputStream stream = HandleProperties.class.getClassLoader().getResourceAsStream(filename)) {
                if (stream != null)
                    properties.load(stream);
            } catch (IOException exc) {
                exc.printStackTrace();
            }

        } else {

            try (InputStream stream = new FileInputStream(filename)) {
                properties.load(stream);
            } catch (IOException exc) {
                exc.printStackTrace();
            }

        }
        return properties;
    }
}
