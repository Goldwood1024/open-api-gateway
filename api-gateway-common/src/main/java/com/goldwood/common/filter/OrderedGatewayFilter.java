package com.goldwood.common.filter;

import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class OrderedGatewayFilter implements GatewayFilter, Ordered {
    private final GatewayFilter delegate;

    private final int order;

    public OrderedGatewayFilter(GatewayFilter delegate, int order) {
        this.delegate = delegate;
        this.order = order;
    }

    @Override
    public Mono<Void> exec(ServerWebExchange exchange, FilterChain chain) {
        return delegate.exec(exchange, chain);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
