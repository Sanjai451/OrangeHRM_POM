package com.orangeHRM.seleniumUI.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUtility {
	
	static Properties properties;
	static String PATH = "./src/test/resources/OrangeHRMCommonData/common_data.properties";	
	
	static{
		try(FileInputStream fileInputStream = new FileInputStream(PATH);){
			properties = new Properties();
			properties.load(fileInputStream);
			System.out.println("Properties : " + properties);
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String readData(String key) {
		return properties.get(key).toString();
	}
	public void setPropertyValue(String key, String value) {
        try (
            FileInputStream fis = new FileInputStream(PATH);
            FileOutputStream fos = new FileOutputStream(PATH)
        ) {
            Properties properties = new Properties();
            properties.load(fis);

            properties.setProperty(key, value);

            properties.store(fos, "Updated property");

        } catch (Exception e) {
            throw new RuntimeException("Failed to write property", e);
        }
    }
}
