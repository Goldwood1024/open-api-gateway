package com.goldwood.common.filter;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public interface GlobalFilter {

    Mono<Void> filter(ServerWebExchange exchange, FilterChain chain);
}
