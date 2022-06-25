package com.goldwood.gateway.config;

import com.goldwood.common.filter.GlobalFilter;
import com.goldwood.gateway.filter.global.GatewayMetricsFilter;
import com.goldwood.gateway.handler.FilterHandler;
import com.goldwood.gateway.handler.RouteHandlerMapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @author goldwood
 * @since 2022/6/25
 */
@Configuration(proxyBeanMethods = false)
public class GatewayAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public FilterHandler filterHandler(List<GlobalFilter> globalFilters) {
        return new FilterHandler(globalFilters);
    }

    @Bean
    @ConditionalOnMissingBean
    public RouteHandlerMapping routePredicateHandlerMapping(FilterHandler filterHandler, Environment environment) {
        return new RouteHandlerMapping(filterHandler, environment);
    }

    @Bean
    public GatewayMetricsFilter gatewayMetricsFilter() {
        return new GatewayMetricsFilter();
    }
}
