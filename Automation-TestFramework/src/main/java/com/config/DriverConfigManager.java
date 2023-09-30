package com.config;

import java.util.HashMap;
import java.util.Map;

public class DriverConfigManager {
    private DriverConfigManager() {
        // Private constructor to prevent instantiation
    }
    private Map<String, String> configData = new HashMap<>();

    private static DriverConfigManager instance = null;
    public static DriverConfigManager getInstance() {
        if (instance == null) {
            instance = new DriverConfigManager();
        }
        return instance;
    }
    ConfigHandler config=ConfigHandler.getInstance();
    public void setConfig(){
        configData.put("browser",config.getProperty("browser"));
    }
    public String getConfig(String congiName){
        return configData.get(congiName);
    }


}
