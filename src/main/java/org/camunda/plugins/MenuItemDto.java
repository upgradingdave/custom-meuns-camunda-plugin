package org.camunda.plugins;

public class MenuItemDto {

    public String id;
    public String display;
    public String url;

    public MenuItemDto(String id, String display, String url) {
        this.id = id;
        this.display = display;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getDisplay() {
        return display;
    }

    public String getUrl() {
        return url;
    }
}
