package com.orangeHRM.seleniumUI.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUtility {
	
	static Properties properties;
	
	static{
		try(FileInputStream fileInputStream = new FileInputStream("./src/test/resources/OrangeHRMCommonData/common_data.properties");){
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
}
