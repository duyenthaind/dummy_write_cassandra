package com.thaind.sample.cassandra.common;

/**
 * @author duyenthai
 */
public class Constants {
    public enum CassandraRepositoryType {
        DH_MESSAGE(1, "dhMessageRepository"), DH_USER(2, "dhUserRepository");
        private final int type;
        private final String name;

        CassandraRepositoryType(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
