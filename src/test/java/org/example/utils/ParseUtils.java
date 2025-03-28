package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {
    public static String pars(String nameField, String text) {
        String regex = "";
        String regex_login = "[a-zA-Z0-9]+(_user)";
        String regex_password = "[a-zA-Z0-9]+(_sauce)";
        String regex_buy = "[0-9.]+";
        if (nameField.equals("password")) {
            regex = regex_password;
        } else if (nameField.equals("money")) {
            regex = regex_buy;
        } else if (nameField.equals("login")) {
            regex = regex_login;
        } else {
            System.out.println("No regex");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "text not found ";
        }
    }
}
