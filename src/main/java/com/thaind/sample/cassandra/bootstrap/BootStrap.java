package com.thaind.sample.cassandra.bootstrap;

import com.thaind.sample.cassandra.common.Constants;
import com.thaind.sample.cassandra.configuration.creational.CassandraRepositoryFactory;
import com.thaind.sample.cassandra.repository.DhMessageRepository;
import com.thaind.sample.cassandra.repository.DhUserRepository;
import com.thaind.sample.cassandra.worker.processor.WriterProcessor;
import com.thaind.sample.cassandra.worker.writer.DatabaseWriter;
import com.thaind.sample.cassandra.worker.writer.MessageDatabaseWriter;
import com.thaind.sample.cassandra.worker.writer.UserDatabaseWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyenthai
 */
public class BootStrap {

    private static final Logger LOGGER = Logger.getLogger(BootStrap.class.toString());

    private BootStrap(){
    }

    public static void start() {
        DhMessageRepository dhMessageRepository = (DhMessageRepository) CassandraRepositoryFactory.getRepository(Constants.CassandraRepositoryType.DH_MESSAGE);
        DhUserRepository dhUserRepository = (DhUserRepository) CassandraRepositoryFactory.getRepository(Constants.CassandraRepositoryType.DH_USER);

        DatabaseWriter messageDatabaseWriter = new MessageDatabaseWriter(dhMessageRepository);
        DatabaseWriter userDatabaseWriter = new UserDatabaseWriter(dhUserRepository);

        WriterProcessor messageWriterProcessor = new WriterProcessor(messageDatabaseWriter, "MessageWriterProcessor");
        WriterProcessor userWriterProcessor = new WriterProcessor(userDatabaseWriter, "UserWriterProcessor");

        Thread messageWriterThread = new Thread(messageWriterProcessor, messageWriterProcessor.getWorkerName());
        Thread userWriterThread = new Thread(userWriterProcessor, userWriterProcessor.getWorkerName());

        messageWriterThread.start();
        userWriterThread.start();

        LOGGER.log(Level.INFO, "Start done!!");
    }
}
