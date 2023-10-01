package com.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.util.TestUtil.isWindows;

public class TestConfigManager {
    private TestConfigManager() {
        // Private constructor to prevent instantiation
    }
    private Map<String, String> configData = new HashMap<>();


    private static TestConfigManager instance = null;
    public static TestConfigManager getInstance() {
        if (instance == null) {
            instance = new TestConfigManager();
        }
        return instance;
    }
    ConfigHandler config=ConfigHandler.getInstance();
    public void setConfig(){
        configData.put("browser",config.getProperty("browser"));
        configData.put("base64img",config.getProperty("base64img"));
        String extentPath=null;
        if (Boolean.TRUE.equals(isWindows())){
            extentPath=System.getProperty("user.dir")+"\\output\\html\\TestResult_"+new Date().toString().replace(":","_").replace(" ","_")+".html";
        }else {
            extentPath=System.getProperty("user.dir")+"/output/html/TestResult_"+new Date().toString().replace(":","_").replace(" ","_")+".html";
        }
        configData.put("extentReportPath",extentPath);

    }
    public String getConfig(String congiName){

        return configData.get(congiName);
    }



}
