package com.goldwood.gateway.filter.global;

import com.goldwood.common.filter.FilterChain;
import com.goldwood.common.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class GatewayMetricsFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, FilterChain chain) {
//        DataBuffer buffer = exchange.getResponse().bufferFactory()
//                .wrap("11".getBytes());
//        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
//        exchange.getResponse().writeWith(Flux.just(buffer));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 110;
    }
}
