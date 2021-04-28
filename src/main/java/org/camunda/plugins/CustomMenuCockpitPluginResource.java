package org.camunda.plugins;

import org.camunda.bpm.cockpit.plugin.resource.AbstractCockpitPluginRootResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("plugin/" + CustomMenuCockpitPlugin.ID)
public class CustomMenuCockpitPluginResource extends AbstractCockpitPluginRootResource {

    //final Logger LOGGER = LoggerFactory.getLogger(CustomMenuCockpitPlugin.class);
    public CustomMenuCockpitPluginResource() {
        super(CustomMenuCockpitPlugin.ID);
    }

    @GET
    @Path("menuItems")
    @Produces("application/json")
    public Response getMenuItems() {
        return SharedResourceMethods.getMenuItems();
    }
}
