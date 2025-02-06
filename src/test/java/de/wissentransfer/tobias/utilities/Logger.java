/**
 * Autor: Joseph Nassar
 * Logger class
 */
package de.wissentransfer.tobias.utilities;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("");
    /**
     * ogger.debug wird weiß ausgegeben
     * @param logging
     */
    public static void logDebug(String logging) {
        logger.debug(logging );
    }

    /**
     * logger.info wird weiß ausgegeben
     * @param logging
     */
    public static void logInfo(String logging) {
        logger.info( logging );
    }

    /**
     * ogger.error wird rot ausgegeben
     * @param logging
     */
    public static void logError(String logging) {
        logger.error( logging );
    }

    /**
     * ogger.error wird rot ausgegeben
     * @param logging
     */
    public static void logWarning(String logging) {
        logger.error( logging );
    }
}
