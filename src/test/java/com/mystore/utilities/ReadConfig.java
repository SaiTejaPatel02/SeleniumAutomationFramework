package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties properties;
	String path = "/Users/saitejapatel/eclipse-workspace/SeleniumAutomationFramework/Configuration/config.properties";
	
	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
}
