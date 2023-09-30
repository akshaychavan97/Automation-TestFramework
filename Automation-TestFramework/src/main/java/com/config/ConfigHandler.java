package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {
    private static ConfigHandler instance = null;
    private Properties properties;

    private ConfigHandler() {
        properties = new Properties();
        try {
            // Load the properties file from the classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IOException("config.properties not found in classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public static ConfigHandler getInstance() {
        if (instance == null) {
            instance = new ConfigHandler();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
