package com.config;

import java.util.HashMap;

public class DefaultProperties {
     private HashMap<String,String> defaultProperty=new HashMap<>();
     public DefaultProperties(){
         //Setup Here Default Properties
         defaultProperty.put("browser","chrome");
         defaultProperty.put("base64img","false");
     }
    public String getDefaultProperty(String propertyName) {
        return defaultProperty.get(propertyName);
    }

    public void setDefaultProperty(String propertyName,String propertyValue) {
        this.defaultProperty.put(propertyName,propertyValue);
    }
}
