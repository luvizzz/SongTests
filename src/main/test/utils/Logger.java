package main.test.utils;

import java.util.Map;

public class Logger {

    private static String logLevel;

    public Logger() {
        ReadConfigProperties readConfigProperties = new ReadConfigProperties();
        Map<String, String> properties = readConfigProperties.getConfigProperties();

        logLevel = properties.get("logLevel");
    }

    public static void log(String msg){
        if(logLevel.equals("output")){
            System.out.println(msg);
        }
    }
}
