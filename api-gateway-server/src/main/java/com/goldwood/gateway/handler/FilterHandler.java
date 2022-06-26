package com.goldwood.gateway.handler;

import com.goldwood.common.filter.GatewayFilter;
import com.goldwood.common.filter.GatewayFilterAdapter;
import com.goldwood.common.filter.GlobalFilter;
import com.goldwood.common.filter.OrderedGatewayFilter;
import com.goldwood.gateway.filter.DefaultFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class FilterHandler implements WebHandler {
    private final List<GatewayFilter> globalFilters;

    public FilterHandler(List<GlobalFilter> globalFilters) {
        this.globalFilters = loadFilters(globalFilters);
    }

    private static List<GatewayFilter> loadFilters(List<GlobalFilter> filters) {
        return filters.stream().map(filter -> {
            GatewayFilterAdapter gatewayFilter = new GatewayFilterAdapter(filter);
            if (filter instanceof Ordered) {
                int order = ((Ordered) filter).getOrder();
                return new OrderedGatewayFilter(gatewayFilter, order);
            }
            return gatewayFilter;
        }).collect(Collectors.toList());
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange) {
        List<GatewayFilter> combined = new ArrayList<>(this.globalFilters);
        AnnotationAwareOrderComparator.sort(combined);
        return new DefaultFilterChain(combined).filter(exchange);
    }
}
