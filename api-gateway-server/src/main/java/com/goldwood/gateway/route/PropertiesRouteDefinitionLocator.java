package com.goldwood.gateway.route;

import com.goldwood.common.route.RouteDefinition;
import com.goldwood.common.route.RouteDefinitionLocator;
import com.goldwood.gateway.config.GatewayProperties;
import reactor.core.publisher.Flux;

/*
 * @author gold wood
 * @since 2022/6/26
 */
public class PropertiesRouteDefinitionLocator implements RouteDefinitionLocator {
    private final GatewayProperties properties;

    public PropertiesRouteDefinitionLocator(GatewayProperties gatewayProperties) {
        this.properties = gatewayProperties;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromIterable(properties.getRoutes());
    }
}
