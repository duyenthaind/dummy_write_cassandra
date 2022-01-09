package com.thaind.sample.cassandra.worker.writer;

import com.thaind.sample.cassandra.repository.Repository;

/**
 * @author duyenthai
 */
public abstract class DatabaseWriterAbstraction<T> {
    protected Repository<T> repository;

    public DatabaseWriterAbstraction(Repository<T> repository) {
        this.repository = repository;
    }
}
