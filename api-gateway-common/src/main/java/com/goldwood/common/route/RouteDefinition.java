package com.goldwood.common.route;

import lombok.ToString;

import java.util.List;

/*
 * @author gold wood
 * @since 2022/6/26
 */
@ToString
public class RouteDefinition {
    private RouteGroup group;
    private List<Route> routes;

    public RouteGroup getGroup() {
        return group;
    }

    public void setGroup(RouteGroup group) {
        this.group = group;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
