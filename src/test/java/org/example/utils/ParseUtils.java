package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {
    public static String Pars(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "text not found ";
        }
    }
}
