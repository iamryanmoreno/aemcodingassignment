package com.aemcodingassignment.core.models.base;

public class NavLink {
    String navigationLabel;
    String navigationLink;
    String navigationOpenInNewWin;

    public NavLink() {
    }

    public NavLink(String navigationLabel, String navigationLink) {
        this.navigationLabel = navigationLabel;
        this.navigationLink = navigationLink;
        this.navigationOpenInNewWin = "_self";
    }

    public String getNavigationLabel() {
        return navigationLabel;
    }

    public String getNavigationLink() {
        return navigationLink;
    }

    public String getNavigationOpenInNewWin() {
        return navigationOpenInNewWin;
    }
}
