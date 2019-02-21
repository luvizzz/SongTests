package main.test.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringParser {

    public static Map<String, String> extractParametersFromURL(String url){
        //sample input: String : "https://api.spotify.com/v1/browse/categories?offset=20&limit=20"
        //sample output: Map of Strings: [{offset, 20}, {limit, 20}]
        Map<String, String> content = new HashMap<>();

        String parametersString = url.substring(url.indexOf("?") + 1) ;

        int currentParameter;
        int amountOfParameters = countAmountOf("&", parametersString) + 1;

        for(currentParameter = 0; currentParameter < amountOfParameters; currentParameter++){
            String key = parametersString.substring(0, parametersString.indexOf("="));

            String value;
            if (amountOfParameters == currentParameter + 1) {
                value = parametersString.substring(parametersString.indexOf("=") + 1);
            } else {
                value = parametersString.substring(parametersString.indexOf("=") + 1, parametersString.indexOf("&"));
                parametersString = parametersString.substring(parametersString.indexOf("&") + 1);
            }

            content.put(key, value);
        }

        return  content;
    }

    private static int countAmountOf(String searchKey, String input){
        //Sample input: Strings: &, offset=20&limit=20
        //Sample output: 1
        int searchSize = searchKey.length();

        if(searchSize > input.length()) return 0;

        int currentPosition, amount = 0;
        for(currentPosition = 0; currentPosition < (input.length() - searchSize); currentPosition++){
            if(searchKey.equals(input.substring(currentPosition, currentPosition + searchSize))) amount++;
        }
        return amount;
    }

    public static String buildParameters(List<String> parameters){
        String concatenatedString = "";

        if(parameters.isEmpty()) return "";

        for(int currentParameter=0; currentParameter < parameters.size(); currentParameter++){
            concatenatedString += parameters.get(currentParameter) + ",";
        }

        concatenatedString = concatenatedString.substring(0, concatenatedString.length() -1);

        return concatenatedString;
    }

}
