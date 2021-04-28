### Overview 

A Plugin to customize the `Sign Out` link and Menu Items displayed in Cockpit and Tasklist

### Install and Configure

Build the plugin with `mvn clean install`. Then copy the `custom-maven-(version).jar` into 
`$CAMUNDA_HOME/server/apache-tomcat-(version)/webapps/camunda/WEB-INF/lib`

Start camunda. Navigate to Cockpit. If installed correctly, you should see that the logout link has been replaced with 
a link named "Setup Custom Menus".

The plugin looks for a json file named `customMenuItems.json`. Click on the "Setup Custom Menus" link. A alert dialog 
should show the directory path to create your `customMenuItems.json`. 

Copy the sample `customMenuItems.json` to the directory path shown in the alert. 

Here's the format of `customMenuItems.json`. Edit however needed:

    {
      "logout": {
        "id": "logout",
        "display": "My Custom Logout",
        "url": "?signout=true",
        "onclick": ""
      },
      "links" : {
        "camunda": {
          "id": "camunda",
          "display": "Camunda",
          "url": "https://camunda.com/",
          "onclick": ""
        },
        "github": {
          "id": "github",
          "display": "Camunda GitHub",
          "url": "https://github.com/camunda",
          "onclick": ""
        }
      }
    }


                   





