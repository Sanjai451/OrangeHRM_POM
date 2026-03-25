package com.orangeHRM.seleniumUI.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileUtility {

    private String path;

    public FileUtility(String path) {
        this.path = path;
    }

    public String getPropertyValue(String key) {
        try (FileInputStream fis = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read property", e);
        }
    }

    public void setPropertyValue(String key, String value) {
        try (
            FileInputStream fis = new FileInputStream(path);
            FileOutputStream fos = new FileOutputStream(path)
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