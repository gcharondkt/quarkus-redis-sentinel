package com.test.cache;

import io.quarkus.logging.Log;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.runtime.Startup;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Startup
public class RedisCache {

    @Inject
    ReactiveRedisDataSource reactiveRedisDataSource;

    @PostConstruct
    public void init() {
        var valueCommands = reactiveRedisDataSource.value(byte[].class);
        var testValue = valueCommands.get("test").await().indefinitely();
        Log.info(testValue);
    }
}
