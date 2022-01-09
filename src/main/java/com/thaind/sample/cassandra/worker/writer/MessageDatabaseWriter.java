package com.thaind.sample.cassandra.worker.writer;

import com.thaind.sample.cassandra.common.RandomUtil;
import com.thaind.sample.cassandra.entity.DhMessage;
import com.thaind.sample.cassandra.repository.Repository;

import java.util.Random;
import java.util.UUID;

/**
 * @author duyenthai
 */
public class MessageDatabaseWriter extends DatabaseWriterAbstraction<DhMessage> implements DatabaseWriter {

    public MessageDatabaseWriter(Repository<DhMessage> repository) {
        super(repository);
    }

    @Override
    public void write() throws Exception {
        Random random = RandomUtil.createRandom();
        DhMessage dhMessage = new DhMessage();
        dhMessage.setId(UUID.randomUUID().toString());
        dhMessage.setUserId(RandomUtil.generateRandomString(6, random));
        dhMessage.setMessage(RandomUtil.generateRandomString(20, random));
        dhMessage.setCreated(System.currentTimeMillis() / 1000L);
        dhMessage.setUpdated(0L);
        dhMessage.setRead(random.nextBoolean());
        repository.save(dhMessage);
    }
}
