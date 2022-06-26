package com.goldwood.gateway.filter;

import com.goldwood.common.filter.FilterChain;
import com.goldwood.common.filter.GatewayFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class DefaultFilterChain implements FilterChain {
    private final int index;

    private final List<GatewayFilter> filters;

    public DefaultFilterChain(List<GatewayFilter> filters) {
        this.filters = filters;
        this.index = 0;
    }

    private DefaultFilterChain(DefaultFilterChain parent, int index) {
        this.filters = parent.getFilters();
        this.index = index;
    }

    private List<GatewayFilter> getFilters() {
        return filters;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange) {
        return Mono.defer(() -> {
            if (this.index < filters.size()) {
                GatewayFilter filter = filters.get(this.index);
                DefaultFilterChain chain = new DefaultFilterChain(this, this.index + 1);
                return filter.exec(exchange, chain);
            } else {
                return Mono.empty();
            }
        });
    }
}
