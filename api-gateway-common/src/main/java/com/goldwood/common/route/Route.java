package com.goldwood.common.route;

import lombok.ToString;
import org.springframework.core.Ordered;

import java.net.URI;

/*
 * @author gold wood
 * @since 2022/6/26
 */
@ToString
public class Route implements Ordered {
    private RouteGroup routeGroup;
    private String id;
    private URI uri;
    private int order;
    // HTTP、HTTPS、WEBSOCKET
    private String protocol;

    @Override
    public int getOrder() {
        return order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public RouteGroup getRouteGroup() {
        return routeGroup;
    }

    public void setRouteGroup(RouteGroup routeGroup) {
        this.routeGroup = routeGroup;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
