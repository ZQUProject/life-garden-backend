package com.garden.life.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>
 *     过滤请求
 * </p>
 * @author lenvaco
 * @date 2020/4/21 14:26
 */
public class GlobalVerifyFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		return null;
	}

	@Override
	public int getOrder() {
		return 1000;
	}
}
