package com.thaind.sample.cassandra.worker.processor;

import com.thaind.sample.cassandra.worker.writer.DatabaseWriter;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duyenthai
 */
public class WriterProcessor implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(WriterProcessor.class.toString());

    private final AtomicBoolean isRunning = new AtomicBoolean(true);
    private final DatabaseWriter writer;
    private final String workerName;

    public WriterProcessor(DatabaseWriter writer, String workerName) {
        this.writer = writer;
        this.workerName = workerName;
        Thread.currentThread().setName(workerName);
    }

    private Long interval = 50L;

    @Override
    public void run() {
        while (isRunning.get()) {
            try {
                writer.write();
                LOGGER.log(Level.INFO, String.format("[%s] Save %s record to database", Thread.currentThread().getName(), 1));
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, String.format("[%s]Error when write data to cassandra", Thread.currentThread().getName()), ex);
            }

            if (Objects.nonNull(interval) && interval > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(interval);
                } catch (InterruptedException ex) {
                    LOGGER.log(Level.SEVERE, String.format("[%s]Error when trying to sleep worker", Thread.currentThread().getName()), ex);
                }
            }
        }
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getWorkerName() {
        return workerName;
    }
}
