package com.autodialer.gateway.loggingFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class AutoDialerGatewayLoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(AutoDialerGatewayLoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of the RequestRecieved ->{}",exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
