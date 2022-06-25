package com.goldwood.gateway.handler;

import org.springframework.core.env.Environment;
import org.springframework.web.reactive.handler.AbstractHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class RouteHandlerMapping extends AbstractHandlerMapping {

    private final FilterHandler filterHandler;

    public RouteHandlerMapping(FilterHandler filterHandler, Environment environment) {
        this.filterHandler = filterHandler;
        setOrder(1);
    }

    @Override
    protected Mono<?> getHandlerInternal(ServerWebExchange exchange) {
        return Mono.just(filterHandler);
    }
}
