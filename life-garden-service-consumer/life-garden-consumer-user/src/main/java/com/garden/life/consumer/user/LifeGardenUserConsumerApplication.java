package com.garden.life.consumer.user;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lenvaco
 * @date 2020/3/29 1:39
 */
@SpringBootApplication
public class LifeGardenUserConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeGardenUserConsumerApplication.class, args);
		Main.main(args);
	}
}
