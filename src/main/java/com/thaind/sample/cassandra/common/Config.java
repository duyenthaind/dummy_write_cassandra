package com.thaind.sample.cassandra.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyenthai
 */
public class Config {

    private static final Logger LOGGER = Logger.getLogger(Config.class.toString());

    public static String CASSANDRA_CONFIG_FILE = ConfigHolder.CASSANDRA_CONFIG_FILE_LOCATION;
    public static boolean IS_START_CASSANDRA = false;

    private Config(){
    }

    public static void loadConfig() {
        InputStream configFileInputStream = null;
        try {
            File file = new File(ConfigHolder.APP_CONFIGURATION_FILE_LOCATION);
            configFileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(configFileInputStream);

            IS_START_CASSANDRA = Boolean.valueOf(properties.getProperty(ConfigProperty.IS_START_CASSANDRA));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, String.format("Cannot load configuration from file %s", ConfigHolder.APP_CONFIGURATION_FILE_LOCATION), ex);
        } finally {
            if (Objects.nonNull(configFileInputStream)) {
                try {
                    configFileInputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Cannot close config file input stream", e);
                }
            }
        }

    }

    private static class ConfigHolder {
        public static final String CASSANDRA_CONFIG_FILE_LOCATION = "config/cassandra.conf";
        public static final String APP_CONFIGURATION_FILE_LOCATION = "config/app.conf";
    }

    private static class ConfigProperty {
        public static final String IS_START_CASSANDRA = "startCassandra";
    }
}
