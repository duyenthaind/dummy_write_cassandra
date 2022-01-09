package com.thaind.sample.cassandra.repository;

import com.datastax.oss.driver.api.mapper.annotations.*;
import com.thaind.sample.cassandra.entity.DhMessage;

/**
 * @author duyenthai
 */
@Dao
public interface DhMessageRepository extends Repository<DhMessage> {
}
