package com.thaind.sample.cassandra.configuration.mapper;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import com.thaind.sample.cassandra.repository.DhMessageRepository;
import com.thaind.sample.cassandra.repository.DhUserRepository;

/**
 * @author duyenthai
 */
@Mapper
public interface CassandraRepositoryBootstrapMapper {

    static MapperBuilder<CassandraRepositoryBootstrapMapper> builder(CqlSession session) {
        return new CassandraRepositoryBootstrapMapperBuilder(session);
    }

    @DaoFactory
    DhMessageRepository getDhMessageRepository();

    @DaoFactory
    DhUserRepository getDhUserRepository();
}
