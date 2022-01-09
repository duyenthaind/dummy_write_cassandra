package com.thaind.sample.cassandra.repository;

import com.datastax.oss.driver.api.mapper.annotations.*;
import com.thaind.sample.cassandra.entity.DhUser;

/**
 * @author duyenthai
 */
@Dao
public interface DhUserRepository extends Repository<DhUser>{
}
