package com.javazx.batch.logback;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;


public abstract class LogbackConfigurer {

    /** Pseudo URL prefix for loading from the class path: "classpath:" */
    public static final String       CLASSPATH_URL_PREFIX = "classpath:";

    /** Extension that indicates a logback XML config file: ".xml" */
    public static final String       XML_FILE_EXTENSION   = ".xml";

    private static LoggerContext     lc                   = (LoggerContext) LoggerFactory.getILoggerFactory();
    private static JoranConfigurator configurator         = new JoranConfigurator();

    /**
     * Initialize logback from the given file location, with no config file refreshing. Assumes an XML file in case of a ".xml" file extension, and a properties file otherwise.
     *
     * @param location
     *            the location of the config file: either a "classpath:" location (e.g. "classpath:mylogback.properties"), an absolute file URL (e.g. "file:C:/logback.properties), or a plain absolute path in the file system (e.g. "C:/logback.properties")
     * @throws FileNotFoundException
     *             if the location specifies an invalid file path
     */
    public static void initLogging(String location) throws FileNotFoundException {
        String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(location);
        URL url = ResourceUtils.getURL(resolvedLocation);
        if (resolvedLocation.toLowerCase().endsWith(XML_FILE_EXTENSION)) {
//            DOMConfigurator.configure(url);
            configurator.setContext(lc);
            lc.reset();
            try {
                configurator.doConfigure(url);
            } catch (JoranException ex) {
                throw new FileNotFoundException(url.getPath());
            }
            lc.start();
        }
//        else {
//            PropertyConfigurator.configure(url);
//        }
    }

    /**
     * Shut down logback, properly releasing all file locks.
     * <p>
     * This isn't strictly necessary, but recommended for shutting down logback in a scenario where the host VM stays alive (for example, when shutting down an application in a J2EE environment).
     */
    public static void shutdownLogging() {
        lc.stop();
    }

    /**
     * Set the specified system property to the current working directory.
     * <p>
     * This can be used e.g. for test environments, for applications that leverage logbackWebConfigurer's "webAppRootKey" support in a web environment.
     *
     * @param key
     *            system property key to use, as expected in logback configuration (for example: "demo.root", used as "${demo.root}/WEB-INF/demo.log")
     * @see
     */
    public static void setWorkingDirSystemProperty(String key) {
        System.setProperty(key, new File("").getAbsolutePath());
    }

}