package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    private PropertiesReader() {
    }

    public static String readProperty(String propertyName) {
        if (properties.isEmpty()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test.config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return properties.getProperty(propertyName);
    }

    public static String readUrlProperty(String propertyName) {
        if (properties.isEmpty()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test.config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return properties.getProperty("baseUrl").concat(properties.getProperty(propertyName));
    }
}
