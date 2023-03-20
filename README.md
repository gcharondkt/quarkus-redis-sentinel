# quarkus-redis-sentinel

First launch a Redis instance :
```
docker run -p 6379:6379 redis
```

Then launch a Redis-sentinel instance :
```
docker run --name redis-sentinel -e REDIS_MASTER_HOST=localhost bitnami/redis-sentinel:latest
```

Then run Quarkus app.