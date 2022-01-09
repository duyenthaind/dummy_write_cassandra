package com.thaind.sample.cassandra.bootstrap;

import com.thaind.sample.cassandra.common.Config;

/**
 * @author duyenthai
 */
public class Start {
    public static void main(String[] args) {
        Config.loadConfig();
        BootStrap.start();
    }
}
