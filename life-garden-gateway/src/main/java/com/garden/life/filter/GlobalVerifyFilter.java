package com.garden.life.filter;


import com.garden.life.commons.util.JwtTokenUtils;
import com.garden.life.commons.util.RedisUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * <p>
 *     过滤请求
 * </p>
 * @author lenvaco
 * @date 2020/4/21 14:26
 */
@Component
public class GlobalVerifyFilter implements GlobalFilter, Ordered {

	/**
	 * 请求头中的令牌名
	 */
	private final static String TOKEN_NAME = "token";
	/**
	 * 令牌前缀
	 */
	private final static String TOKEN_PREFIX = "Bearer ";
	/**
	 * 放行的URI
	 */
	public final static String[] IGNORE_URI = {"/auth/**"};

	private AntPathMatcher pathMatcher;
	private JwtTokenUtils jwtTokenUtils;
	private RedisUtils redisUtils;

	@PostConstruct
	private void init() {
		pathMatcher = new AntPathMatcher();
		jwtTokenUtils = new JwtTokenUtils();
		redisUtils = new RedisUtils();
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		ServerHttpRequest request = exchange.getRequest();
		ServerHttpResponse response = exchange.getResponse();
		//获取请求URI
		String requestUri = request.getURI().getPath();
		//判断用户是否访问的为放行路径，如果是放行路径则放行
		for (String uri : IGNORE_URI) {
			if (pathMatcher.match(uri, requestUri)) {
				return chain.filter(exchange);
			}
		}
		String token = request.getHeaders().getFirst(TOKEN_NAME);
		//如果请求头中的令牌为空或者非法, 则返回错误状态码
		if (StringUtils.isEmpty(token) || !token.startsWith(TOKEN_PREFIX)){
			return handleUnAuthorize(response);
		}
		token = token.substring(TOKEN_PREFIX.length());
		//验证token是否失效
		if (jwtTokenUtils.isTokenExpired(token) || redisUtils.get(token) == null){
			return handleUnAuthorize(response);
		}
		return chain.filter(exchange);
	}

	public  Mono<Void> handleUnAuthorize(ServerHttpResponse response) {
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		return response.setComplete();
	}

	@Override
	public int getOrder() {
		return 1000;
	}
}
