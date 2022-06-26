package com.goldwood.common.route;

import lombok.ToString;

/*
 * @author gold wood
 * @since 2022/6/26
 */
@ToString
public class RouteGroup {
    private String id;
    private String groupName;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
