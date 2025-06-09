package org.example.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {
    public static String pars (String regex, String text) {
        Map<String,String> indexMap = Map.of(
            "password","[a-zA-Z0-9]+(_sauce)",
            "login","[a-zA-Z0-9]+(_user)",
                "money","[0-9.]+"
        );
        Pattern pattern = Pattern.compile(indexMap.get(regex));
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "text not found ";
        }
    }
}
