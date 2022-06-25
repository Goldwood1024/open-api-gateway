package com.goldwood.common.filter;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class FilterAdapter implements Filter {
    private final GlobalFilter delegate;

    public FilterAdapter(GlobalFilter delegate) {
        this.delegate = delegate;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, FilterChain chain) {
        return this.delegate.filter(exchange, chain);
    }
}
