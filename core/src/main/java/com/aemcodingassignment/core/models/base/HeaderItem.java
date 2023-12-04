package com.aemcodingassignment.core.models.base;

import java.util.List;

public class HeaderItem {
    String navigationHeader;

    List<NavLink> navigationLinks;

    public HeaderItem() {
    }

    public HeaderItem(String navigationHeader, List<NavLink> navigationLinks) {
        this.navigationHeader = navigationHeader;
        this.navigationLinks = navigationLinks;
    }

    public String getNavigationHeader() {
        return navigationHeader;
    }

    public List<NavLink> getNavigationLinks() {
        return navigationLinks;
    }
}
