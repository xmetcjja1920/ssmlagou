package com.etc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class TaskComponent {

    @Resource
    private JedisPool jedisPool;

    //spring task的定任务，定时清除缓存
    @Scheduled(cron = "0 15 17 * * ?")
    public void task1(){
        Jedis jedis = jedisPool.getResource();
        jedis.del("A","B","C");
    }
}
