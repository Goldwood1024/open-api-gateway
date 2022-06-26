package com.goldwood.common.route;

import reactor.core.publisher.Flux;

/*
 * @author gold wood
 * @since 2022/6/26
 */
public interface RouteDefinitionLocator {
    Flux<RouteDefinition> getRouteDefinitions();
}
