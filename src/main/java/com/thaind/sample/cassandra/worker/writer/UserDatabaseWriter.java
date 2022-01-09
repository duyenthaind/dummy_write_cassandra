package com.thaind.sample.cassandra.worker.writer;

import com.thaind.sample.cassandra.common.RandomUtil;
import com.thaind.sample.cassandra.entity.DhUser;
import com.thaind.sample.cassandra.repository.Repository;

import java.util.Random;
import java.util.UUID;

/**
 * @author duyenthai
 */
public class UserDatabaseWriter extends DatabaseWriterAbstraction<DhUser> implements DatabaseWriter {

    public UserDatabaseWriter(Repository<DhUser> repository) {
        super(repository);
    }

    @Override
    public void write() throws Exception {
        Random random = RandomUtil.createRandom();
        DhUser dhUser = new DhUser();
        dhUser.setId(UUID.randomUUID().toString());
        dhUser.setGender((byte) random.nextInt(2));
        dhUser.setAvatar(RandomUtil.generateRandomString(20, random));
        dhUser.setCode(RandomUtil.generateRandomString(5, random));
        dhUser.setCreated(System.currentTimeMillis() / 1000L);
        dhUser.setUpdated(0L);
        repository.save(dhUser);
    }
}
