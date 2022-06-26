package com.goldwood.gateway.filter.global;

import com.goldwood.common.filter.FilterChain;
import com.goldwood.common.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 负载均衡过滤器
 *
 * @author goldwood
 * @since 2022/6/25
 */
public class LoadBalancerFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> doWorker(ServerWebExchange exchange, FilterChain chain) {
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
