package com.goldwood.common.filter;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class GatewayFilterAdapter implements GatewayFilter {
    private final GlobalFilter delegate;

    public GatewayFilterAdapter(GlobalFilter delegate) {
        this.delegate = delegate;
    }

    @Override
    public Mono<Void> exec(ServerWebExchange exchange, FilterChain chain) {
        return this.delegate.doWorker(exchange, chain);
    }
}
