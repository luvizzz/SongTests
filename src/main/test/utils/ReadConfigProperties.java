package main.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadConfigProperties {

    private String defaultPath = "src/main/test/utils/config.properties";

    public ReadConfigProperties(){}

    public Map<String,String> getConfigProperties() {
        return getConfigProperties(defaultPath);
    }

    public Map<String,String> getConfigProperties(String filePath) {

        Properties prop = new Properties();
        InputStream input = null;
        Map<String, String> properties = new HashMap<>();

        try {

            input = new FileInputStream(filePath);

            prop.load(input);

            for(PropertiesList list : PropertiesList.values()){
                properties.put(list.toString(), prop.getProperty(list.toString()));
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
