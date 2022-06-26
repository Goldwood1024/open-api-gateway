package com.goldwood.gateway.config;

import com.goldwood.common.route.RouteDefinition;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/*
 * @author gold wood
 * @since 2022/6/26
 */
@ToString
@ConfigurationProperties(GatewayProperties.PREFIX)
public class GatewayProperties {
    protected final static String PREFIX = "api.gateway";

    private List<RouteDefinition> routes = new ArrayList<>();

    public List<RouteDefinition> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDefinition> routes) {
        this.routes = routes;
    }
}
