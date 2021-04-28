package org.camunda.plugins;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SharedResourceMethods {

    public static String jsHelpFunction(String path) {
        String js = "Setup the Custom Menu Plugin by creating the following file:\\n";
        js += path.replace("\\", "\\\\");
        js = "alert('"+js+"')";
        return js;
    }

    public static Map<String, String> helpLink() throws IOException {
        Map<String, String> help = new HashMap<>();
        help.put("display", "Setup Custom Menus");
        help.put("url", "#");
        String jsCode = jsHelpFunction(new File(".").getCanonicalPath() + "/customMenuItems.json");
        help.put("onclick", jsCode);
        return help;
    }

    public static Map<String, Object> defaultMenuItems() throws IOException {
        Map<String, Object> menuItems = new HashMap<>();
        menuItems.put("logout", helpLink());

        Map<String, Object> links = new HashMap<>();
        links.put("help", helpLink());
        menuItems.put("links", links);
        return menuItems;
    }

    public static Response getMenuItems() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            try {
                FileReader fileReader = new FileReader(new File(".").getCanonicalPath() + "/customMenuItems.json");
                Map<String, Object> result = mapper.readValue(fileReader, new TypeReference<Map<String, Object>>() {});
                return Response.ok(result).build();
            } catch (FileNotFoundException e) {
                return Response.ok(defaultMenuItems()).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Unable to read customMenuItems.json")
                    .build();
        }
    }

}
