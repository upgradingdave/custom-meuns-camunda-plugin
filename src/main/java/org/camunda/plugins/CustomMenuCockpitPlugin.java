package org.camunda.plugins;

import org.camunda.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

import java.util.HashSet;
import java.util.Set;

public class CustomMenuCockpitPlugin extends AbstractCockpitPlugin {
    public static final String ID = "custom-menu-cockpit";
    public String getId() {
        return ID;
    }

    @Override
    public Set<Class<?>> getResourceClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CustomMenuCockpitPluginResource.class);
        return classes;
    }
}
