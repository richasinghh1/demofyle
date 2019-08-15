package com.example.fyle.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecurityProperties {
	public static Properties loadProperties() throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = SecurityProperties.class
          .getClassLoader()
          .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }

}
