package com.garden.life.provider.user.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.*;

@Data
@ConfigurationProperties(prefix = "life.garden.user.pool")
public class ThreadPoolTaskProperties {
    private int coreSize;
    private int maxSize;
    private int aliveTime;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();
}
