package com.thaind.sample.cassandra.repository;

import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;

/**
 * @author duyenthai
 */
public interface Repository<T> {
    @Select
    T findById(String id);

    @Insert
    void save(T entity);

    @Update
    void update(T entity);

    @Delete
    void delete(T entity);
}
