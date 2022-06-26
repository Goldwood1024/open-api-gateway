package com.goldwood.gateway.handler;

import com.goldwood.common.route.Route;
import com.goldwood.common.route.RouteLocator;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.handler.AbstractHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public class RouteHandlerMapping extends AbstractHandlerMapping {

    private final FilterHandler filterHandler;

    private final RouteLocator routeLocator;

    public RouteHandlerMapping(FilterHandler filterHandler, RouteLocator routeLocator, Environment environment) {
        this.filterHandler = filterHandler;
        this.routeLocator = routeLocator;
        setOrder(1);
    }

    @Override
    protected Mono<?> getHandlerInternal(ServerWebExchange exchange) {
        return lookupRoute(exchange)
                .flatMap((Function<Route, Mono<?>>) r -> {
                    return Mono.just(filterHandler);
                }).switchIfEmpty(Mono.empty().then(Mono.fromRunnable(() -> {
                })));
    }

    public Mono<Route> lookupRoute(ServerWebExchange exchange) {
        return routeLocator.getRoutes()
//                .concatMap(route -> Mono.just(route).filterWhen(r -> {
//                            return true;
//                        })
//                        .onErrorResume(e -> Mono.empty()))
                .next()
                .map(route -> route);
    }
}
