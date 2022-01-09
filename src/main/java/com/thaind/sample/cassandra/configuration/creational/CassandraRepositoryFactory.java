package com.thaind.sample.cassandra.configuration.creational;

import com.datastax.oss.driver.api.core.CqlSession;
import com.thaind.sample.cassandra.common.Constants;
import com.thaind.sample.cassandra.configuration.connection.CassandraConfiguration;
import com.thaind.sample.cassandra.configuration.mapper.CassandraRepositoryBootstrapMapper;
import com.thaind.sample.cassandra.repository.Repository;

/**
 * @author duyenthai
 */
public class CassandraRepositoryFactory {
    private CassandraRepositoryFactory() {
    }

    public static Repository<?> getRepository(Constants.CassandraRepositoryType cassandraRepositoryType) {
        CqlSession cqlSession = CassandraConfiguration.getCqlSessionBuilder().build();
        CassandraRepositoryBootstrapMapper cassandraMapper = CassandraRepositoryBootstrapMapper.builder(cqlSession).build();
        switch (cassandraRepositoryType) {
            case DH_MESSAGE:
                return cassandraMapper.getDhMessageRepository();
            case DH_USER:
                return cassandraMapper.getDhUserRepository();
            default:
                return null;
        }
    }
}
