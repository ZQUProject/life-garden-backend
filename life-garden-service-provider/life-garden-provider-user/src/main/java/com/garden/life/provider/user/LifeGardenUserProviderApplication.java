package com.garden.life.provider.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lenvaco
 * @date 2020/3/28 21:36
 */
@SpringBootApplication(scanBasePackages = {"com.garden.life"})
@EnableDubbo
@EnableTransactionManagement
@EnableAsync
@MapperScan(basePackages = "com.garden.life.commons.mapper")
public class LifeGardenUserProviderApplication {
	public static void main(String[] args) {

		SpringApplication.run(LifeGardenUserProviderApplication.class, args);
		Main.main(args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// 设置默认的加密方式
		return new BCryptPasswordEncoder();
	}
}
