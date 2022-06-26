package com.goldwood.gateway.route;

import com.goldwood.common.filter.GatewayFilter;
import com.goldwood.common.route.Route;
import com.goldwood.common.route.RouteDefinition;
import com.goldwood.common.route.RouteDefinitionLocator;
import com.goldwood.common.route.RouteLocator;
import com.goldwood.gateway.config.GatewayProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/*
 * @author gold wood
 * @since 2022/6/26
 */
@Slf4j
public class RouteDefinitionRouteLocator implements RouteLocator {
    private final GatewayProperties gatewayProperties;

    private final RouteDefinitionLocator routeDefinitionLocator;

    public RouteDefinitionRouteLocator(GatewayProperties gatewayProperties, RouteDefinitionLocator routeDefinitionLocator) {
        this.gatewayProperties = gatewayProperties;
        this.routeDefinitionLocator = routeDefinitionLocator;
    }

    @Override
    public Flux<Route> getRoutes() {
        Flux<Route> routes = routeDefinitionLocator.getRouteDefinitions().map(this::convertToRoute);
        return routes.map(route -> route);
    }

    private Route convertToRoute(RouteDefinition routeDefinition) {
        // 获取该路由要的过滤器
        List<GatewayFilter> gatewayFilters = getFilters(routeDefinition);
        return new Route();
    }

    private List<GatewayFilter> getFilters(RouteDefinition routeDefinition) {
        List<GatewayFilter> filters = new ArrayList<>();
        AnnotationAwareOrderComparator.sort(filters);
        return filters;
    }
}
