package com.sendgrid.util;

public class Matcher {
    /*
     * responseCode: Response Code received via API call.
     * responseCodePattern: response code pattern mentioned in open api spec.
     */
    public static boolean matches(String responseCode, String responseCodePattern) {
        // Escape all characters in the responseCodePattern except 'x'
        StringBuilder regex = new StringBuilder();
        for (char ch : responseCodePattern.toCharArray()) {
            if (ch == 'x') {
                regex.append("\\d");
            } else {
                regex.append(ch);
            }
        }
        String regexPattern = regex.toString();
        return responseCode.matches(regexPattern);
    }
}
