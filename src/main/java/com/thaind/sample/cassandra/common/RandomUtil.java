package com.thaind.sample.cassandra.common;

import java.util.Random;

/**
 * @author duyenthai
 */
public class RandomUtil {

    private RandomUtil() {
    }

    public static Random createRandom() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * 10000 + Thread.currentThread().getId());
        return random;
    }

    public static String generateRandomString(int length) {
        int leftLimit = 97; // a
        int rightLimit = 122; //z
        Random random = createRandom();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateRandomString(int length, Random random) {
        int leftLimit = 97; // a
        int rightLimit = 122; //z

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
