package com.garden.life.provider.user.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;


@Configuration
@EnableConfigurationProperties(ThreadPoolTaskProperties.class)
public class ThreadPoolTaskConfiguration {
    /**
     * 自定义线程池类
     */
    static class TaskThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        TaskThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            if (null == name || name.isEmpty()) {
                name = "TaskThreadPool";
            }
            namePrefix = name +
                    poolNumber.getAndIncrement() +
                    "-Thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    /**
     * 创建线程池实例
     * @param threadPoolTaskProperties 线程池参数
     * @return 线程池实例
     */
    @Bean(name = "taskThreadPool")
    public ThreadPoolExecutor taskThreadPool(ThreadPoolTaskProperties threadPoolTaskProperties){
        return new ThreadPoolExecutor(threadPoolTaskProperties.getCoreSize(),
                                      threadPoolTaskProperties.getMaxSize(),
                                      threadPoolTaskProperties.getAliveTime(),
                                      threadPoolTaskProperties.getTimeUnit(),
                                      threadPoolTaskProperties.getBlockingQueue(),
                                      new TaskThreadFactory("UserModuleThreadPool"));
    }
}
