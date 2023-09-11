package com.example.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Cacheable("test1")
    public String cacheTest() throws InterruptedException {
        Thread.sleep(3000L);
        return "Cacheable test";
    }

    @Cacheable(value = "test5", key = "#num")
    public String cacheTestKey(int num) throws InterruptedException {
        Thread.sleep(3000L);
        return "Cacheable test num:" + num;
    }

    @CachePut(value = "test5", key = "#num")
    public String cacheTestPut(int num) throws InterruptedException {
        return "CachePut test updated num:" + num;
    }

    @CacheEvict(value = "test5", key = "#num")
    public String cacheTestEvict(int num) throws InterruptedException {
        return "CacheEvict test evict num:" + num;
    }

    @CacheEvict(value = "test5", allEntries = true)
    public String cacheTestEvictAllEntries() throws InterruptedException {
        return "CacheEvict test evict allEntries";
    }
}
