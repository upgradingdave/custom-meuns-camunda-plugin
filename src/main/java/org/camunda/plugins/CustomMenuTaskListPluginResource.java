package org.camunda.plugins;

import org.camunda.bpm.tasklist.resource.AbstractTasklistPluginRootResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("plugin/" + CustomMenuTasklistPlugin.ID)
public class CustomMenuTaskListPluginResource extends AbstractTasklistPluginRootResource {
    public CustomMenuTaskListPluginResource() {
        super(CustomMenuTasklistPlugin.ID);
    }

    @GET
    @Path("menuItems")
    @Produces("application/json")
    public Response getMenuItems() {
        return SharedResourceMethods.getMenuItems();
    }
}
