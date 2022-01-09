package com.thaind.sample.cassandra.configuration.connection;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.thaind.sample.cassandra.common.Config;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyenthai
 */
public class CassandraConfiguration {
    private static final Logger LOGGER = Logger.getLogger(CassandraConfiguration.class.toString());
    public static final CqlSessionBuilder CQL_SESSION_BUILDER;

    private CassandraConfiguration() {
    }

    static {
        try {
            if (Boolean.FALSE.equals(Config.IS_START_CASSANDRA)) {
                CQL_SESSION_BUILDER = null;
            } else {
                String cassandraConfigFilePath = System.getProperty("user.dir") + File.separator + Config.CASSANDRA_CONFIG_FILE;
                File cassandraConfigFile = new File(cassandraConfigFilePath);
                CQL_SESSION_BUILDER = new CqlSessionBuilder();
                CQL_SESSION_BUILDER.withConfigLoader(DriverConfigLoader.fromFile(cassandraConfigFile));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Init cassandra session builder failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static CqlSessionBuilder getCqlSessionBuilder() {
        return CQL_SESSION_BUILDER;
    }
}
