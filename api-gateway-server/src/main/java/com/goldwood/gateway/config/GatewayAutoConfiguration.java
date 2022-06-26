package com.goldwood.gateway.config;

import com.goldwood.common.filter.GlobalFilter;
import com.goldwood.common.route.RouteDefinitionLocator;
import com.goldwood.common.route.RouteLocator;
import com.goldwood.gateway.filter.global.GatewayMetricsFilter;
import com.goldwood.gateway.filter.global.LoadBalancerFilter;
import com.goldwood.gateway.filter.global.RoutingFilter;
import com.goldwood.gateway.handler.FilterHandler;
import com.goldwood.gateway.handler.RouteHandlerMapping;
import com.goldwood.gateway.route.PropertiesRouteDefinitionLocator;
import com.goldwood.gateway.route.RouteDefinitionRouteLocator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @author goldwood
 * @since 2022/6/25
 */
@EnableConfigurationProperties(GatewayProperties.class)
@Configuration(proxyBeanMethods = false)
public class GatewayAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public FilterHandler filterHandler(List<GlobalFilter> globalFilters) {
        return new FilterHandler(globalFilters);
    }

    @Bean
    @ConditionalOnMissingBean
    public RouteHandlerMapping routePredicateHandlerMapping(FilterHandler filterHandler, RouteLocator routeLocator, Environment environment) {
        return new RouteHandlerMapping(filterHandler, routeLocator, environment);
    }

    @Bean
    public GatewayMetricsFilter gatewayMetricsFilter() {
        return new GatewayMetricsFilter();
    }

    @Bean
    public LoadBalancerFilter loadBalancerFilter() {
        return new LoadBalancerFilter();
    }

    @Bean
    public RoutingFilter routingFilter() {
        return new RoutingFilter();
    }

    @Bean
    public RouteLocator routeLocator(GatewayProperties gatewayProperties, RouteDefinitionLocator routeDefinitionLocator) {
        return new RouteDefinitionRouteLocator(gatewayProperties, routeDefinitionLocator);
    }

    @Bean
    public PropertiesRouteDefinitionLocator propertiesRouteDefinitionLocator(GatewayProperties gatewayProperties) {
        return new PropertiesRouteDefinitionLocator(gatewayProperties);
    }
}
