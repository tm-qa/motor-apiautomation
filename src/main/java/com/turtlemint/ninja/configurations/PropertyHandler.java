package com.turtlemint.ninja.configurations;

import org.codehaus.groovy.util.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {
        Properties properties;
        FileInputStream inputStream;

        public PropertyHandler(String fileName) {
            String filePath = System.getProperty("user.dir")+ "/src/test/resources/";
            try{
                inputStream = new FileInputStream(filePath + fileName);
                properties= new Properties();
                properties.load(inputStream);
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String getProperty(String key) throws IOException {
            String value = properties.getProperty(key);
            inputStream.close();
            return  value;
        }



}
