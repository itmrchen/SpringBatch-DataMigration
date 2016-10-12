package com.javazx.batch.logback;

import java.io.FileNotFoundException;
import javax.servlet.ServletContext;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.util.WebUtils;

public abstract class LogbackWebConfigurer {

    /** Parameter specifying the location of the logback config file */
    public static final String CONFIG_LOCATION_PARAM     = "logbackConfigLocation";

    /** Parameter specifying the refresh interval for checking the logback config file */
    public static final String REFRESH_INTERVAL_PARAM    = "logbackRefreshInterval";

    /** Parameter specifying whether to expose the web app root system property */
    public static final String EXPOSE_WEB_APP_ROOT_PARAM = "logbackExposeWebAppRoot";

    /**
     * Initialize logback, including setting the web app root system property.
     *
     * @param servletContext
     *            the current ServletContext
     * @see WebUtils#setWebAppRootSystemProperty
     */
    public static void initLogging(ServletContext servletContext) {
        // Expose the web app root system property.
        if (exposeWebAppRoot(servletContext)) {
            WebUtils.setWebAppRootSystemProperty(servletContext);
        }

        // Only perform custom logback initialization in case of a config file.
        String location = servletContext.getInitParameter(CONFIG_LOCATION_PARAM);
        if (location != null) {
            // Perform actual logback initialization; else rely on logback's default initialization.
            try {
                // Return a URL (e.g. "classpath:" or "file:") as-is;
                // consider a plain file path as relative to the web application root directory.
                if (!ResourceUtils.isUrl(location)) {
                    // Resolve system property placeholders before resolving real path.
                    location = SystemPropertyUtils.resolvePlaceholders(location);
                    location = WebUtils.getRealPath(servletContext, location);
                }

                // Write log message to server log.
                servletContext.log("Initializing logback from [" + location + "]");

                // Initialize without refresh check, i.e. without logback's watchdog thread.
                LogbackConfigurer.initLogging(location);

            } catch (FileNotFoundException ex) {
                throw new IllegalArgumentException("Invalid 'logbackConfigLocation' parameter: " + ex.getMessage());
            }
        }
    }

    /**
     * Shut down logback, properly releasing all file locks and resetting the web app root system property.
     *
     * @param servletContext
     *            the current ServletContext
     * @see WebUtils#removeWebAppRootSystemProperty
     */
    public static void shutdownLogging(ServletContext servletContext) {
        servletContext.log("Shutting down logback");
        try {
            LogbackConfigurer.shutdownLogging();
        } finally {
            // Remove the web app root system property.
            if (exposeWebAppRoot(servletContext)) {
                WebUtils.removeWebAppRootSystemProperty(servletContext);
            }
        }
    }

    /**
     * Return whether to expose the web app root system property, checking the corresponding ServletContext init parameter.
     *
     * @see #EXPOSE_WEB_APP_ROOT_PARAM
     */
    private static boolean exposeWebAppRoot(ServletContext servletContext) {
        String exposeWebAppRootParam = servletContext.getInitParameter(EXPOSE_WEB_APP_ROOT_PARAM);
        return (exposeWebAppRootParam == null || Boolean.valueOf(exposeWebAppRootParam));
    }

}