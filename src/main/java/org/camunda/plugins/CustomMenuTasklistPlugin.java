package org.camunda.plugins;

import org.camunda.bpm.tasklist.plugin.spi.impl.AbstractTasklistPlugin;

import java.util.HashSet;
import java.util.Set;

public class CustomMenuTasklistPlugin extends AbstractTasklistPlugin {
    public static final String ID = "custom-menu-tasklist";
    public String getId() {
        return ID;
    }

    @Override
    public Set<Class<?>> getResourceClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CustomMenuTaskListPluginResource.class);
        return classes;
    }
}
