package com.garden.life.provider.user.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.*;

@Data
@ConfigurationProperties(prefix = "life.garden.user.pool")
public class ThreadPoolTaskProperties {
    private int coreSize;
    private int maxSize;
    private Long aliveTime;
}
