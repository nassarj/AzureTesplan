/**
 * Autor: joseph.nassar@msg.group
 * TestContext class
 */
package de.wissentransfer.tobias.utilities;

//import de.destatis.oeaws.utilities.jsonUtilities.ConfigsProfile;
//import de.destatis.oeaws.utilities.jsonUtilities.ConfigurationsReader;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//import static de.destatis.oeaws.utilities.Logger.logInfo;


@Component
public class TestContext {

    private static final String testautomation_properties = System.getProperty("configFile", null)==null?"src/test/java/de/wissentransfer/tobias/configuration/wissenstransfer.properties" : System.getProperty("configFile",null);
    private static final Properties genesisProperties = (testautomation_properties == null)
            ? HandleProperties.readPropertiesFile(testautomation_properties, true)
            : HandleProperties.readPropertiesFile(testautomation_properties, false);

//    private static ConfigsProfile currentConfigsProfile = initializeCurrentConfigsProfile();
    private static final Map<String, String> testMemoryHashmap = new HashMap<>();

    /**
     * getStageprops
     * @return Properties
     */
    public static Properties getStageprops() {
        return genesisProperties;
    }

    /**
     * lookupCredentials
     * @param organisation String
     * @param rolle String
     * @return Credentials
     */
//    public static Credentials lookupCredentials(String organisation, String rolle) {
//        return new Credentials(rolle, "dummy");
//    }

//    /**
//     * getCurrentConfigsProfile
//     * @return ConfigsProfile
//     */
//    public static ConfigsProfile getCurrentConfigsProfile() {
//        if (currentConfigsProfile == null)
//            setCurrentConfigsProfile(initializeCurrentConfigsProfile());
//        return currentConfigsProfile;
//    }
//
//    /**
//     * setCurrentConfigsProfile
//     * @param currentConfigsProfile ConfigsProfile
//     */
//    public static void setCurrentConfigsProfile(ConfigsProfile currentConfigsProfile) {
//        TestContext.currentConfigsProfile = currentConfigsProfile;
//    }
//
//    /**
//     * initializeCurrentConfigsProfile
//     * @return ConfigsProfile
//     */
//    private static ConfigsProfile initializeCurrentConfigsProfile() {
//        String userProfile = TestContext.getStageprops().getProperty("oeaws.testProfile");
//        logInfo("TestContext/userProfile: "+userProfile);
//        return ConfigurationsReader.getConfigsProfile(userProfile);
//    }

    /**
     * merkt den Wert in der Hashtabelle
     *
     * @param schluessel der Schluessel mit dem der Wert gemerkt wird
     * @param wert der Wert zum Schlüssel
     */
    public static void wertMerken(String schluessel, String wert) {
        testMemoryHashmap.put(schluessel, wert);
    }

    /**
     * liefert den im TEST_GEDAECHTNIS gespeicherten Wert
     *
     * @param schluessel der Schuessel, mit dem der gemerkte Wert gesucht werden soll
     * @return der gemerkte Wert
     */
    public static String getGemerkterWert(String schluessel) {
        if (!testMemoryHashmap.containsKey(schluessel))
            throw new NotFoundException(String.format("Schluessel %s im Memory ist nicht vorhanden",schluessel));
        return testMemoryHashmap.get(schluessel);
    }
}
