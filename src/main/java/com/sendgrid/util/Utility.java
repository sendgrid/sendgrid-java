package com.sendgrid.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiException;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Utility {
    public static String buildWithPathParams(String path, Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String placeholder = "\\{" + entry.getKey() + "\\}";
            path = path.replaceAll(placeholder, entry.getValue());
        }
        return path;
    }

    public static String buildWithQueryParams(String path, Map<String, List<String>> queryParams) {
        if (queryParams.isEmpty()) {
            return path;
        }
        StringJoiner joiner = new StringJoiner("&");
        queryParams.forEach((key, values) -> {
            values.forEach(value -> {
                joiner.add(key + "=" + value); // In case all query parameter needs to be URL Encoded, encode value here.
            });
        });
        path = path + "?" + joiner.toString();
        return path;
    }
}
