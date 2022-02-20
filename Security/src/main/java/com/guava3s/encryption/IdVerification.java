package com.guava3s.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author micolen
 * @version 1.0
 * @ClassName IdVerification
 * @date 2021/12/1 14:20
 */
public class IdVerification {

    private static Jedis jedis;

    @Autowired
    public static void setJedis(Jedis jedis) {
        IdVerification.jedis = jedis;
    }

    public static String detectionFromRedis(String userUUID) {
        jedis.hset("Users", "User" + userUUID, " ");

        return null;
    }


}
