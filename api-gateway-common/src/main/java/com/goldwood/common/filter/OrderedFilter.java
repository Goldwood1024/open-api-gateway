package com.goldwood.common.filter;

import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class OrderedFilter implements Filter, Ordered {
    private final Filter delegate;

    private final int order;

    public OrderedFilter(Filter delegate, int order) {
        this.delegate = delegate;
        this.order = order;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, FilterChain chain) {
        return delegate.filter(exchange, chain);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
