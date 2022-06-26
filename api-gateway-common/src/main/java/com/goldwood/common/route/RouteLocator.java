package com.goldwood.common.route;

import reactor.core.publisher.Flux;

/**
 * @author goldwood
 * @since 2022/6/25
 */
public interface RouteLocator {
    Flux<Route> getRoutes();
}
